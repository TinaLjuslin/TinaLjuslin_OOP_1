package com.ljuslin.pricing;

import com.ljuslin.model.Level;

/**
 * PricePolicy (interface) + konkreta strategier, ex. standard, student, premium
 * där jag hanterar betalningen
 * ska den implemeteras av sakerna, extend item implements PricePolice
 *
 * olika price metoder, om det skickas in en member/student/vanlig så implementera denna metod
 *
 *
 */
public interface PricePolicy {
    public double getPricePerDay(double price);
    public double getTotalPrice(double price, int days);

}

