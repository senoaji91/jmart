package com.senoJmartMH;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import java.util.stream.Collectors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Jmart
{
    public static long DELIVERED_LIMIT_MS = 100;
    public static long ON_DELIVERY_LIMIT_MS = 100;
    public static long ON_PROGRESS_LIMIT_MS = 100;
    public static long WAITING_CONF_LIMIT_MS = 100;

    public static boolean paymentTimekeeper(Payment payment) {
        Payment.Record record = payment.history.get(payment.history.size() - 1);
        long elapsed = Math.abs(record.date.getTime() - (new Date()).getTime());

        if(record.status == Invoice.Status.WAITING_CONFIRMATION && elapsed > WAITING_CONF_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.FAILED, "WAITING"));
            return true;
        } else if(record.status == Invoice.Status.ON_PROGRESS && elapsed > ON_PROGRESS_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.FAILED, "PROGRESS"));
            return true;
        } else if(record.status == Invoice.Status.ON_DELIVERY && elapsed > ON_DELIVERY_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.DELIVERED, "DELIVERY"));
            return false;
        } else if(record.status == Invoice.Status.DELIVERED && elapsed > DELIVERED_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.FINISHED, "FINISH"));
            return true;
        }
        return false;
    }

    public static void main (String[] args){
//        System.out.println("account id:" + new Account(null, null, null, -1).id);
//        System.out.println("account id:" + new Account(null, null, null, -1).id);
//        System.out.println("account id:" + new Account(null, null, null, -1).id);
//
//        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
//        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
//        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);

//        try{
//            List<Product> list = read("src/randomProductList.json");
//            List<Product> filtered = filterByPrice(list, 20000.0, 25000.0);
//            filtered.forEach(product -> System.out.println(product.price));
//
//            List<Product> filteredName = filterByName(list, "gtx", 1, 5);
//            filteredName.forEach(product -> System.out.println(product.name));
//
//            List<Product> filteredAccount = filterByAccountId(list, 1, 0, 5);
//            filteredAccount.forEach(product -> System.out.println(product.name));
//        }catch (Throwable t)
//        {
//            t.printStackTrace();
//        }

//        try {
//            String filepath = "account.json";
//            JsonTable<Account> tableAccount = new JsonTable<>(Account.class, filepath);
//            tableAccount.add(new Account("name", "email", "password"));
//            tableAccount.writeJson();
//
//            tableAccount = new JsonTable<>(Account.class, filepath);
//            tableAccount.forEach(account -> System.out.println(account.toString()));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        SpringApplication.run(Jmart.class, args);
//        try{
//            JsonTable<Payment> table = new JsonTable<>(Payment.class, "src/randomPaymentList.Json");
//            ObjectPoolThread<Payment> paymentPool = new ObjectPoolThread<Payment>("Thread-PP", Jmart::paymentTimekeeper);
//            paymentPool.start();
//
//            table.forEach(payment -> paymentPool.add(payment));
//            while(paymentPool.size() !=0);
//            paymentPool.exit();
//
//            while (paymentPool.isAlive());
//            System.out.println("Thread exited successfully");
//            Gson gson = new Gson();
//            table.forEach(payment-> {
//                String history = gson.toJson(payment.history);
//                System.out.println(history);
//            });
//        }catch (Throwable t)
//        {
//            t.printStackTrace();
//        }
    }



    public static List<Product> read(String filepath) throws FileNotFoundException
    {
        List<Product> product = new ArrayList<>();
        try
        {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(filepath));
            reader.beginArray();
            while(reader.hasNext())
            {
                product.add(gson.fromJson(reader, Product.class));
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return product;
    }

//    public static List<Product> filterByCategory(List<Product> list, ProductCategory category)
//    {
//        List<Product> products = new ArrayList<>();
//        for(Product product : list)
//        {
//            if(product.category.equals(category))
//            {
//                products.add(product);
//            }
//        }
//        return products;
//    }

//    public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice)
//    {
//        List<Product> products = new ArrayList<>();
//        for(int i = 0; i < list.size(); i++)
//        {
//            if(minPrice <= 0.0)
//            {
//                if(list.get(i).price <= maxPrice)
//                {
//                    products.add(list.get(i));
//                }
//            }else if(maxPrice <= 0.0){
//                if(list.get(i).price >= minPrice)
//                {
//                    products.add(list.get(i));
//                }
//            }else
//            {
//                if(list.get(i).price >= minPrice && list.get(i).price <= maxPrice)
//                {
//                    products.add(list.get(i));
//                }
//            }
//        }
//        return products;
//    }

    private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred)
    {
        if(page<0){
            page = 0;
        }
        if(pageSize<0){
            pageSize = 0;
        }
        return list.stream().filter(a -> pred.predicate(a)).skip(page * pageSize).limit(pageSize).collect(Collectors.toList());
    }

    public static List<Product> filterByName(List<Product> list, String search, int page, int pageSize)
    {
        Predicate<Product> predicate = a -> (a.name.toLowerCase().contains(search.toLowerCase()));
        return paginate(list, page, pageSize, predicate);
    }

    public static List<Product> filterByAccountId(List<Product> list, int accountId, int page, int pageSize)
    {
        Predicate<Product> predicate = a -> (a.accountId == accountId);
        return paginate(list, page, pageSize, predicate);
    }

    public static List<Product> filterByCategory(List<Product> list, ProductCategory category) {
        return list.stream().filter(a -> a.category == category).collect(Collectors.toList());
    }

    public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice) {
        if(minPrice == 0) list.stream().filter(a -> a.price <= maxPrice).collect(Collectors.toList());
        if(maxPrice == 0) list.stream().filter(a -> a.price >= minPrice).collect(Collectors.toList());
        return list.stream().filter(a -> a.price >= minPrice).filter(a -> a.price <= maxPrice).collect(Collectors.toList());
    }
}