package senoJmartMH;


/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product extends Recognizable implements FileParser
{
    public int storeId; 
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public Shipment.MultiDuration multiDuration;

    public Product(int id, int storeId, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category, Shipment.MultiDuration multiDuration)
    {
        super(id);
        this.storeId = storeId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = new ProductRating();
        this.multiDuration = multiDuration;
    }
    
    @Override
    public boolean read(String content)
    {
        return false;
    }
    
    public String toString()
    {
        return 
        "Name: " + this.name +
        "\nWeight: " + this.weight +
        "\nconditionUsed: " + this.conditionUsed +
        "\npriceTag: " + this.priceTag +
        "\ncategory: " + this.category +
        "\nrating: " + this.rating +
        "\nstoreId: " + this.storeId;
    }
}
