package com.ljuslin.service;

import com.ljuslin.model.*;
import com.ljuslin.pricing.PremiumPricing;
import com.ljuslin.pricing.StandardPricing;
import com.ljuslin.pricing.StudentPricing;
import com.ljuslin.repository.RentalRepository;
import com.ljuslin.utils.Util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RentalService {
    private RentalRepository rentalRepo;
    private MembershipService membershipService;
    private ItemService itemService;

    /**
     * Constructor
     * @param rentalRepo
     */
    public RentalService(RentalRepository rentalRepo, MembershipService membershipService,
                         ItemService itemService) {
        this.rentalRepo = rentalRepo;
        this.membershipService = membershipService;
        this.itemService = itemService;
    }

    public String newRental(String memberID, String itemID, String rentalDate) {
        Member member = membershipService.getMember(memberID);
        if (member == null) {
            return "Invalid member id: " + memberID;
        }
        Item item = itemService.getItem(itemID);
        if (item == null) {
            return "Invalid item id: " + itemID;
        }
        LocalDate date = Util.checkDate(rentalDate);
        if (date == null) {
            return "Invalid rental date: " + rentalDate;
        }
        Rental rental = new Rental(member, item, date);
        //kolla så item inte är uthyrd
        rentalRepo.addRental(rental);
        //itemService.removeItem(item.getItemID());
        return "Rental added for " + member.getName();
    }
    public String endRental(String memberID, String itemID, String returnDate) {
        Member member = membershipService.getMember(memberID);
        if (member == null) {
            return "Invalid member id: " + memberID;
        }
        Item item = itemService.getItem(itemID);
        if (item == null) {
            return "Invalid item id: " + itemID;
        }
        LocalDate date = Util.checkDate(returnDate);
        if (date == null) {
            return "Invalid return date: " + returnDate;
        }
        List<Rental> openRentalsForCustomer = new ArrayList<>();
        for (Rental rental : rentalRepo.getRentals()) {
            if (rental.getMember().getMemberID().equals(memberID)) {
                openRentalsForCustomer.add(rental);
            }
        }
        if (openRentalsForCustomer.isEmpty()) {
            return "No open rentals for customer: " + member;
        }
        for (Rental rental : openRentalsForCustomer) {
            if (rental.getItem().getItemID().equals(itemID)) {
                if (!Util.checkBefore(rental.getRentalDate(), date)) {
                    return "Return date can not be before rental date";
                }
                //calculate totalRev
                double totalRevenue = 0;
                int days = Util.daysBetween(rental.getRentalDate(), date);
                totalRevenue = getTotalPrice(member, item, days);
                rentalRepo.endRental(rental, date, totalRevenue);
                //itemService.newItem(item);
                return "Rental ended for " + member.getName() + ", total cost: " + totalRevenue;
            }
        }
        return "Something went wrong";
    }

    /**
     * Returns price per day depending on members level
     * @param member the member
     * @param item the item
     * @return price per day depending on members level
     */
    private double getPricePerDay(Member member, Item item) {
        switch (member.getMemberLevel()) {
            case PREMIUM -> {
                return (new PremiumPricing()).getPricePerDay(item.getPricePerDay());
            }
            case STUDENT -> {
                return (new StudentPricing()).getPricePerDay(item.getPricePerDay());
            }
            default -> {
                return
                (new StandardPricing()).getPricePerDay(item.getPricePerDay());
            }
        }
    }

    /**
     * Returns total price depending on members level
     * @param member the member
     * @param item the item
     * @param days number of days
     * @return the total price
     */
    private double getTotalPrice(Member member, Item item, int days) {
        switch (member.getMemberLevel()) {
            case PREMIUM -> {
                return (new PremiumPricing()).getTotalPrice(item.getPricePerDay(), days);
            }
            case STUDENT -> {
                return (new StudentPricing()).getTotalPrice(item.getPricePerDay(), days);
            }
            default -> {
                return (new StandardPricing()).getTotalPrice(item.getPricePerDay(), days);
            }
        }
    }
    public List<Rental> getOngoingRentals() {
        List<Rental> openRentals = new ArrayList<>();
        for(Rental rental : rentalRepo.getRentals()) {
            if (rental.getReturnDate() ==null) {
                openRentals.add(rental);
            }
        }
        return openRentals;
    }

    public List<Rental> getEndedRentals() {
        List<Rental> endedRentals = new ArrayList<>();
        for(Rental rental : rentalRepo.getRentals()) {
            if (rental.getReturnDate() !=null) {
                endedRentals.add(rental);
            }
        }
        return endedRentals;
    }
    public List<Rental> getRentals() {
        return rentalRepo.getRentals();
    }

}
