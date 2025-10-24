package com.ljuslin.service;

import com.ljuslin.model.Rental;
import com.ljuslin.repository.Inventory;
import com.ljuslin.repository.RentalRepository;

import java.util.List;

public class RevenueService {
    private RentalRepository rentalRepo;
    public RevenueService() {}
    public RevenueService(RentalRepository rentalRepo) {
        this.rentalRepo = rentalRepo;
    }

    /**
     * Returns total revenue
     */
    public double totalRevenue() {
        List<Rental> rentals = rentalRepo.getRentals();
        double totalRevenue = 0;
        for (Rental rental : rentals) {
            if (rental.getReturnDate() != null) {
                totalRevenue += rental.getTotalRevenue();
            }
        }
        return totalRevenue;
    }
    public double revenuePerItem(String itemID) {
        List<Rental> rentals = rentalRepo.getRentals();
        double totalRevenue = 0;
        for (Rental rental : rentals) {
            if (rental.getReturnDate() != null
                    && rental.getItem().getItemID().equals(itemID)) {
                totalRevenue += rental.getTotalRevenue();
            }
        }
        return totalRevenue;

    }
}
