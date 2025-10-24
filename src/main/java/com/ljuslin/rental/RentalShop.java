package com.ljuslin.rental;

import com.ljuslin.repository.Inventory;
import com.ljuslin.repository.MemberRegistry;
import com.ljuslin.repository.RentalRepository;
import com.ljuslin.service.ItemService;
import com.ljuslin.service.MembershipService;
import com.ljuslin.service.RentalService;
import com.ljuslin.service.RevenueService;

import java.util.List;
import java.util.Scanner;

public class RentalShop {
    private MemberRegistry memberRegistry = new MemberRegistry();
    private Inventory inventory = new Inventory();
    private RentalRepository rentalRepo = new RentalRepository();

    private MembershipService membershipService = new MembershipService(memberRegistry);
    private RentalService rentalService = new RentalService(rentalRepo);
    private ItemService itemService = new ItemService(inventory);
    private RevenueService revenueService = new RevenueService(rentalRepo);

    private Scanner scanner = new Scanner(System.in);
    /**
     * Constructor, starts services and repos
     */
    public RentalShop() {
    }

    /**
     * Starts rental shop by printing first menu
     */
    public void start() {
        while (true) {
            switch (printFirstMenu()) {
                case 1 -> goToMember();
                case 2 -> goToItem();
                case 3 -> goToRental();
                case 4 -> goToRevenue();
                case 5 -> System.exit(1);
                default -> System.out.println("Incorrect choice, please try again");
            }
        }
    }

    /**
     * Prints member menu and redirects to correct method
     */
    private void goToMember() {
        boolean goOn = true;
        while (goOn) {
            switch (printMemberMenu()) {
                case 1 -> {
                    System.out.println("Enter fist name: ");
                    String firstName = scanner.nextLine();
                    System.out.println("Enter last name: ");
                    String lastName = scanner.nextLine();
                    System.out.println("Enter user level (standard/student/premium): ");
                    String level = scanner.nextLine();
                    System.out.println(membershipService.newMember(firstName, lastName, level));

                }
                case 2 -> searchMember();

                case 3 -> {
                    Member member = searchMember();
                    if (member != null ) {
                        System.out.println("Enter new last name(or just enter for no changes): ");
                        String lastName = scanner.nextLine();
                        System.out.println("Enter new user level (standard/student/premium)" +
                                "(or just enter for no changes): ");
                        String level = scanner.nextLine();

                        System.out.println(membershipService.changeMember(member.getMemberID(),
                                lastName, level));
                    }
                }
                case 4 -> {
                    Member member = searchMember();
                    if (member != null ) {
                        System.out.println(membershipService.removeMember(member.getMemberID()));
                    }
                }
                case 5 -> listAllMembers();
                case 6 -> goOn = false;
            }
        }
    }

    /**
     * Prompts user to enter members ID and searches for for member with that id
     * @return member found or null
     */
    private Member searchMember() {
        System.out.println("Please enter memberID: ");
        String memberID = scanner.nextLine();
        Member member = membershipService.searchMember(memberID);
        if (member == null) {
            System.out.println("Member not found");
            return null;
        }
        System.out.println(member.toString());
        return member;
    }

    /**
     * Lists all members on prompt
     */
    private void listAllMembers() {
        List<Member> members = membershipService.getAllMembers();
        if(members == null) {
            System.out.println("No members found");
            return;
        }
        for (Member member : members) {
            System.out.println(member.toString());
        }
    }

    private void goToItem() {
        boolean goOn = true;
        while (goOn) {
            switch (printItemMenu()) {
                case 1 -> newItem();
                case 2 -> searchItem();
                case 3 -> listItems();
                case 4 -> goOn = false;
            }
        }
    }
    private void searchItem() {
        System.out.println("What are you looking for?");
        String search = scanner.nextLine();
        List<Item> items = itemService.searchItem(search);
        if (items == null) {
            System.out.println("No items found");
            return;
        }
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }

    /**
     * Lists all items
     */
    private void listItems() {
        List<Item> items = itemService.getItems();
        if (items == null)
            System.out.println("No items found");
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }
    /**
     * Adds a new tie or a bowtie to the inventory
     */
    private void newItem() {
        String kindOfItem;
        while (true) {
            System.out.println("Would you like to add a tie or a bowtie? ");
            kindOfItem = scanner.nextLine();
            kindOfItem = kindOfItem.toLowerCase();
            if (kindOfItem.equals("tie")) {
                break;
            } else if (kindOfItem.equals("bowtie")) {
                break;
            } else {
                System.out.println("Can't create that item at the moment, please try again!");
            }
        }
        System.out.println("Please enter " + kindOfItem + " pattern " +
                "(paisley/striped/dotted/no pattern/other): ");
        String pattern = scanner.nextLine();
        System.out.println("Please enter material of " + kindOfItem
                + " (polyester/wool/cotton/silk): ");
        String material = scanner.nextLine();
        System.out.println("Please enter brand of " + kindOfItem + ": ");
        String brand = scanner.nextLine();
        System.out.println("Please enter color: ");
        String color = scanner.nextLine();
        System.out.println("Please enter price per day: ");
        String pricePerDay = scanner.nextLine();
        if (kindOfItem.equals("tie")) {
            System.out.println("Please enter length of tie: ");
            String length = scanner.nextLine();
            System.out.println("Please enter width of tie: ");
            String width = scanner.nextLine();
            System.out.println(itemService.newTie(pattern, material, brand, color, pricePerDay,
                    length,
                    width));
        } else {
            System.out.println("Please enter size of bowtie: ");
            String size = scanner.nextLine();
            System.out.println("Is this bowtie pree tied (y/n):");
            String preeTied = scanner.nextLine();
            System.out.println(itemService.newBowtie(pattern, material, brand, color, pricePerDay,
                    size,
                    preeTied));
        }
        System.out.println("Please enter");
        itemService.newItem();
    }
    private void goToRental() {
        boolean goOn = true;
        while (goOn) {
            switch (printRentalMenu()) {
                case 1 -> rentalService.newRental();
                case 2 -> rentalService.endRental();
                case 3 -> goOn = false;
            }
        }
    }
    private void goToRevenue() {

        boolean goOn = true;
        while (goOn) {
            switch (printRevenueMenu()) {
                case 1 -> revenueService.totalRevenue();
                case 2 -> revenueService.revenuePerItem();
                case 3 -> goOn = false;
            }
        }
    }
    private int printFirstMenu() {
        System.out.println("1. Members");
        System.out.println("2. Items");
        System.out.println("3. Rentals");
        System.out.println("4. Revenues");
        System.out.println("5. Exit");
        return getUserChoice();
    }
    private int printMemberMenu() {
        System.out.println("1. New member");
        System.out.println("2. Search member");
        System.out.println("3. Change member");
        System.out.println("4. Delete member");
        System.out.println("5. List all members");
        System.out.println("6. Exit menu");
        return getUserChoice();
    }
    private int printItemMenu() {
        System.out.println("1. New item");
        System.out.println("2. Search item");
        System.out.println("3. List all items");
        System.out.println("4. Exit menu");
        return getUserChoice();
    }
    private int printRentalMenu() {
        System.out.println("1. New rental");
        System.out.println("2. End rental");
        System.out.println("3. Exit menu");
        return getUserChoice();
    }
    private int printRevenueMenu() {
        System.out.println("1. Total revenue");
        System.out.println("2. Revenue per item");
        System.out.println("3. Exit menu");
        return getUserChoice();
    }
    /**
     * Waits to get the user choice from the prompt
     * @return int, the menu choice the user made, -1 if incorrect
     */
    private int getUserChoice() {
        int answer;
        try {
            answer = scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
        scanner.nextLine();
        return answer;
    }
}
