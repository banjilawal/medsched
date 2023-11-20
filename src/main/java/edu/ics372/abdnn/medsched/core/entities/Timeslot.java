package edu.ics372.abdnn.medsched.core.entities;

import edu.ics372.abdnn.medsched.core.abstracts.*;
import edu.ics372.abdnn.medsched.core.enums.*;

import java.time.*;
import java.time.temporal.*;
import java.util.*;

public class Timeslot extends AnonymousEntity {
    private final LocalDate date;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private BookingStatus status;


    public Timeslot (LocalDate date, LocalTime startTime, LocalTime endTime) {
//        if (startTime.isAfter(endTime)) {
//            throw new IllegalArgumentException("Period 19: startTime cannot be later than endTime");
//        }

//        if (startTime.equals(endTime)) {
//            throw new IllegalArgumentException("Period 23: startTime and endTime cannot be the same");
//        }
        this.status = BookingStatus.AVAILABLE;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDate getDate () { return date; }

    public BookingStatus getStatus () {
        return status;
    }


    public LocalTime getStartTime () {
        return startTime;
    }

    public LocalTime getEndTime () {
        return endTime;
    }

    public void setStatus (BookingStatus status) {
        this.status = status;
    }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Timeslot timeSlot) {
            return date.equals(timeSlot.getDate())
                && startTime.equals(timeSlot.getStartTime())
                && endTime.equals(timeSlot.getEndTime());
        }
        return false;
    }


    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), date, startTime, endTime, status);
    }


    @Override
    public String toString () {
        return super.toString() + " " + date.toString() + " start:" + startTime.toString()
            + " end:" + endTime.toString();
    }


    public boolean inDateTimeRange (LocalDate date, LocalTime time) {
        LocalTime target = time.minusHours(1);
        return this.date.isEqual(date) && startTime.isBefore(target) && endTime.isAfter(target);
    }


    public static boolean inDateTimeRange (Timeslot timeslot, LocalDate startDate, LocalDate endDate, LocalTime timeFloor, LocalTime timeCeiling) {
        return timeslot.getDate().isAfter(startDate.minusDays(1))
            && timeslot.getDate().isBefore(endDate.plusDays(1))
            && timeslot.getStartTime().isAfter(timeFloor.minusHours(1))
            && timeslot.getEndTime().isBefore(timeCeiling.plusHours(1));
    }

    public static ArrayList<Timeslot> getTimeslots (LocalDate startDate, LocalDate endDate, LocalTime timeFloor, LocalTime timeCeiling) {
        ArrayList<Timeslot> timeslots = new ArrayList<>();
        LocalDateTime start = LocalDateTime.of(startDate, timeFloor);
        LocalDateTime end = LocalDateTime.of(endDate.plusDays(1), timeCeiling.plusHours(1));
        long numberOfDays = ChronoUnit.DAYS.between(startDate, endDate);
        long numberOfHours = ChronoUnit.HOURS.between(timeFloor,timeCeiling);

        for (int dayIndex = 0; dayIndex < numberOfDays; dayIndex++)  {
            LocalDate currentDate = startDate.plusDays(dayIndex);
            for (int hourIndex = 0; hourIndex < numberOfHours; hourIndex++) {
                LocalTime startTime = timeFloor.plusHours(hourIndex);
                LocalTime endTime = startTime.plusHours(1);
                Timeslot timeslot = new Timeslot(currentDate, startTime, endTime);
                timeslots.add(timeslots.size(), timeslot);
//                System.out.println(timeslot.toString());
            }
        }
//        long numberOfTimeSlots = ChronoUnit.HOURS.between(start, end);
//        long count = 0;
//        System.out.println("number of timeslots " + numberOfTimeSlots);
//        LocalDateTime currentDateTime = start;
//        while (count < numberOfTimeSlots) {
//            currentDateTime = currentDateTime.plusHours(count);
////            System.out.println(currentDateTime.toString() + "\t" + count);
//            LocalTime startTime = currentDateTime.toLocalTime();
//            LocalTime endTime = startTime.plusHours(1);
//            if (startTime.isAfter(timeFloor.minusMinutes(1)) && endTime.isBefore(timeCeiling.plusMinutes(1))) {
//
//            }
//
//            count++;
//        }
        return timeslots;
    }
} // end class Period
