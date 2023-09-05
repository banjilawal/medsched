package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.Entity;
import edu.ics372.abdnn.medsched.enums.Availabilty;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class ScheduleDate extends Entity  {
    private Date date;
    private ArrayList<Timeslot> timeslots;

    public ScheduleDate (int id, Date date, Timeslot timeslot) {
        super(id);
        this.date = date;
        this.timeslots = new ArrayList<Timeslot>();
    }

    public Date getDate () { return date; }

    public Timeslot getTimeslot () { return timeslot; }

    public Availabilty getAvailabilty () { return availabilty; }

    public void setDate (Date date) { this.date = date; }

    public void setSTimeslot (Timeslot timeslot)  {
        this.timeslot = timeslot;
    }

     public void setAvailabilty (Availabilty availabilty) { this.availabilty = availabilty; }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof ScheduleDate scheduleDate) {
            return super.equals(scheduleDate)
                && date.equals(scheduleDate.getDate())
                && timeslot.equals(scheduleDate.getTimeslot())
                && availabilty.equals(scheduleDate.getAvailabilty());
        }
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), date, timeslot, availabilty);
    } //

    @Override
    public String toString () {
        return super.toString() + "date:" + date + " " +  timeslot.toString() + " " + availabilty.toString();
    }
} // end class Timeslot
