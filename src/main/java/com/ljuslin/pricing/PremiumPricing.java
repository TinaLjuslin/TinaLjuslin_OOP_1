package com.ljuslin.pricing;

public class PremiumPricing implements PricePolicy{

    public double getPricePerDay(double price){
        return price * 0.8;
    }
    public double getTotalPrice(double price, int days){
        return price * 0.8 * days;
    }

}
