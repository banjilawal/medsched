package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.AnonymousEntity;

import java.time.DateTimeException;
import java.util.Date;
import java.util.Objects;

public class Period extends AnonymousEntity  {
    private Date date;
    private Duration duration;

    public Period (Date date,  Duration duration) {
        this.date = date;
        this.duration = duration;
    }

    public Date getDate () { return date; }
    public Duration getDuration () { return duration; }

    public void setDate (Date date) { this.date = date; }

    public void setDuration  (Duration duration) { this.duration = duration; }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Period period) {
            return date.equals(period.getDate()) && duration.equals(period.getDuration());
        }
        return false;
    }

    @Override
    public int hashCode () { return Objects.hash(date, duration); }
} // end class Period