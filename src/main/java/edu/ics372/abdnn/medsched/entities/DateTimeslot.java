package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.Entity;
import edu.ics372.abdnn.medsched.enums.Availabilty;

import java.util.Date;
import java.util.Objects;

public class DateTimeslot extends Entity  {
    private Date date;
    private Timeslot timeslot;
    private Availabilty availabilty;

    public DateTimeslot (int id, Date date, Timeslot timeslot) {
        super(id);
        this.date = date;
        this.timeslot = timeslot;
        this.availabilty = Availabilty.OPEN;
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
        if (object instanceof DateTimeslot dateTimeslot) {
            return super.equals(dateTimeslot)
                && date.equals(dateTimeslot.getDate())
                && timeslot.equals(dateTimeslot.getTimeslot())
                && availabilty.equals(dateTimeslot.getAvailabilty());
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
