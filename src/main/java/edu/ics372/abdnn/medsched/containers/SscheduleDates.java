package edu.ics372.abdnn.medsched.containers;

import edu.ics372.abdnn.medsched.entities.ScheduleDate;
import edu.ics372.abdnn.medsched.enums.Availabilty;
import edu.ics372.abdnn.medsched.interfaces.BagWrapper;

import java.util.Iterator;
import java.util.function.Predicate;

public class SscheduleDates implements BagWrapper<ScheduleDate> {
    private final Bag<ScheduleDate> dateTimeSlots;
    public SscheduleDates () {
        dateTimeSlots = new Bag<ScheduleDate>();
    } //

    @Override
    public int size () { return dateTimeSlots.size(); }

    @Override
    public Bag<ScheduleDate> getBag () { return dateTimeSlots; }

    @Override
    public void add (ScheduleDate scheduleDate) { dateTimeSlots.add(scheduleDate); }

    @Override
    public ScheduleDate pop (ScheduleDate scheduleDate) { return dateTimeSlots.pop(scheduleDate); }

    @Override
    public void remove (ScheduleDate scheduleDate) { dateTimeSlots.remove(scheduleDate);}

    @Override
    public Iterator<ScheduleDate> iterator () { return dateTimeSlots.iterator(); }

    @Override
    public Iterator<ScheduleDate> filter (Predicate<ScheduleDate> predicate) { return dateTimeSlots.filter(predicate); }

    public Iterator<ScheduleDate> getAvailableDateTimeSlots () {
        Predicate<ScheduleDate> predicate = dateTimeslot -> dateTimeslot.getAvailabilty().equals(Availabilty.OPEN);
        return filter(predicate);
    } // close getAvailableDateTimeSlots
} // end class DateTimeSlots
