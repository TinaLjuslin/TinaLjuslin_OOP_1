package com.ljuslin.utils;

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
    public double getPrice(Level level);
    public double getPrice(Level level, int days);

}

