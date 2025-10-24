package com.ljuslin.repository;

import com.ljuslin.model.Rental;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RentalRepository {
    private List<Rental> rentals = new ArrayList<>();
    public RentalRepository() {}

    public void addRental(Rental rental) {
        rentals.add(rental);
    }
    public List<Rental> getRentals() {
        return rentals;
    }
    public Rental endRental(Rental rental, LocalDate date, double totalRevenue) {
        for (Rental r : rentals) {
            if (r.equals(rental)) {
                r.setReturnDate(date);
                r.setTotalRevenue(totalRevenue);
                return r;
            }
        }
        return null;
    }
}
