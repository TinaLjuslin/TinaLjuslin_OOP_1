package com.ljuslin.rental;

import com.ljuslin.controller.MainController;
import com.ljuslin.controller.MemberController;
import com.ljuslin.controller.RentalController;
import com.ljuslin.controller.RevenueController;
import com.ljuslin.controller.ItemController;
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

    private MembershipService membershipService = new MembershipService(memberRegistry, rentalRepo);
    private ItemService itemService = new ItemService(inventory);
    private RentalService rentalService = new RentalService(rentalRepo, membershipService,
            itemService);
    private RevenueService revenueService = new RevenueService(rentalRepo);

    private ItemController itemController = new ItemController(itemService);
    private MemberController memberController = new MemberController(membershipService);
    private RentalController rentalController = new RentalController(rentalService);
    private RevenueController revenueController = new RevenueController(revenueService);
    private MainController mainController = new MainController(itemController, memberController,
            rentalController, revenueController);
    /**
     * Constructor, starts services and repos
     */
    public RentalShop() {

    }
    public void start() {
        mainController.start();
    }







}
