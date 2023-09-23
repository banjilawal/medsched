package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.*;

import java.time.*;
import java.util.*;

public class OldPeriod extends AnonymousEntity  {
    private final LocalDate date;
    private final Interval interval;
//    private State availability;

    public OldPeriod (LocalDate date, Interval interval) {
        this.date = date;
        this.interval = interval;
    }

    public LocalDate getDate () { return date; }
    public Interval getDuration ()  { return interval; }



//    public void setDate (Date date) { this.date = date; }
//
//    public void setDuration  (Duration duration) { this.duration = duration; }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof OldPeriod period) {
            return date.equals(period.getDate()) && interval.equals(period.getDuration());
        }
        return false;
    }

    @Override
    public int hashCode () { return Objects.hash(date, interval); }

    @Override
    public String toString () {
        return super.toString() + " " + date.toString()
            + " start:" + interval.getStart().toString()
            + " :" + interval.getEnd().toString();
    }
} // end class Period