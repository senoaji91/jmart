package com.senoJmartMH;


import com.senoJmartMH.dbjson.Serializable;

/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product extends Serializable
{
    public int accountId;
    public ProductCategory category;
    public boolean conditionUsed;
    public double discount;
    public String name;
    public double price;
    public byte shipmentPlans;
    public int weight;

    public Product(int accountId, ProductCategory category, boolean conditionUsed, double discount, String name, double price, byte shipmentPlans, int weight)
    {
        this.accountId = accountId;
        this.category = category;
        this.conditionUsed = conditionUsed;
        this.discount = discount;
        this.name = name;
        this.price = price;
        this.shipmentPlans = shipmentPlans;
        this.weight = weight;
    }

    public String toString(){
        return "Account ID: " + this.accountId + "\n"
                + "category: " + this.category + "\n"
                + "conditionUsed: " + this.conditionUsed + "\n"
                + "discount: " + this.discount + "\n"
                + "category: " + this.category + "\n"
                + "Name: " + this.name + "\n"
                + "price: " + this.price + "\n"
                + "shipmentPlans: " + this.shipmentPlans + "\n"
                + "weight: " + this.weight + "\n";
    }

}
