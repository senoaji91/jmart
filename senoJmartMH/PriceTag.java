package senoJmartMH;


/**
 * Write a description of class PriceTag here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PriceTag
{
    // instance variables - replace the example below with your own
    private int x;
        
    public final double COMMISSION_MULTIPLIER = 0.05;
    public final double BOTTOM_PRICE = 20000.0;
    public final double BOTTOM_FEE = 1000.0;
    double price;
    double discount;

    /**
     * Constructor for objects of class PriceTag
     */
    public PriceTag(double price)
    {
        this.price = price;
        this.discount = 0.0;
        // initialise instance variables
        //x = 0;
    }
    
    public PriceTag(double price, double discount)
    {
        this.price = price;
        this.discount = discount;
    }

    public double getAdjustedPrice()
    {
        return getDiscountedPrice() + getAdminFee();
    }
    
    public double getAdminFee()
    {
        if(getDiscountedPrice() < BOTTOM_PRICE) return BOTTOM_PRICE;
        return getDiscountedPrice() * COMMISSION_MULTIPLIER;
    }
    
    private double getDiscountedPrice()
    {
        if(this.discount >= 100.0) return 0.0;
        return (this.price - (this.price * (this.discount / 100.0f)));
    }

}
