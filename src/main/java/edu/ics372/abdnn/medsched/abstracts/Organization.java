package edu.ics372.abdnn.medsched.abstracts;

import java.util.*;

public abstract class Organization extends NamedEntity {
    private ArrayList<Integer> memberIds;

    public Organization (int id, String name) {
        super(id, name);
        this.memberIds = new ArrayList<>();
    } // close constructor


    public ArrayList<Integer> getMemberIds () { return memberIds; }


    public void addMemberId (int memberId) {
        if (!memberIds.contains(memberId))
            memberIds.add(memberIds.size(), memberId);
    }

    public void removeMemberId (Integer memberId) {
        if (memberIds.contains(memberId))
            memberIds.remove(memberIds.indexOf(memberId));
    }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Organization org) {
            return super.equals(org);
        }
        return false;
    } // close equals


    @Override
    public String toString () {
        return super.toString();
    }
} // end class Organization
