package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.*;
import edu.ics372.abdnn.medsched.catalogs.*;

import java.util.*;

public class Department extends Organization  {
    public Department (int id, String name) {
        super(id, name);

    } // close constructor


    public void addMember (Provider provider) {
        addMemberId(provider.getId());
    }



    public void removeMember (Provider member) {
        removeMemberId(member.getId());
    }


    public Iterator<Provider> getMembers () {
        ArrayList<Provider> matches = new ArrayList<>();
        for (Integer memberId : getMemberIds()) {
            Provider member = Providers.INSTANCE.search(memberId);
            if (!matches.contains(member)) {
                matches.add(matches.size(), member);
            }
        }
        return matches.iterator();
    }


    public Provider getMember (int providerId) {
        if (getMemberIds().contains(providerId))
            return Providers.INSTANCE.search(providerId);
        return null;
    }


//    public Iterator<Provider> getAvailableProviders () {
//        Predicate<Provider> predicate = provider -> provider.getAvailabilty().equals(State.OPEN);
//        return filterProviders(predicate);
//    } // close getAvailableProviders

//    public Iterator<Provider> filterProviders (Predicate<Provider> predicate) {
//        ArrayList<Provider> matches = new ArrayList<Provider>();
//        for (Person person : getMembers().getPeople()) {
//            Provider provider = (Provider) person;
//            if (predicate.test(provider) && !matches.contains(provider))
//                matches.add(matches.size(), provider);
//        }
//        return matches.iterator();
//    } // close filterProviders




    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Department department) return super.equals(department);
        return false;
    } // close equals
} // end class
