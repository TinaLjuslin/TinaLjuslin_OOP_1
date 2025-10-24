package com.ljuslin.rental;

import com.ljuslin.utils.Level;
import com.ljuslin.utils.Material;
import com.ljuslin.utils.Pattern;
import com.ljuslin.utils.PricePolicy;

public class Bowtie extends Item implements PricePolicy {
    private String size;
    private boolean preeTied = false;
    public Bowtie() {}

    /**
     * Constructor, creates a new bowtie
     * @param pattern
     * @param material
     * @param brand
     * @param pricePerDay
     * @param size
     * @param preeTied
     */
    public Bowtie(Pattern pattern, Material material, String brand, String color,
                  double pricePerDay,
                  String size, boolean preeTied) {
        super(pattern, material, brand, color, pricePerDay);
        this.size = size;
        this.preeTied = preeTied;
    }

    /**
     * Returns size of bowtie
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * Returns if the bowtie is pree-tied
     * @return true if bowtie is pree-tied
     */
    public boolean isPreeTied() {
        return preeTied;
    }
    public double getPrice(Level level) {
        switch (level) {
            case STANDARD -> {
                return this.getPricePerDay();
            }
            case STUDENT -> {
                return this.getPricePerDay() * 0.1;
            }
            case PREMIUM -> {
                return this.getPricePerDay() * 0.2;
            }
            default -> {
                return this.getPricePerDay();
            }
        }
    }
    public double getPrice(Level level, int days) {
        switch (level) {
            case STANDARD -> {
                return this.getPricePerDay() * days;}
            case STUDENT -> {
                return this.getPricePerDay() * days * 0.1;
            }
            case PREMIUM -> {
                return this.getPricePerDay() * days * 0.2;
            }
            default -> {
                return this.getPricePerDay() * days;
            }
        }
    }

    @Override
    public String toString() {
        String s = getPattern().toString().toLowerCase();
        s = s.substring(0, 1).toUpperCase() + s.substring(1);
        s = s.replaceAll("_", " ");
        s = s.concat(" ").concat(getColor());
        s = s.concat(" ").concat(getMaterial().toString().toLowerCase());
        s = s.concat(" bowtie from ");
        s = s.concat(getBrand());
        if (preeTied)
            s = s.concat(", pre-tied");
        else
            s = s.concat(", not pre-tied");
        s = s.concat(", in size ").concat(size);
        s = s.concat(", rental price per day is ").concat(String.valueOf(getPricePerDay())).concat(
                "SEK.");
        return s;
    }
}
