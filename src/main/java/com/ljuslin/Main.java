package com.ljuslin;

import com.ljuslin.rental.RentalShop;

/**
 * Vart ska inteface pricePolicy implementeras?
 * intäkter - kolla alla "färdiga" uthyrningar och räkna ihop totalsumman
 *
 *
 *
 *
 *
 * Klasser som ska finnas i applikationen:
 * • Member (id, namn, status/level, historik)
 * • Item (abstract)  Subklasser som ex. Vehicle, Tool, SportGear eller liknande
 * beroende på ditt val av applikation. Var och en av klasserna ska innehålla sina
 * unika attribut och metoder enligt det vi pratat om.
 * • Rental (kopplar member och item för en viss tidsperiod)
 * • PricePolicy (interface) + konkreta strategier, ex. standard, student, premium.
 * • Inventory och MemberRegistry (hanteras i minnet via List, Map eller Set)
 * • RentalService och MembershipService ska innehålla affärslogiken
 * • Konsolmeny: lägg till/sök/ändra medlemmar. Lista/filtrera items. Boka/avsluta
 * uthyrning. Summera intäkter
 * Bedömningskriterier
 * G
 * Körbar applikation som körs tills användaren väljer att avsluta
 * Korrekt uppförda klasser samt användande av objekt och metoder
 * Item som basklass + minst två konkreta subklasser. PricePolicy som interface + minst
 * två implementationer
 * Privata attribut samt nödvändiga getters/setters. Enkel ansvarsdelning mellan
 * klasser/logik samt huvudprogrammet
 * Collections ska användas där det är lämpligt
 * Mindre kompletteringar får förekomma
 * VG
 * Samtliga krav på G är uppfyllda. Dessutom finns en robust felhantering på metoder där
 * så är lämpligt. Det finns även en hög kodkvalitet med väl namngivna klasser och
 * metoder. Uppgiften ska lämnas in innan deadline. Mindre kompletteringar får
 * förekomma
 */
public class Main {
    public static void main(String[] args) {
        RentalShop rs = new RentalShop();
        rs.start();
    }
}
