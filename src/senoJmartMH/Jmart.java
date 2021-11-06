package senoJmartMH;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

public class Jmart
{
    class Country
    {
        public String name;
        public int population;
        public List<String> listOfStates;
    }
    public static void main (String[] args)
    {
        System.out.println("account id:" + new Account(null, null, null, -1).id);
        System.out.println("account id:" + new Account(null, null, null, -1).id);
        System.out.println("account id:" + new Account(null, null, null, -1).id);

        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);
        System.out.println("payment id:" + new Payment(-1, -1, -1, null).id);

//        String filepath = "src/senoJmartMH/city.json";
//        Gson gson = new Gson();
//        try
//        {
//            BufferedReader br = new BufferedReader(new FileReader(filepath));
//            Country input = gson.fromJson(br, Country.class);
//            System.out.println("name: " + input.name);
//            System.out.println("population: " + input.population);
//            System.out.println("states:");
//            input.listOfStates.forEach(state -> System.out.println(state));
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }


//        System.out.println(Shipment.Duration.KARGO.getEstimatedArrival(new Date()));
//        Store store = new Store(1,"Test Name", "Test Address", "08123456789");
//        store.validate();
//        Complaint complaint = new Complaint(001, "Pengiriman tidak cepat, kurir tersesat");
//        System.out.print(complaint);
//        Account account = new Account(5,"Nama Akun","namaakun@gmail.com","passnamaakun");
//        account.validate();
//        System.out.print(account);
    }
   
    public static Product create()
    {
        /*PriceTag pt = new PriceTag(1000,0);
        Product tes = new Product("Tes1", 20, false, pt, ProductCategory.BOOK), INSTANT;*/
        return null;
    }
    
    public static Product createProduct()
    {
        return null;
    }
    
    public static Coupon createCoupon()
    {
        return null;
    }
    
    public static Shipment shipment()
    {
        return null;
    }

//    public static List<Product> read(String filepath) throws FileNotFoundException
//    {
//        Gson gson = new gson();
//        JsonReader jsonReader = new JsonReader((new FileReader(filepath)));
//        Product[] products = gson.fromJson(jsonReader, Product[].class);
//        List<Product> list = new ArrayList<>();
//        Collections.addAll(list, products);
//        return list;
//    }
}