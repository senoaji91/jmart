package com.senoJmartMH.controller;

/**
 * Class PaymentController - Class untuk menghandle aliran data dari object payment
 *
 * @author Seno Aji Wicaksono
 * @version 18-12-2021
 */

import com.senoJmartMH.*;
import com.senoJmartMH.dbjson.JsonAutowired;
import com.senoJmartMH.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    public static final long DELIVERED_LIMIT_MS = 1000;
    public static final long ON_DELIVERY_LIMIT_MS = 1000;
    public static final long ON_PROGRESS_LIMIT_MS = 1000;
    public static final long WAITING_CONF_LIMIT_MS = 1000;
    public static @JsonAutowired(value = Payment.class, filepath = "payment.json")
    JsonTable<Payment> paymentTable;
    public static ObjectPoolThread<Payment> poolThread = new ObjectPoolThread<Payment>("Thread", PaymentController::timekeeper);

    //Get invoices of seller's products
    @GetMapping("/{id}/page")
    @ResponseBody List<Payment> getInvoices(@PathVariable int id, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="1000") int pageSize){
        List<Payment> paymentList = new ArrayList<>();
        Account accountTarget = Algorithm.<Account>find(AccountController.accountTable,  a -> a.id == id);
        if(accountTarget != null){
            for(Payment payment : paymentTable){
                for(Product product : ProductController.productTable){
                    if(payment.productId == product.id && product.accountId == accountTarget.id){
                        paymentList.add(payment);
                    }
                }
            }
        }
        return Algorithm.paginate(paymentList, page, pageSize, e->true);
    }

    //Get invoices of seller's purchases
    @GetMapping("/{id}/purchases/page")
    @ResponseBody List<Payment> getMyInvoices(@PathVariable int id, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="1000") int pageSize){
        return Algorithm.<Payment>paginate(getJsonTable(), page, pageSize, p -> p.buyerId == id);
    }

    @PostMapping("/{id}/accept")
    boolean accept(@PathVariable int id) {
        for(Payment payment : paymentTable){
            if(payment.id == id){
                if(payment.history.get(payment.history.size() - 1).status == Invoice.Status.WAITING_CONFIRMATION){
                    payment.history.add(new Payment.Record(Invoice.Status.ON_PROGRESS, "ON_PROGRESS"));
                    return true;
                }
            }
        }
        return false;
    }

    @PostMapping("/{id}/cancel")
    boolean cancel(@PathVariable int id) {
        for(Payment payment : paymentTable){
            if(payment.id == id){
                if(payment.history.get(payment.history.size() - 1).status == Invoice.Status.WAITING_CONFIRMATION){
                    payment.history.add(new Payment.Record(Invoice.Status.CANCELLED, "CANCELLED"));
                    return true;
                }
            }
        }
        return false;
    }

    @PostMapping("/create")
    Payment create(@RequestParam int buyerId, @RequestParam int productId, @RequestParam int productCount, @RequestParam String shipmentAddress, @RequestParam byte shipmentPlan) {
        for(Account account : AccountController.accountTable){
            if(account.id == buyerId){
                for(Product product : ProductController.productTable){
                    if(product.accountId == productId){
                        Payment newPayment = new Payment(buyerId, productId, productCount, new Shipment(shipmentAddress, 0, shipmentPlan, null));
                        double totalPay = newPayment.getTotalPay(product);
                        if(account.balance >= totalPay){
                            account.balance -= totalPay;
                            newPayment.history.add(new Payment.Record(Invoice.Status.WAITING_CONFIRMATION, "WAITING_CONFIRMATION"));
                            paymentTable.add(newPayment);
                            poolThread.add(newPayment);
                            return newPayment;
                        }
                    }
                }
            }
        }
        return null;
    }

    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    @PostMapping("/{id}/submit")
    boolean submit(@PathVariable int id, String receipt) {
        for(Payment payment : paymentTable){
            if(payment.id == id){
                if(payment.history.get(payment.history.size() - 1).status == Invoice.Status.ON_PROGRESS){
                    if(!receipt.isBlank()){
                        payment.shipment.receipt = receipt;
                        payment.history.add(new Payment.Record(Invoice.Status.ON_DELIVERY, "ON_DELIVERY"));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static Boolean timekeeper(Payment payment) {
        if (payment.history.isEmpty()) {
            return false;
        } else {
            Payment.Record record = payment.history.get(payment.history.size() - 1);
            long elapsed = System.currentTimeMillis() - record.date.getTime();
            if (record.status.equals(Invoice.Status.WAITING_CONFIRMATION) && (elapsed > WAITING_CONF_LIMIT_MS)) {
                record.status = Invoice.Status.FAILED;
                return true;
            } else if (record.status.equals(Invoice.Status.ON_PROGRESS) && (elapsed > ON_PROGRESS_LIMIT_MS)) {
                record.status = Invoice.Status.FAILED;
                return true;
            } else if (record.status.equals(Invoice.Status.ON_DELIVERY) && (elapsed > ON_PROGRESS_LIMIT_MS)) {
                record.status = Invoice.Status.DELIVERED;
                return true;
            } else if (record.status.equals(Invoice.Status.DELIVERED) && (elapsed > DELIVERED_LIMIT_MS)) {
                record.status = Invoice.Status.FINISHED;
                return true;
            } else {
                return false;
            }
        }
    }
}
