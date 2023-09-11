package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.Entity;
import edu.ics372.abdnn.medsched.enums.Availabilty;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class ScheduleDate extends Entity  {
    private Date date;
    private final ArrayList<Timeslot> timeslots;

    public ScheduleDate (int id, Date date, Timeslot timeslot) {
        super(id);
        this.date = date;
        this.timeslots = new ArrayList<Timeslot>();
    }

    public Date getDate () { return date; }

    public ArrayList<Timeslot> getTimeslots () { return timeslots; }

    public Timeslot getFirstOpenTimeSLot () {
        for (Timeslot timeslot : timeslots) {
            if (timeslot.getAvailabilty() == Availabilty.OPEN) return timeslot;
        }
        return null;
    }


    private int getArrayIndex (Timeslot timeslot) {
        if (timeslots.contains(timeslot)) return timeslots.indexOf(timeslot);
        return Integer.MIN_VALUE;
    }


    public void bookTimeSlot (Timeslot timeslot) {
        int arrayIndex = getArrayIndex(timeslot);
        if (arrayIndex > Integer.MIN_VALUE && isOpen(timeslot))  {
            timeslots.get(arrayIndex).setAvailabilty(Availabilty.CLOSED);
        }
    }


    public void releaseTimeslot (Timeslot timeslot) {
        int arrayIndex = getArrayIndex(timeslot);
        if (arrayIndex > Integer.MIN_VALUE && !isOpen(timeslot))  {
            timeslots.get(arrayIndex).setAvailabilty(Availabilty.OPEN);
        }
    }


    public boolean isOpen (Timeslot timeslot) {
        if (timeslots.contains(timeslot) ) {
            return timeslots.get(timeslots.indexOf(timeslot)).getAvailabilty() == Availabilty.OPEN;
        }
        return false;
    }


    public void setDate (Date date) { this.date = date; }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof ScheduleDate scheduleDate) {
            return super.equals(scheduleDate)
                    && date.equals(scheduleDate.getDate());
        }
        return false;
    } // close equals
} // end class Timeslot
