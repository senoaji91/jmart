package com.senoJmartMH;


/**
 * Write a description of class ProductRating here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProductRating
{
    // instance variables - replace the example below with your own
    private int x;
    private long total;
    private long count;
    
    /**
     * Constructor for objects of class ProductRating
     */
    public ProductRating()
    {
        // initialise instance variables
        //x = 0;
        this.total = 0;
        this.count = 0;
    }
    
    public void insert(int rating)
    {
        total = total + rating;
        count ++;
    }
    
    public double getAverage()
    {
        if(count != 0)
        {
            return total/count;   
        } else
        {
            return 0;
        }
    }
    
    public long getCount()
    {
        return count;
    }
    
    public long getTotal()
    {
        return total;
    }
}
