package com.ljuslin.repository;

import com.ljuslin.rental.Member;
import com.ljuslin.utils.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MemberRegistry {
    private List<Member> members = new ArrayList<>();

    public MemberRegistry() {
        members.add(new Member("Christer", "Andersson", Level.PREMIUM));
        members.add(new Member("Peter", "Karlsson", Level.STANDARD));
        members.add(new Member("Kalle", "Sturesson", Level.STUDENT));
        members.add(new Member("Sture", "Evertsson", Level.STANDARD));
        members.add(new Member("Evert", "Larsson", Level.STUDENT));
        members.add(new Member("Karl", "Stigsson", Level.PREMIUM));
        members.add(new Member("Lars", "Christersson", Level.STANDARD));
        members.add(new Member("Stig-Helmer", "Pettersson", Level.STANDARD));
    }

    /**
     * Returns a member for a specific ID
     * @param id, the id to search
     * @return the member
     */
    public Member getMember(String id) {
        for (Member member : members) {
            if (member.getMemberID().equals(id)) {
                return member;
            }
        }
        return null;
    }

    /**
     * Changes a members last name and level
     * @param memberID id of member to change
     * @param lastName new last name
     * @param level new level
     * @return the new member
     */
    public Member changeMember(String memberID, String lastName, Level level) {
        for (Member m : members) {
            if (m.getMemberID().equals(memberID)) {
                m.setLastName(lastName);
                m.setMemberLevel(level);
                return m;
            }
        }
        return null;
    }
    /**
     * Changes a members last name
     * @param memberID id of member to change
     * @param lastName new last name
     * @return the new member
     */
    public Member changeMember(String memberID, String lastName) {
        for (Member m : members) {
            if (m.getMemberID().equals(memberID)) {
                m.setLastName(lastName);
                return m;
            }
        }
        return null;
    }
    /**
     * Changes a members level
     * @param memberID id of member to change
     * @param level new level
     * @return the new member
     */
    public Member changeMember(String memberID, Level level) {
        for (Member m : members) {
            if (m.getMemberID().equals(memberID)) {
                m.setMemberLevel(level);
                return m;
            }
        }
        return null;
    }
    public Member removeMember(String memberID) {
        for (Member m : members) {
            if (m.getMemberID().equals(memberID)) {
                members.remove(m);
                return m;
            }
        }
        return null;
    }
    /**
     * Returns all members
     * @return all members
     */
    public List<Member> getMembers() {
        return members;
    }

    /**
     * Adds a member
     * @param member the member to add
     */
    public void addMemeber(Member member) {
        members.add(member);
    }
}
