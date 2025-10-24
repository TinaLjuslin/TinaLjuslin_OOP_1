package com.ljuslin.rental;

/**
 * Rental (kopplar member och item för en viss tidsperiod)
 */
public class Rental {
    private Member member;
    private Item item;
    private boolean returned;
    private double totalRevenue;
    public Rental() {}
    public Rental(Member member, Item item) {
        this.member = member;
        this.item = item;
        this.returned = false;
        this.totalRevenue = 0;
    }

    public Member getMember() {
        return member;
    }

    public Item getItem() {
        return item;
    }

    public boolean isReturned() {
        return returned;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
