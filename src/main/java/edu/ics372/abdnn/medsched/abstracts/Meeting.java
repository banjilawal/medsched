package edu.ics372.abdnn.medsched.abstracts;

import edu.ics372.abdnn.medsched.entities.Duration;
import edu.ics372.abdnn.medsched.entities.ScheduleDate;

import java.util.Objects;

public abstract class Meeting extends NamedEntity {
    private Person host;
    private Location location;
    private ScheduleDate scheduleDate;
    private Duration duration;
    private OwnerLock hostLock;


    public Meeting (int id, String name, Person host, Location location, ScheduleDate scheduleDate, Duration duration) {
        super(id, name);
        this.host = host;
        this.location = location;
        this.scheduleDate = scheduleDate;
        this.duration = duration;
        this.hostLock = new OwnerLock(host);
    } // close constructor

    public Person getHost () {
        return host;
    }

    public Location getLocation () {
        return location;
    }

    public ScheduleDate getScheduleDate() { return scheduleDate; }

    public Duration getDuration () { return duration; }
    public OwnerLock getHostLock () { return hostLock; }

    public void setHost (Person host) {
        this.host = host;
        setHostLock();
    }

    public void setLocation (Location location) {
        this.location = location;
    }

    public void setScheduleDate (ScheduleDate scheduleDate) { this.scheduleDate = scheduleDate; }

    public void setDuration (Duration duration) { this.duration = duration; }
    public void setHostLock () { this.hostLock = new OwnerLock(host); }
    public void removeHostLock () { this.hostLock = null; }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Meeting meeting) {
            return super.equals(meeting)
                && host.equals(meeting.getHost())
                && scheduleDate.equals(meeting.getScheduleDate())
                && location.equals(meeting.getLocation());
        }
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), host, location, scheduleDate);
    } // close hashCode

    @Override
    public String toString () {
        return super.toString()
            + " host:" + host.getFirstname() + " " + host.getLastname()
            + " "  + scheduleDate.toString();
    } // close toString

} // end class Meeting
