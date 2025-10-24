package com.ljuslin;

import com.ljuslin.rental.RentalShop;

/**
 * kolla om membeern finns i uthyrda, då kan man inte ta bort membern
 * om member hyr två likadana lämnas den första tillbaka, ska man kunna välja?
 * kan man nyra samma sak flera gånger samma datum, kolla så item inte är uthyrt
 *
 *
 */
public class Main {
    public static void main(String[] args) {
        RentalShop rs = new RentalShop();
        rs.start();
    }
}
