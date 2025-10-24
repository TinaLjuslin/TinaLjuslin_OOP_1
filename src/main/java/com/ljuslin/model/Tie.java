package com.ljuslin.model;

import com.ljuslin.pricing.PricePolicy;

public class Tie extends Item {
    private double length;
    private double width;

    /**
     * Constructor, creates a new tie
     * @param pattern pattern of tie
     * @param material, material of tie
     * @param brand, brand of tie
     * @param length, length of tie
     * @param width, width of tie
     */
    public Tie(Pattern pattern, Material material, String brand, String color, double pricePerDay,
               double length,
               double width) {
        super(pattern, material, brand, color, pricePerDay);
        this.length = length;
        this.width = width;
    }

    @Override
    public String toString() {
        String s = getPattern().toString().toLowerCase();
        s = s.substring(0, 1).toUpperCase() + s.substring(1);
        s = s.replaceAll("_", " ");
        s = s.concat(" ").concat(getColor());
        s = s.concat(" ").concat(getMaterial().toString().toLowerCase());
        s = s.concat(" tie from ");
        s = s.concat(getBrand());
        s = s.concat(", length: ").concat(String.valueOf(length));
        s = s.concat(", width: ").concat(String.valueOf(width));
        s = s.concat(", rental price per day is ").concat(String.valueOf(getPricePerDay())).concat(
                " SEK");
        s = s.concat(", ID: ").concat(getItemID());
        return s;
    }
}
