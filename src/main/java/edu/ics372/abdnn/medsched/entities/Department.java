package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.Organization;
import edu.ics372.abdnn.medsched.abstracts.Person;
import edu.ics372.abdnn.medsched.containers.DateTimesSlots;
import edu.ics372.abdnn.medsched.enums.Availabilty;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public class Department extends Organization  {
    private final DateTimesSlots dateTimesSlots;
    public Department (int id, String name) {
        super(id, name);
        this.dateTimesSlots = new DateTimesSlots();
    } // close constructor

    public DateTimesSlots getDateTImeSlots () { return dateTimesSlots; }

    public Iterator<ScheduleDate> openSlots () { return dateTimesSlots.getAvailableDateTimeSlots(); }

    public Iterator<Provider> getAvailableProviders () {
        Predicate<Provider> predicate = provider -> provider.getAvailabilty().equals(Availabilty.OPEN);
        return filterProviders(predicate);
    } // close getAvailableProviders

    public Iterator<ScheduleDate> filterDateTimeslots (Predicate<ScheduleDate> predicate) {
        return dateTimesSlots.filter(predicate);
    }

    public Iterator<Provider> filterProviders (Predicate<Provider> predicate) {
        ArrayList<Provider> matches = new ArrayList<Provider>();
        for (Person person : getMembers().getPeople()) {
            Provider provider = (Provider) person;
            if (predicate.test(provider) && !matches.contains(provider))
                matches.add(matches.size(), provider);
        }
        return matches.iterator();
    } // close filterProviders


    public void addDateTimeSlots (ArrayList<ScheduleDate> dateTimesSlots) {
        for (ScheduleDate scheduleDate : dateTimesSlots) {
            addSlot(scheduleDate);
        }
    } // close addDateTimeSlots

    public void addSlot (ScheduleDate scheduleDate) { dateTimesSlots.getBag().add(scheduleDate); }

    public void removeDateTimeSlots (ArrayList<ScheduleDate> dateTimesSlots) {
        for (ScheduleDate scheduleDate : dateTimesSlots) {
            removeSlot(scheduleDate);
        }
    } // end removeDateTimeSlots

    public void removeSlot (ScheduleDate scheduleDate) { dateTimesSlots.getBag().add(scheduleDate); }

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

    @Override
    public String toString () { return super.toString() + " Schedule:\n" + dateTimesSlots.toString(); }
} // end class
