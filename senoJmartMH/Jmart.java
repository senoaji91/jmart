package senoJmartMH;


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
        create();
    }
    
   
    public static Product create()
    {
        PriceTag pt = new PriceTag(1000,0);
        Product tes = new Product("Tes1", 20, false, pt, ProductCategory.BOOK);
        return tes;
    }
    
    public static Product createProduct()
    {
        return null;
    }
    
    public static Coupon createCoupon()
    {
        return null;
    }
    
    public static ShipmentDuration ShipmentDuration()
    {
        return null;
    }
}