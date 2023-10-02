package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.*;
import edu.ics372.abdnn.medsched.enums.*;

import java.time.*;
import java.util.*;

public class Period extends AnonymousEntity {
    private final LocalDate date;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private BookingStatus status;


    public Period (LocalDate date,  LocalTime startTime, LocalTime endTime) {
        super(id);
        if (startTime.isAfter(endTime)) {
            throw new IllegalArgumentException("Period 19: startTime cannot be later than endTime");
        }

        if (startTime.equals(endTime)) {
            throw new IllegalArgumentException("Period 23: startTime and endTime cannot be the same");
        }
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
        if (object instanceof Period period) {
            return date.equals(period.getDate())
                && startTime.equals(period.getStartTime())
                && endTime.equals(period.getEndTime());
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
        LocalTime target = initialTime.minusHours(1);
        return this.date.isEqual(date) && startTime.isAfter(target) && endTime.isBefore(target);
    }


    public boolean inDateTimeRange (LocalDate startDate, LocalDate endDate, LocalTime timeFloor, LocalTime timeCeiling) {
        return period.getDate().isAfter(startDate.minusDays(1))
            && period.getDate().isBefore(endDate.plusDays(1))
            && period.getStartTime().isAfter(timeFloor.minusHours(1))
            && period.getEndTime().isBefore(timeCeiling.plusHours(1));
    }
} // end class Period
