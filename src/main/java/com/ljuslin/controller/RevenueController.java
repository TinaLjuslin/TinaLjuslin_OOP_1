package com.ljuslin.controller;

import com.ljuslin.service.RevenueService;
import com.ljuslin.utils.Util;

import java.util.Scanner;

public class RevenueController {
    private Scanner scanner = new Scanner(System.in);
    private RevenueService revenueService;
    public RevenueController(RevenueService revenueService) {
        this.revenueService = revenueService;
    }

    /**
     * Starts revenue controller
     */
    public void start() {
        boolean goOn = true;
        while (goOn) {
            switch (printRevenueMenu()) {
                case 1 -> totalRevenue();
                case 2 -> totalRevenuePerItem();
                case 3 -> goOn = false;
            }
        }
    }

    /**
     * Prints revenue menu
     * @return users choice
     */
    private int printRevenueMenu() {
        System.out.println("1. Total revenue");
        System.out.println("2. Revenue per item");
        System.out.println("3. Exit menu");
        return Util.getUserChoice();
    }
    private void totalRevenue() {
        System.out.println(String.valueOf(revenueService.totalRevenue()));

    }
    private void totalRevenuePerItem() {
        System.out.println("Please enter item ID: ");
        String itemID = scanner.nextLine();
        revenueService.revenuePerItem(itemID);
    }
}
