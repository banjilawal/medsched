package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.Entity;
import edu.ics372.abdnn.medsched.containers.Bag;
import edu.ics372.abdnn.medsched.enums.Status;
import edu.ics372.abdnn.medsched.global.Constant;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

public class Day extends Entity  {
    private final LocalDate date;
    private final Bag<Timeslot> timeslots;


    public Day (int id, LocalDate date) {
        super(id);
        this.date = date;
        this.timeslots = new Bag<Timeslot>();
        addTimeslots();
    }

    public LocalDate getDate () { return date; }

    public ArrayList<Timeslot> getTimeslots () { return timeslots.getContents(); }

    public Timeslot getFirstOpening () {
        for (Timeslot timeslot : timeslots.getContents()) {
            if (timeslot.getAvailability().equals(Status.OPEN))
                return timeslot;
        }
        return null;
    }

    public Iterator<Timeslot> getOpenings () {
        Predicate<Timeslot> predicate = timeslot -> {timeslot.getAvailability().equals(Status.OPEN)};
        return timeslots.filter(predicate);
    }

    public int getTimeslotIndex (LocalTime start, LocalTime end) {
        for (Timeslot timeslot : timeslots.getContents()) {
            if (Objects.equals(timeslot.getStart(), start) && Objects.equals(timeslot.getEnd(), end))
                return timeslots.indexOf(timeslot);
        }
        return Integer.MIN_VALUE;
    }

    public int getTimeslotIndex (LocalTime start) {
        for (Timeslot timeslot : timeslots.getContents()) {
            if (Objects.equals(timeslot.getStart(), start)
                return timeslots.indexOf(timeslot);
        }
        return Integer.MIN_VALUE;
    }
//
//    public boolean book (Provider provider, Patient patient, LocalTime start) {
//        int arrayIndex = getTimeslotIndex(start);
//        if (arrayIndex >= 0) {
//            return timeslots.get(arrayIndex).book(date, provider, patient);
//        }
//        return false;
//    }


//    public void bookTimeSlot (Timeslot timeslot) {
//        int arrayIndex = getArrayIndex(timeslot);
//        if (arrayIndex > Integer.MIN_VALUE && isOpen(timeslot))  {
//            timeslots.get(arrayIndex).setAvailabilty(State.CLOSED);
//        }
//    }
//
//
//    public void releaseTimeslot (Timeslot timeslot) {
//        int arrayIndex = getArrayIndex(timeslot);
//        if (arrayIndex > Integer.MIN_VALUE && !isOpen(timeslot))  {
//            timeslots.get(arrayIndex).setAvailabilty(State.OPEN);
//        }
//    }


    public boolean isOpen (Timeslot timeslot) {
        if (timeslots.contains(timeslot) ) {
            return timeslots.get(timeslots.indexOf(timeslot)).getAvailability() == Status.OPEN;
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
        int id;
        int count = 0;
        String name = "";
        LocalTime startTime = Constant.OPENING_TIME;
        LocalTime endTime = Constant.OPENING_TIME;

        while (count < Constant.DAILY_TIMESLOT_TOTAL) {
            id = count + 1;
            name = "T-" + id;
            endTime = startTime.plusMinutes(Constant.TIMESLOT_MINUTES);
            timeslots.add(new Timeslot(id, name, startTime, endTime));
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
            builder.append("\n\t").append(timeslot.toString());
        }
        return builder.toString();
    }
} // end class Timeslot
