package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.Entity;
import edu.ics372.abdnn.medsched.abstracts.NamedEntity;

import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

public class DateTimeslot extends Entity  {
    private Date date;
    private Timeslot timeslot;

    public DateTimeslot (int id, Date date, Timeslot timeslot) {
        super(id);
        this.date = date;
        this.timeslot = timeslot;
    }

    public Date getDate () { return date; }

    public Timeslot getTimeslot () { return timeslot; }

    public void setDate (Date date) { this.date = date; }

    public void setSTimeslot (Timeslot timeslot)  {
        this.timeslot = timeslot;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof DateTimeslot dateTimeslot) {
            return super.equals(dateTimeslot) && date.equals(dateTimeslot.getDate()) && timeslot.equals(dateTimeslot.getTimeslot());
        }
        return false;
    } //

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), date, timeslot);
    } //

    @Override
    public String toString () {
        return super.toString() + "date:" + date + " " +  timeslot.toString();
    }
} // end class Timeslot
