package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.Entity;
import edu.ics372.abdnn.medsched.enums.Availability;
import edu.ics372.abdnn.medsched.global.Constant;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class Day extends Entity  {
    private final LocalDate date;
    private final ArrayList<Timeslot> timeslots;


    public Day (int id, LocalDate date) {
        super(id);
        this.date = date;
        this.timeslots = new ArrayList<Timeslot>();
        addTimeslots();
    }

    public LocalDate getDate () { return date; }

    public ArrayList<Timeslot> getTimeslots () { return timeslots; }

    public Timeslot getFirstOpenTimeSLot () {
        for (Timeslot timeslot : timeslots) {
            if (timeslot.getAvailabilty() == Availability.OPEN) return timeslot;
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
            timeslots.get(arrayIndex).setAvailabilty(Availability.CLOSED);
        }
    }


    public void releaseTimeslot (Timeslot timeslot) {
        int arrayIndex = getArrayIndex(timeslot);
        if (arrayIndex > Integer.MIN_VALUE && !isOpen(timeslot))  {
            timeslots.get(arrayIndex).setAvailabilty(Availability.OPEN);
        }
    }


    public boolean isOpen (Timeslot timeslot) {
        if (timeslots.contains(timeslot) ) {
            return timeslots.get(timeslots.indexOf(timeslot)).getAvailabilty() == Availability.OPEN;
        }
        return false;
    }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Day day) {
            return super.equals(day) && date.equals(day.getDate());
        }
        return false;
    } // close equals



    private void addTimeslots () {
        int count = 0;
        LocalTime startTime = Constant.OPENING_TIME;
        LocalTime endTime = Constant.OPENING_TIME;
        while (count < Constant.DAILY_TIMESLOT_TOTAL) {
            endTime = startTime.plusMinutes(Constant.TIMESLOT_MINUTES);
            timeslots.add(new Timeslot((count + 1), ("T-" + (count + 1)), startTime, endTime));
            startTime = endTime.plusMinutes(Constant.APPOINTMENT_SWITCH_OVER_TIME);
            count++;
        }
    }


    public String toString () {
        return super.toString() + " " + date.toString() + printTimeslots();
    }

    public String printTimeslots () {
        StringBuilder builder = new StringBuilder();
        for (Timeslot timeslot : timeslots) {
            builder.append("\n").append(timeslot.toString());
        }
        return builder.toString();
    }
} // end class Timeslot
