package com.ljuslin.pricing;

public class StandardPricing implements PricePolicy {

    public double getPricePerDay(double price){
        return price;
    }
    public double getTotalPrice(double price, int days){
        return price * days;
    }

}
