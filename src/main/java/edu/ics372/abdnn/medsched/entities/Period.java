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
            throw new IllegalArgumentException("Period 22: startTime cannot be later than endTime");
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


    public boolean withinRange (LocalDate date,  LocalTime time) {
        LocalTime target = initialTime.minusHours(1);
        return this.date.isEqual(date) && startTime.isAfter(target) && endTime.isBefore(target);
    }


    public boolean withinRange (LocalDate startDate, LocalDate endDate, LocalTime beginning, LocalTime end) {
        LocalDate a = startDate.minusDays(1);
        LocalDate b = endDate.plusDays(1);
        LocalTime timeX = beginning.minusHours(1);
        LocalTime timeZ = end.plusHours(1);
        return day.isAfter(a) && day.isBefore(b) && startTime.isAfter(timeX) && end.isBefore(timeZ);
    } //
} // end class Period
