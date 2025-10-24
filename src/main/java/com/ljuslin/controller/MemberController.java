package com.ljuslin.controller;

import com.ljuslin.model.Member;
import com.ljuslin.service.MembershipService;
import com.ljuslin.utils.Util;

import java.util.List;
import java.util.Scanner;

public class MemberController {
    private Scanner scanner = new Scanner(System.in);
    private MembershipService membershipService;

    /**
     * Constructor
     * @param membershipService
     */
    public MemberController(MembershipService membershipService) {
        this.membershipService = membershipService;
    }

    /**
     * Starts this controller, prints menu
     */
    public void start() {
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
                case 2 -> freeSearchMember();
                case 3 -> {
                    Member member = searchMember();
                    if (member != null) {
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
                    if (member != null) {
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
        Member member = membershipService.getMember(memberID);
        if (member == null) {
            System.out.println("Member not found");
            return null;
        }
        System.out.println(member.toString());
        return member;

    }

    /**
     * Does a free search on a member and lists all hits
     */
    private void freeSearchMember() {
        System.out.println("Please enter search string: ");
        String searchString = scanner.nextLine();
        List<Member> members = membershipService.searchMembers(searchString);
        if (members.isEmpty()) {
            System.out.println("No members found");
            return;
        }
        for (Member member : members) {
            System.out.println(member.toString());
        }
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

    /**
     * Print member menu
     * @return users choice
     */
    private int printMemberMenu() {
        System.out.println("1. New member");
        System.out.println("2. Search member");
        System.out.println("3. Change member");
        System.out.println("4. Delete member");
        System.out.println("5. List all members");
        System.out.println("6. Exit menu");
        return Util.getUserChoice();
    }
}
