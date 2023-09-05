package edu.ics372.abdnn.medsched.abstracts;

import edu.ics372.abdnn.medsched.entities.Duration;
import edu.ics372.abdnn.medsched.entities.DurationLock;
import edu.ics372.abdnn.medsched.enums.Availabilty;

import java.util.Date;

public abstract class Resource extends NamedEntity {

    private Availabilty availabilty;
    private DurationLock durationLock;

    public Resource (int id, String name) {
        super(id, name);
        this.availabilty = Availabilty.OPEN;
        this.durationLock = null;
    }

    public Availabilty getAvailabilty () { return availabilty; }
    public DurationLock getDurationLock () { return durationLock; }

    public void setDurationLock (Date date, Duration duration) {
        if (durationLock == null) {
            this.durationLock = new DurationLock(date, duration);
        }
    } //

    public void book (Date date, Duration duration) {
        setDurationLock(date,duration);
        if (durationLock != null && durationLock.getDuration().sameTimes(duration) && availabilty.equals(Availabilty.OPEN)) {
            this.availabilty = Availabilty.CLOSED;
    }
} // end class Resource
