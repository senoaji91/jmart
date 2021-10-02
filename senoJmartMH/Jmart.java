package senoJmartMH;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jmart
{    
    public static void main (String[] args)
    {
        System.out.println(Shipment.Duration.KARGO.getEstimatedArrival(new Date()));
        Store store = new Store(1,"Test Name", "Test Address", "08123456789");
        store.validate();
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
}