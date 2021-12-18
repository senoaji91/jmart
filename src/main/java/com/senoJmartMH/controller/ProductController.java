package com.senoJmartMH.controller;

/**
 * Class ProductController - Class untuk menghandle aliran data dari object product
 *
 * @author Seno Aji Wicaksono
 * @version 18-12-2021
 */

import com.senoJmartMH.*;
import com.senoJmartMH.dbjson.JsonAutowired;
import com.senoJmartMH.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product>{
    public static @JsonAutowired(value= Product.class, filepath="randomProductList.json") JsonTable<Product> productTable;

    //Get seller's products
    @GetMapping("/{id}/page")
    @ResponseBody List<Product> getProducts(@PathVariable int id, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="1000") int pageSize){
        List<Product> productList = new ArrayList<>();
        Account accountTarget = Algorithm.<Account>find(AccountController.accountTable,  a -> a.id == id);
        if(accountTarget != null){
            for(Product product : ProductController.productTable){
                for(Payment payment : PaymentController.paymentTable){
                    if(payment.productId == product.id && product.accountId == accountTarget.id){
                        productList.add(product);
                    }
                }
            }
        }
        return Algorithm.paginate(productList, page, pageSize, e->true);
    }

    //Get product of seller's purchases
    @GetMapping("/{id}/purchases/page")
    @ResponseBody List<Product> getMyProducts(@PathVariable int id, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="1000") int pageSize){
        List<Product> productList = new ArrayList<>();
        List<Payment> paymentList = Algorithm.<Payment>paginate(PaymentController.paymentTable, page, pageSize, p -> p.buyerId == id);
        for(Product product : getJsonTable()){
            for(Payment payment : paymentList){
                if(payment.productId == product.id){
                    productList.add(product);
                }
            }
        }
        return Algorithm.<Product>paginate(productList, page, pageSize, e -> true);
    }

    @PostMapping("/create")
    Product create(@RequestParam int accountId, @RequestParam String name, @RequestParam int weight, @RequestParam boolean conditionUsed, @RequestParam double price, @RequestParam double discount, @RequestParam ProductCategory category, @RequestParam byte shipmentPlans){
        for(Account account : AccountController.accountTable){
            if(account.id == accountId && account.store != null){
                Product newProduct = new Product(accountId, name, weight, conditionUsed, price, discount, category, shipmentPlans);
                productTable.add(newProduct);
                return newProduct;
            }
        }
        return null;
    }
    public JsonTable<Product> getJsonTable() {
        return productTable;
    }
    @GetMapping("/{id}/store")
    List<Product> getProductByStore(@RequestParam int id, @RequestParam int page, @RequestParam int pageSize){
        return Algorithm.<Product>paginate(getJsonTable(),page,pageSize, p -> (p.accountId == id));
    }
    @GetMapping("/getFiltered")
    List<Product> getProductFiltered(@RequestParam(defaultValue="0")  int page, @RequestParam(defaultValue="5")  int pageSize,
                                     @RequestParam  int accountId, @RequestParam  String search,
                                     @RequestParam  int minPrice, @RequestParam  int maxPrice,
                                     @RequestParam  ProductCategory category)
    {
        Predicate<Product> pred = p -> ((p.accountId == accountId) && (p.name.toLowerCase().contains(search.toLowerCase())) && (p.price >= minPrice && p.price <= maxPrice) && (p.category == category));
        return Algorithm.<Product>paginate(getJsonTable(),page,pageSize, pred);
    }


}
