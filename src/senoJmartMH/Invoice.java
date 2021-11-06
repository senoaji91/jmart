package senoJmartMH;

import java.util.Date;
import java.util.ArrayList;
/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Invoice extends Serializable
{
    public int buyerId;
    public int complaintId;
    public Date date;
    public ArrayList<Record> history = new ArrayList<>();
    public int productId;
    public Rating rating;
    public Status status;

    public enum Status
    {
        WAITING_CONFIRMATION,
        CANCELLED,
        ON_PROGRESS,
        ON_DELIVERY,
        COMPLAINT,
        FINISHED,
        FAILED
    }

    public enum Rating
    {
        NONE,
        BAD,
        NEUTRAL,
        GOOD
    }

    class Record
    {
        public Status status;
        public Date date;
        public String message;
    }

    protected Invoice(int buyerId, int productId)
    {
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = new Date();
        this.rating = Rating.NONE;
        this.status = Status.WAITING_CONFIRMATION;
        this.complaintId = -1;
    }

    public double getTotalPay() {
        return 0.0f;
    }
}
