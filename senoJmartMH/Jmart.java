package senoJmartMH;


/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jmart
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Jmart
     */
    public Jmart()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
    
    public void main (String[] message){
    }
    
    public static int getPromo() {
        return 0;
    }
    
    public static String getCustomer() {
        return "oop";
    }
    
    public static float getDiscountPercentage(int before, int after) {
        return before < after ? 0.0f : (before - after) / 100.0f;
    }
    
    public static int getDiscountedPrice(int price, float discountPercentage) {
        if (discountPercentage > 100.0f) {
            discountPercentage = 100.0f;
        }
        return (int) (price * (100.0f - discountPercentage) / 100.0f);
    }
    
    public static int getOriginalPrice(int discountedPrice, float discountPercentage) {
        return (int) (discountedPrice / (100.0f - discountPercentage) * 100.0f);
    }
    
    public static float getCommissionMultiplier(){
        return 0.05f;
    }
    
    public static int getAdjustedPrice(int price){
        return (int) (price * (0.05f + 1.00f));
    }
    
    public static int getAdminFee(int price){
        return (int) (price * 0.05f);
    }
}