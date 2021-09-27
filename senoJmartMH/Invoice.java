package senoJmartMH;


/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Invoice extends Recognizable implements FileParser
{
    public String date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public Status status;

    public enum Status {
        WAITING_CONFIRMATION,
        CANCELLED,
        ON_PROGRESS,
        ON_DELIVERY,
        COMPLAINT,
        FINISHED,
        FAILED
    }

    public enum Rating {
        NONE,
        BAD,
        NEUTRAL,
        GOOD
    }

    protected Invoice(int id, int buyerId, int productId)
    {
        super(id);
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = "";
        this.rating = Rating.NONE;
        this.status = status.WAITING_CONFIRMATION;
    }

    @Override
    public boolean read(String content){
        return false;
    }
    
    public double getTotalPay() {
        return 0.0f;
    }
}
