package senoJmartMH;


/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Payment extends Invoice
{
    public Shipment shipment;
    public int productCount;

    Payment(int buyerId, int productId, int productCount, Shipment shipment) {
        super(buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
    }

    @Override
    public double getTotalPay() {
        return 0.0f;
    }

    public boolean validate() {
        return false;
    }

}