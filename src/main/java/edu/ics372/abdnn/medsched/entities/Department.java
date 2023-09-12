package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.Organization;
import edu.ics372.abdnn.medsched.abstracts.Person;
import edu.ics372.abdnn.medsched.containers.SscheduleDates;
import edu.ics372.abdnn.medsched.enums.Availability;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public class Department extends Organization  {
    public Department (int id, String name) {
        super(id, name);
    } // close constructor


    public Iterator<Provider> getAvailableProviders () {
        Predicate<Provider> predicate = provider -> provider.getAvailabilty().equals(Availability.OPEN);
        return filterProviders(predicate);
    } // close getAvailableProviders

    public Iterator<Provider> filterProviders (Predicate<Provider> predicate) {
        ArrayList<Provider> matches = new ArrayList<Provider>();
        for (Person person : getMembers().getPeople()) {
            Provider provider = (Provider) person;
            if (predicate.test(provider) && !matches.contains(provider))
                matches.add(matches.size(), provider);
        }
        return matches.iterator();
    } // close filterProviders


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Department department) return super.equals(department);
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return super.hashCode();
    }
} // end class
