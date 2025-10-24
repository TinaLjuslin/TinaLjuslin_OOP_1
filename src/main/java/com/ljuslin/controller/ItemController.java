package com.ljuslin.controller;

import com.ljuslin.model.Item;
import com.ljuslin.service.ItemService;
import com.ljuslin.utils.Util;

import java.util.List;
import java.util.Scanner;

public class ItemController {
    private ItemService itemService;
    private Scanner scanner = new Scanner(System.in);

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    /**
     * Starts item constroller by printing menu
     */
    public void start() {
        boolean goOn = true;
        while (goOn) {
            switch (printItemMenu()) {
                case 1 -> newItem();
                case 2 -> searchItem();
                case 3 -> listItems();
                case 4 -> goOn = false;
            }
        }
    }

    /**
     * Lets user search for an item
     */
    private void searchItem() {
        System.out.println("What are you looking for?");
        String search = scanner.nextLine();
        List<Item> items = itemService.searchItem(search);
        if (items == null) {
            System.out.println("No items found");
            return;
        }
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }

    /**
     * Lists all items
     */
    private void listItems() {
        List<Item> items = itemService.getItems();
        if (items == null)
            System.out.println("No items found");
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }
    /**
     * Adds a new tie or a bowtie to the inventory
     */
    private void newItem() {
        String kindOfItem;
        while (true) {
            System.out.println("Would you like to add a tie or a bowtie? ");
            kindOfItem = scanner.nextLine();
            kindOfItem = kindOfItem.toLowerCase();
            if (kindOfItem.equals("tie")) {
                break;
            } else if (kindOfItem.equals("bowtie")) {
                break;
            } else {
                System.out.println("Can't create that item at the moment, please try again!");
            }
        }
        System.out.println("Please enter " + kindOfItem + " pattern " +
                "(paisley/striped/dotted/no pattern/other): ");
        String pattern = scanner.nextLine();
        System.out.println("Please enter material of " + kindOfItem
                + " (polyester/wool/cotton/silk): ");
        String material = scanner.nextLine();
        System.out.println("Please enter brand of " + kindOfItem + ": ");
        String brand = scanner.nextLine();
        System.out.println("Please enter color: ");
        String color = scanner.nextLine();
        System.out.println("Please enter price per day: ");
        String pricePerDay = scanner.nextLine();
        if (kindOfItem.equals("tie")) {
            System.out.println("Please enter length of tie: ");
            String length = scanner.nextLine();
            System.out.println("Please enter width of tie: ");
            String width = scanner.nextLine();
            System.out.println(itemService.newTie(pattern, material, brand, color, pricePerDay,
                    length,
                    width));
        } else {
            System.out.println("Please enter size of bowtie: ");
            String size = scanner.nextLine();
            System.out.println("Is this bowtie pree tied (y/n):");
            String preeTied = scanner.nextLine();
            System.out.println(itemService.newBowtie(pattern, material, brand, color, pricePerDay,
                    size,
                    preeTied));
        }
        System.out.println("Please enter");
        //itemService.newItem();
    }

    /**
     * Prints item-menu
     * @return users answe
     */
    private int printItemMenu() {
        System.out.println("1. New item");
        System.out.println("2. Search item");
        System.out.println("3. List all items");
        System.out.println("4. Exit menu");
        return Util.getUserChoice();
    }
}
