package com.ljuslin.controller;

import com.ljuslin.model.Rental;
import com.ljuslin.service.RentalService;
import com.ljuslin.utils.Util;

import java.util.List;
import java.util.Scanner;

public class RentalController {
    private Scanner scanner = new Scanner(System.in);
    private RentalService rentalService;

    /**
     * Constructor
     * @param rentalService
     */
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    /**
     * Start rental controll
     */
    public void start() {
        boolean goOn = true;
        while (goOn) {
            switch (printRentalMenu()) {
                case 1 -> newRental();
                case 2 -> endRental();
                case 3 -> listOngoingRentals();
                case 4 -> listEndedRentals();
                case 5 -> listRentals();
                case 6 -> goOn = false;
            }
        }
    }

    /**
     * Prints rental menu
     * @return users choice
     */
    private int printRentalMenu() {
        System.out.println("1. New rental");
        System.out.println("2. End rental");
        System.out.println("3. List ongoing rentals");
        System.out.println("4. List ended rentals");
        System.out.println("5. List all rentals");
        System.out.println("6. Exit menu");
        return Util.getUserChoice();
    }
    private void newRental() {
        System.out.println("Please enter members ID: ");
        String memberID = scanner.nextLine();
        System.out.println("Please enter items ID: ");
        String itemID = scanner.nextLine();
        System.out.println("Please enter rental date (yyyy-mm-dd):");
        String rentalDate = scanner.nextLine();
        System.out.println(rentalService.newRental(memberID, itemID, rentalDate));
    }
    private void endRental() {
        System.out.println("Please enter members ID: ");
        String memberID = scanner.nextLine();
        System.out.println("Please enter items ID: ");
        String itemID = scanner.nextLine();
        System.out.println("Please enter return date (yyyy-mm-dd):");
        String returnDate = scanner.nextLine();
        System.out.println(rentalService.endRental(memberID, itemID, returnDate));

    }
    private void listRentals() {
        List<Rental> rentals = rentalService.getRentals();
        if  (rentals.isEmpty()) {
            System.out.println("No Rentals");
            return;
        }
        for (Rental rental : rentals) {
            System.out.println(rental.toString());
        }

    }
    private void listOngoingRentals() {
        List<Rental> rentals = rentalService.getOngoingRentals();
        if  (rentals.isEmpty()) {
            System.out.println("No Rentals");
            return;
        }
        for (Rental rental : rentals) {
            System.out.println(rental.toString());
        }
    }
    private void listEndedRentals() {
        List<Rental> rentals = rentalService.getEndedRentals();
        if  (rentals.isEmpty()) {
            System.out.println("No Rentals");
            return;
        }
        for (Rental rental : rentals) {
            System.out.println(rental.toString());
        }
    }
}
