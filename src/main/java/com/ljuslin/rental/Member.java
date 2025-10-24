package com.ljuslin.rental;

import com.ljuslin.utils.Level;

import java.util.ArrayList;
import java.util.List;

/**
 * Member (id, namn, status/level, historik)
 */
public class Member {
    private String memberID;
    private String firstName;
    private String lastName;
    private Level memberLevel;
    private static int counter = 1;
    private List<Rental> history = new ArrayList<Rental>();

    public Member() {

    }
    public Member(String firstName, String lastName, Level memberLevel) {
        this.memberID = lastName + "_" + Integer.toString(counter++);
        this.firstName = firstName;
        this.lastName = lastName;
        this.memberLevel = memberLevel;
    }

    /**
     * Returns members ID
     * @return ID of member
     */
    public String getMemberID() {
        return memberID;
    }

    /**
     * Returns members first name
     * @return members first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets members first name
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns members last name
     * @return members last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns members first and last name
     * @return members full name
     */
    public String getName() {
        return firstName + " " + lastName;
    }

    /**
     * Sets members last name
     * @param lastName, members ne
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Level getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(Level memberLevel) {
        this.memberLevel = memberLevel;
    }

    public List<Rental> getHistory() {
        return history;
    }

    public void setHistory(List<Rental> history) {
        this.history = history;
    }
    @Override
    public String toString() {
        return getName() +  ", ID: " + getMemberID() + ", Level: " + this.memberLevel;
    }


}
