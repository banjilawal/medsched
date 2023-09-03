package edu.ics372.abdnn.medsched.containers;

import edu.ics372.abdnn.medsched.entities.DateTimeslot;
import edu.ics372.abdnn.medsched.enums.Availabilty;
import edu.ics372.abdnn.medsched.interfaces.BagWrapper;

import java.util.Iterator;
import java.util.function.Predicate;

public class DateTimesSlots implements BagWrapper<DateTimeslot> {
    private final Bag<DateTimeslot> dateTimeSlots;
    public DateTimesSlots () {
        dateTimeSlots = new Bag<DateTimeslot>();
    } //

    @Override
    public int size () { return dateTimeSlots.size(); }

    @Override
    public Bag<DateTimeslot> getBag () { return dateTimeSlots; }

    @Override
    public void add (DateTimeslot dateTimeslot) { dateTimeSlots.add(dateTimeslot); }

    @Override
    public DateTimeslot pop (DateTimeslot dateTimeslot) { return dateTimeSlots.pop(dateTimeslot); }

    @Override
    public void remove (DateTimeslot dateTimeslot) { dateTimeSlots.remove(dateTimeslot);}

    @Override
    public Iterator<DateTimeslot> iterator () { return dateTimeSlots.iterator(); }

    @Override
    public Iterator<DateTimeslot> filter (Predicate<DateTimeslot> predicate) { return dateTimeSlots.filter(predicate); }

    public Iterator<DateTimeslot> getAvailableDateTimeSlots () {
        Predicate<DateTimeslot> predicate = dateTimeslot -> dateTimeslot.getAvailabilty().equals(Availabilty.OPEN);
        return filter(predicate);
    } // close getAvailableDateTimeSlots
} // end class DateTimeSlots
