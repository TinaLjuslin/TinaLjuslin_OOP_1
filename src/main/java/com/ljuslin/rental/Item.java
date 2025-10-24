package com.ljuslin.rental;

import com.ljuslin.utils.Material;
import com.ljuslin.utils.Pattern;

/**
 * Item (abstract)  Subklasser som ex. Vehicle, Tool, SportGear eller liknande
 * beroende på ditt val av applikation. Var och en av klasserna ska innehålla sina
 * unika attribut och metoder enligt det vi pratat om
 */
public abstract class Item {
    private String itemID;
    private Pattern pattern;
    private Material material;
    private String brand;
    private String color;
    private double pricePerDay;
    private static int counter = 1000;

    /**
     * Empty constructor
     */
    public Item() {}

    /**
     * Constructor for item
     * @param pattern pattern for item
     * @param material material of item
     * @param brand, brand of item
     * @param pricePerDay, regular price for item
     */
    public Item(Pattern pattern, Material material, String brand, String color,
                double pricePerDay) {
        this.itemID = String.valueOf(counter++);
        this.pattern = pattern;
        this.material = material;
        this.brand = brand;
        this.color = color;
        this.pricePerDay = pricePerDay;
    }

    /**
     * Returns pattern of item
     * @return the pattern
     */
    public Pattern getPattern() {
        return pattern;
    }

    /**
     * Returns material of item
     * @return the material
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * Returns brand of item
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Returns color of item
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * Returns rental price per day
     * @return price per day
     */
    public double getPricePerDay() {
        return pricePerDay;
    }

    /**
     * Returns items id
     * @return id of item
     */
    public String getItemID() {
        return itemID;
    }

    /**
     * Sets rental price per day
     * @param pricePerDay, new price
     */
    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}
