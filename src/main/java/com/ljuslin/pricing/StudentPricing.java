package com.ljuslin.pricing;

public class StudentPricing implements PricePolicy{

    public double getPricePerDay(double price){
        return price * 0.9;
    }
    public double getTotalPrice(double price, int days){
        return price * days * 0.9;
    }

}
