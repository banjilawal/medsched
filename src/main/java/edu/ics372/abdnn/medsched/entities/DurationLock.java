package edu.ics372.abdnn.medsched.entities;

import java.time.LocalTime;
import java.util.Date;

public class DurationLock {
    private Date date;
    Duration duration;

    public DurationLock (Date date, Duration duration) {
        this.date = date;
        this.duration = duration;
    } //

    public Date getDate () { return date; }
    public Duration getDuration () { return duration; }
}
