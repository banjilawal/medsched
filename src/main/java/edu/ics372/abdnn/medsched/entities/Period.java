package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.*;
import edu.ics372.abdnn.medsched.enums.*;

import java.time.*;
import java.util.*;

public class Period extends Entity {
    private final String timeslotName;
    private final int timeslotId;
    private final int departmentId;
    private final LocalDate date;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private BookingStatus status;


//    private State availability;

    public Period (int id, int timeslotId, String timeslotName, Department department, LocalDate date,  LocalTime startTime, LocalTime endTime) {
        super(id);
        if (startTime.isAfter(endTime)) {
            throw new IllegalArgumentException("Period 22: startTime cannot be later than endTime");
        }
        this.timeslotId = timeslotId;
        this.timeslotName = timeslotName;
        this.departmentId = department.getId();
        this.status = BookingStatus.AVAILABLE;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDate getDate () { return date; }

    public BookingStatus getStatus () {
        return status;
    }

    public String getTimeslotName () {
        return timeslotName;
    }

    public int getTimeslotId () {
        return timeslotId;
    }

    public int getDepartmentId () { return departmentId; }

    public LocalTime getStartTime () {
        return startTime;
    }

    public LocalTime getEndTime () {
        return endTime;
    }

    public void setStatus (BookingStatus status) {
        this.status = status;
    }
//    public void setDate (Date date) { this.date = date; }
//
//    public void setDuration  (Duration duration) { this.duration = duration; }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Period period) {
            return getId() == period.getId()
                && timeslotId == period.getTimeslotId()
                && departmentId == period.getDepartmentId()
                && startTime.equals(period.getStartTime())
                && endTime.equals(period.getEndTime())
                && date.equals(period.getDate())
                && timeslotName.equalsIgnoreCase(period.getTimeslotName());
        }
        return false;
    }


    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), timeslotName, timeslotId, departmentId, date, startTime, endTime, status);
    }


    @Override
    public String toString () {
        return super.toString() + " " + date.toString()
            + " timeslotId:" + timeslotId
            + " timeslotName:" + timeslotName
            + " start:" + startTime.toString()
            + " :" + endTime.toString();
    }
} // end class Period
