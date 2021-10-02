package senoJmartMH;

import java.util.Date;
/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Invoice extends Recognizable implements FileParser
{
    public Date date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public Status status;

    public enum Status {
         WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY, COMPLAINT, FINISHED, FAILED
    }

    public enum Rating {
        NONE,BAD,NEUTRAL,GOOD
    }

    protected Invoice(int id, int buyerId, int productId)
    {
        super(id);
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = new Date();
        this.rating = Rating.NONE;
        this.status = Status.WAITING_CONFIRMATION;
    }
    @Override
    public boolean read(String content){
        return false;
    }
    public abstract double getTotalPay();
}
