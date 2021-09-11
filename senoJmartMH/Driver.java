package senoJmartMH;


/**
 * Write a description of class Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Driver
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Driver
     */
    public Driver()
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
    
        public void main (String args[]){
        getPromo();
    }
    
    public int getPromo(){
        return 0;
    }
    
    public String getCustomer(){
        return "oop";
    }
    
    public float getDiscountPercentage(int before, int after) {
        if (before < after){
            return 0.0f;
        }else{
            return((before - after)/before)*100;
        }
    }
    
    public float getDiscountedPrice(int price, float discountPercentage) {
        if (discountPercentage > 100.0f){
            return 0;
        } else{
            return (int)(price - (price*discountPercentage/100));
        }
    }
    
    public float getCommissionMultiplier() {
        return 0.05f;
    }
    
    public int getAdjustedPrice(int price, float commissionMultiplier) {
        return (int)(price + (price*commissionMultiplier/100));
    }
    
    public float getAdminFee(int price, float commissionMultiplier){
        return (int)(price*commissionMultiplier);
    }
}
