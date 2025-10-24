package com.ljuslin.controller;

import com.ljuslin.utils.Util;

public class MainController {
    private ItemController itemController;
    private MemberController memberController;
    private RevenueController revenueController;
    private RentalController rentalController;

    public  MainController(ItemController itemController, MemberController memberController,
                           RentalController rentalController, RevenueController revenueController) {
        this.itemController = itemController;
        this.memberController = memberController;
        this.rentalController = rentalController;
        this.revenueController = revenueController;
    }
    /**
     * Starts rental shop by printing first menu
     */
    public void start() {
        while (true) {
            switch (printFirstMenu()) {
                case 1 -> memberController.start();
                case 2 -> itemController.start();
                case 3 -> rentalController.start();
                case 4 -> revenueController.start();
                case 5 -> System.exit(1);
                default -> System.out.println("Incorrect choice, please try again");
            }
        }
    }

    /**
     * Prints first menu
     * @return users choice
     */
    private int printFirstMenu() {
        System.out.println("1. Members");
        System.out.println("2. Items");
        System.out.println("3. Rentals");
        System.out.println("4. Revenues");
        System.out.println("5. Exit");
        return Util.getUserChoice();
    }
}
