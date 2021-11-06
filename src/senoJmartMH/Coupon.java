package senoJmartMH;


/**
 * Write a description of class Coupon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coupon extends Serializable
{
    private boolean used;
    public String name;
    public int code;
    public Type type;
    public double cut;
    public double minimum;
    
    public enum Type
    {
        DISCOUNT, REBATE
    }
    
    public Coupon(int id, String name, int code, Type type, double cut, double minimum)
    {
        super(id);
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
        this.used = false;
    }
    
    public boolean isUsed()
    {
        return this.used;
    }
    
    public boolean canApply(Treasury treasury)
    {
        if (treasury.getAdjustedPrice() >= minimum & used == false) return true;
        else return false;
    }
    
    public double apply (Treasury treasury){
       this.used = true;
       if (type == Type.DISCOUNT){
           return (treasury.getAdjustedPrice() * ((100 - this.cut)/100));
       }
       else{
           return (treasury.getAdjustedPrice() - this.cut);
       }
    }

}
