package com.senoJmartMH.controller;

import com.senoJmartMH.*;
import com.senoJmartMH.dbjson.JsonAutowired;
import com.senoJmartMH.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>
{
    public static final long DELIVERED_LIMIT_MS = 69;
    public static final long ON_DELIVERY_LIMIT_MS = 69;
    public static final long ON_PROGRESS_LIMIT_MS = 69;
    public static final long WAITING_CONF_LIMIT_MS = 69;

    @JsonAutowired(value = Payment.class, filepath = "payment.json")
    public static JsonTable<Payment> paymentTable;

    public static ObjectPoolThread<Payment> poolThread;
    static
    {
        poolThread = new ObjectPoolThread<>("iniadalahmessage", PaymentController::timekeeper);
        poolThread.start();
    }

    @Override
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    @PostMapping("/create")
    Payment create
            (
                    @RequestParam int buyerId,
                    @RequestParam int productId,
                    @RequestParam int productCount,
                    @RequestParam String shipmentAddress,
                    @RequestParam byte shipmentPlan
            )
    {
        Account account = Algorithm.<Account>find(AccountController.accountTable, obj -> obj.id == buyerId);
        Product product = Algorithm.<Product>find(ProductController.productTable, obj -> obj.id == productId);
        if(product == null || account == null) return null;
        Payment payment = new Payment(buyerId, productId, productCount, new Shipment(shipmentAddress, 0, shipmentPlan, null));
        if(account.balance < payment.getTotalPay(product)) return null;
        payment.history.add(new Payment.Record(Invoice.Status.WAITING_CONFIRMATION, "iniadalahmessage"));
        account.balance -= payment.getTotalPay(product);
        paymentTable.add(payment);
        poolThread.add(payment);
        return payment;
    }

    @PostMapping("/{id}/accept")
    boolean accept
            (
                    @PathVariable int id
            )
    {
        Payment payment = Algorithm.<Payment>find(paymentTable, obj -> obj.id == id);
        if(payment == null) return false;
        Payment.Record record = payment.history.get(payment.history.size() - 1);
        if(record.status != Invoice.Status.WAITING_CONFIRMATION) return false;
        payment.history.add(new Payment.Record(Invoice.Status.ON_PROGRESS, "iniadalahmessage"));
        return true;
    }

    @PostMapping("/{id}/cancel")
    boolean cancel
            (
                    @PathVariable int id
            )
    {
        Payment payment = Algorithm.<Payment>find(paymentTable, obj -> obj.id == id);
        if(payment == null) return false;
        Payment.Record record = payment.history.get(payment.history.size() - 1);
        if(record.status != Invoice.Status.WAITING_CONFIRMATION) return false;
        payment.history.add(new Payment.Record(Invoice.Status.CANCELLED, "iniadalahmessage"));
        return true;
    }

    @PostMapping("/{id}/submit")
    boolean submit
            (
                    @PathVariable int id,
                    @RequestParam String receipt
            )
    {
        Payment payment = Algorithm.<Payment>find(paymentTable, obj -> obj.id == id);
        if(payment == null) return false;
        Payment.Record record = payment.history.get(payment.history.size() - 1);
        if(record.status != Invoice.Status.ON_PROGRESS) return false;
        if(receipt.isBlank()) return false;
        payment.history.add(new Payment.Record(Invoice.Status.ON_DELIVERY, "iniadalahmessage"));
        return true;
    }

    private static boolean timekeeper(Payment payment)
    {
        Payment.Record record = payment.history.get(payment.history.size() - 1);
        long elapsed = Math.abs(record.date.getTime() - (new Date()).getTime());

        if(record.status == Invoice.Status.WAITING_CONFIRMATION && elapsed > WAITING_CONF_LIMIT_MS)
        {
            payment.history.add(new Payment.Record(Invoice.Status.FAILED, "iniadalahmessage"));
            return true;
        } else if(record.status == Invoice.Status.ON_PROGRESS && elapsed > ON_PROGRESS_LIMIT_MS)
        {
            payment.history.add(new Payment.Record(Invoice.Status.FAILED, "iniadalahmessage"));
            return true;
        } else if(record.status == Invoice.Status.ON_DELIVERY && elapsed > ON_DELIVERY_LIMIT_MS)
        {
            payment.history.add(new Payment.Record(Invoice.Status.DELIVERED, "iniadalahmessage"));
            return false;
        } else if(record.status == Invoice.Status.DELIVERED && elapsed > DELIVERED_LIMIT_MS)
        {
            payment.history.add(new Payment.Record(Invoice.Status.FINISHED, "iniadalahmessage"));
            return true;
        }
        return false;
    }
}
