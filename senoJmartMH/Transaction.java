package senoJmartMH;


/**
 * Write a description of class Transaction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Transaction extends Recognizable
{
    public String time = "Time";
    public int buyerId;
    public int storeId;
    public Rating rating = Rating.NONE;

    public enum Rating
    {
        NONE,
        BAD,
        NEUTRAL,
        GOOD
    }

    protected Transaction(int id, int buyerId, int storeId) 
    {
        super(id);
        this.buyerId = buyerId;
        this.storeId = storeId;
    }

    protected Transaction(int id, Account buyer, Store store)
    {
        super(id);
        this.buyerId = buyer.id;
        this.storeId = store.id;
    }
    
    public boolean validate()
    {
        return false;
    }

    public Transaction perform()
    {
        return null;
    }
}
