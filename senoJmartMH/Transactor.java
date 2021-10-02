package senoJmartMH;


/**
 * Write a description of class Transaction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Transactor
{
    /*public String time = "Time";
    public int buyerId;
    public int storeId;
    public Rating rating = Rating.NONE;

    public enum Rating {
        NONE,
        BAD,
        NEUTRAL,
        GOOD
    }

    protected Transactor(int id, int buyerId, int storeId)
    {
        super(id);
        this.buyerId = buyerId;
        this.storeId = storeId;
    }

    protected Transactor(int id, Account buyer, Store store)
    {
        super(id);
        this.buyerId = buyer.id;
        this.storeId = store.id;
    }*/
    
    public default boolean validate()
    {
        return false;
    }

    public default Invoice perform()
    {
        return null;
    }
}
