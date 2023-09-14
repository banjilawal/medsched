package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.AnonymousEntity;
import edu.ics372.abdnn.medsched.enums.Availability;

import java.time.LocalDate;
import java.util.Objects;

public class OldPeriod extends AnonymousEntity  {
    private final LocalDate date;
    private final Duration duration;
    private Availability availability;

    public OldPeriod (LocalDate date, Duration duration) {
        this.date = date;
        this.duration = duration;
    }

    public LocalDate getDate () { return date; }
    public Duration getDuration ()  { return duration; }



//    public void setDate (Date date) { this.date = date; }
//
//    public void setDuration  (Duration duration) { this.duration = duration; }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof OldPeriod period) {
            return date.equals(period.getDate()) && duration.equals(period.getDuration());
        }
        return false;
    }

    @Override
    public int hashCode () { return Objects.hash(date, duration); }

    @Override
    public String toString () {
        return super.toString() + " " + date.toString()
            + " start:" + duration.getStart().toString()
            + " :" + duration.getEnd().toString();
    }
} // end class Period
