package com.ljuslin.service;

import com.ljuslin.rental.Member;
import com.ljuslin.repository.MemberRegistry;
import com.ljuslin.utils.Level;

import java.util.List;
import java.util.Set;

public class MembershipService {
    private MemberRegistry memberRegistry;

    /**
     * Empty constructor
     */
    public MembershipService() {}

    /**
     * Constructor
     * @param memberRegistry the registry holding members
     */
    public MembershipService(MemberRegistry memberRegistry) {
        this.memberRegistry = memberRegistry;
    }

    /**
     * Creates a new member
     * @param firstName new members first name
     * @param lastName new members last name
     * @param level members level as string
     * @return message to show user
     */
    public String newMember(String firstName, String lastName, String level) {
        if (firstName == "" || lastName == "") {
            return "Please enter proper names";
        }
        Level lLevel = getLevel(level);
        if ( lLevel == null) {
            return level + " is not a valid level";
        }
        Member member = new Member(firstName, lastName, lLevel);
        memberRegistry.addMemeber(member);
        return "Member " + member.getName() + " added successfully";
    }

    /**
     * Returns the enum lever if there is any matcing the string
     * @param level level as string
     * @return the Level or null if no Level was found
     */
    private Level getLevel(String level) {
        level = level.toUpperCase();
        try {

            return Level.valueOf(level);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /**
     * Returns all members
     * @return Set of all members
     */
    public List<Member> getAllMembers() {
        return memberRegistry.getMembers();
    }

    /**
     * Returns a member y members id
     * @param memberID id of member to get
     * @return member or null if no member was found
     */
    public Member searchMember(String memberID) {
        return memberRegistry.getMember(memberID);

    }

    /**
     * Changes a members lastname and/or level
     * @param memberID id of member to change
     * @param lastName new last name or "" if not to change
     * @param level new level or "" if not to change
     * @return string for the user
     */
    public String changeMember(String memberID, String lastName, String level) {
        Member tempMember;
        if (level != "" && lastName != "") {
            Level lLevel = getLevel(level);
            if (lLevel == null) {
                return level + " is not a valid level";
            }
            tempMember = memberRegistry.changeMember(memberID, lastName, lLevel);

        } else if (level != "" && lastName == "") {
            Level lLevel = getLevel(level);
            if (lLevel == null) {
                return level + " is not a valid level";
            }
            tempMember = memberRegistry.changeMember(memberID, lLevel);
        } else {
            tempMember = memberRegistry.changeMember(memberID, lastName);
        }
        if (tempMember == null) {
            return "Member " + memberID + " could not be changed";
        }
        return "Member " + memberID + " changed successfully";
    }

    /**
     * Removes a member, returns a string for the user
     * @param memberID, the id of member to remove
     * @return string for the user
     */
    public String removeMember(String memberID) {
        Member tempMember = memberRegistry.removeMember(memberID);
        if (tempMember == null) {
            return "Member " + memberID + " could not be removed";
        }
        return "Member " + memberID + " removed";
    }
}
