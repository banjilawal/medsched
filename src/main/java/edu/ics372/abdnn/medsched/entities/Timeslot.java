package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.AnonymousEntity;
import edu.ics372.abdnn.medsched.abstracts.Entity;
import edu.ics372.abdnn.medsched.abstracts.NamedEntity;
import edu.ics372.abdnn.medsched.abstracts.Resource;
import edu.ics372.abdnn.medsched.enums.Availabilty;
import edu.ics372.abdnn.medsched.interfaces.DurationLockable;
import edu.ics372.abdnn.medsched.interfaces.IdNumber;
import javafx.css.converter.DurationConverter;

import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

public class Timeslot extends NamedEntity implements DurationLockable {
    private Duration duration;
    private Availabilty availabilty;
    private DurationLock durationLock;


    public Timeslot (int id, String name,Duration duration) {
        super(id, name);
        this.duration = duration;
        this.durationLock = null;
        this.availabilty = Availabilty.OPEN;
    } //

    public Duration getDuration () {
        return duration;
    }

    public void setDuration (Duration duration) {
        this.duration = duration;
    }

    @Override
    public Availabilty getAvailabilty () { return availabilty; }

     @Override
    public DurationLock getDurationLock () { return durationLock; }


    @Override
    public void book (Date date) {
        if (durationLock == null && availabilty.equals(Availabilty.OPEN)) {
            this.durationLock = new DurationLock(date, duration);
            this.availabilty = Availabilty.CLOSED;
        }
    }

    @Override
    public void cancel () {
        if (durationLock != null) {
            this.durationLock = null;
            this.availabilty = Availabilty.OPEN;
        }
    }



    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Timeslot timeslot) {
            return super.equals(timeslot) && duration.equals(timeslot.getDuration());
        }
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), duration);
    }

    @Override
    public String toString () {
        return super.toString() + " start:" + duration.getStart().toString() + " end:" + duration.getEnd().toString();
    }
} // end class Timeslot
