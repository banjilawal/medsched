package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.AnonymousEntity;

import java.time.LocalTime;
import java.util.Objects;

public class Interval extends AnonymousEntity {
    private LocalTime start;
    private LocalTime end;

    public Interval (LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    } //

    public LocalTime getStart () {
        return start;
    }

    public LocalTime getEnd () {
        return end;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object instanceof Interval timeslot) {
            return super.equals(timeslot) && sameTimes(timeslot);
        }
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), start, end);
    }

    @Override
    public String toString () {
        return super.toString() + " start:" + start.toString() + " end:" + end.toString();
    }

    public boolean sameTimes (Interval timeslot) {
        return start.equals(timeslot.getStart()) && end.equals(timeslot.getEnd());
    }
} // end class Timeslot
