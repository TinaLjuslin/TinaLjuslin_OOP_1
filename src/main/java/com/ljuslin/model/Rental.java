package com.ljuslin.model;

import java.time.LocalDate;

/**
 * Rental (kopplar member och item för en viss tidsperiod)
 */
public class Rental {
    private Member member;
    private Item item;
    private double totalRevenue;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    public Rental() {}
    public Rental(Member member, Item item, LocalDate rentalDate) {
        this.member = member;
        this.item = item;
        this.rentalDate = rentalDate;
        this.totalRevenue = 0;
    }

    public Member getMember() {
        return member;
    }

    public Item getItem() {
        return item;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
    @Override
    public String toString() {
        String s = "Member: ";
        s = s.concat(member.getName()).concat(", Rented item:\n").concat(item.toString());
        s = s.concat("\nRented date: ").concat(String.valueOf(rentalDate));
        if (returnDate != null) {
            s = s.concat("\nReturn date: ").concat(String.valueOf(returnDate));
            s = s.concat("\nTotal revenue: ").concat(String.format("%.2f", totalRevenue));
        }
        return s;
    }
}
