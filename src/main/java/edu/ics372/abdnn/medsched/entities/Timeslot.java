package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.AnonymousEntity;
import edu.ics372.abdnn.medsched.abstracts.Entity;
import edu.ics372.abdnn.medsched.abstracts.Resource;
import edu.ics372.abdnn.medsched.interfaces.IdNumber;

import java.time.LocalTime;
import java.util.Objects;

public class Timeslot extends Resource {
    private Duration duration;


    public Timeslot (int id, String name,Duration duration) {
        super(id, name);
        this.duration = duration;
    } //

    public Duration getDuration () {
        return duration;
    }

    public void setDuration (Duration duration) {
        this.duration = duration;
    }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Timeslot timeslot) {
            return super.equals(timeslot) && duration.equals(timeslot.getDuration()));
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
