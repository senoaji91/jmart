package senoJmartMH;


/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Payment extends Invoice implements Transactor
{
    public int productId;
    public Shipment shipment;

    public Payment(int id, int buyerId, int productId, int productCount, Shipment shipment)
    {
        super(id,buyerId,productId);
        this.productId = productId;
        this.shipment = shipment;
    }

    public boolean validate()
    {
        return false;
    }

    @Override
    public Invoice perform()
    {
        return null;
    }

    @Override
    public boolean read(String content)
    {
        return false;
    }
    
    @Override
    public double getTotalPay()
    {
        return 0.0f;
    }
}