package edu.ics372.abdnn.medsched.containers;

import edu.ics372.abdnn.medsched.entities.Day;
import edu.ics372.abdnn.medsched.enums.Availability;
import edu.ics372.abdnn.medsched.interfaces.BagWrapper;

import java.util.Iterator;
import java.util.function.Predicate;

public class SscheduleDates implements BagWrapper<Day> {
    private final Bag<Day> dateTimeSlots;
    public SscheduleDates () {
        dateTimeSlots = new Bag<Day>();
    } //

    @Override
    public int size () { return dateTimeSlots.size(); }

    @Override
    public Bag<Day> getBag () { return dateTimeSlots; }

    @Override
    public void add (Day day) { dateTimeSlots.add(day); }

    @Override
    public Day pop (Day day) { return dateTimeSlots.pop(day); }

    @Override
    public void remove (Day day) { dateTimeSlots.remove(day);}

    @Override
    public Iterator<Day> iterator () { return dateTimeSlots.iterator(); }

    @Override
    public Iterator<Day> filter (Predicate<Day> predicate) { return dateTimeSlots.filter(predicate); }

    public Iterator<Day> getAvailableDateTimeSlots () {
        Predicate<Day> predicate = dateTimeslot -> dateTimeslot.getAvailabilty().equals(Availability.OPEN);
        return filter(predicate);
    } // close getAvailableDateTimeSlots
} // end class DateTimeSlots
