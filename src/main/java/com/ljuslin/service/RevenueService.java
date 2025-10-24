package com.ljuslin.service;

import com.ljuslin.repository.Inventory;
import com.ljuslin.repository.RentalRepository;

public class RevenueService {
    private RentalRepository rentalRepo;
    public RevenueService() {}
    public RevenueService(RentalRepository rentalRepo) {
        this.rentalRepo = rentalRepo;
    }

    /**
     * Returns total revenue
     */
    public void totalRevenue() {

    }
    public void revenuePerItem() {


    }
}
