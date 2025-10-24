package com.ljuslin.service;

import com.ljuslin.rental.Rental;
import com.ljuslin.repository.Inventory;
import com.ljuslin.repository.RentalRepository;
import com.ljuslin.utils.PricePolicy;

public class RentalService {
    private RentalRepository rentalRepo;
    public RentalService() {}

    public RentalService(RentalRepository rentalRepo) {
        this.rentalRepo = rentalRepo;
    }
    public void newRental() {

    }
    public void endRental() {

    }

}
