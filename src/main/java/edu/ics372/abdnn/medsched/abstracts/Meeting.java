package edu.ics372.abdnn.medsched.abstracts;

import edu.ics372.abdnn.medsched.entities.ScheduleDate;

import java.util.Objects;

public abstract class Meeting extends Resource {

    private Person host;
    private Location location;
    private ScheduleDate scheduleDate;

    public Meeting (int id, String name, Person host, Location location, ScheduleDate scheduleDate) {
        super(id, name);
        this.host = host;
        this.location = location;
        this.scheduleDate = scheduleDate;
    } // close constructor

    public Person getHost () {
        return host;
    }

    public Location getLocation () {
        return location;
    }

    public ScheduleDate getDateTimeslot () { return scheduleDate; }

    public void setHost (Person host) {
        this.host = host;
    }

    public void setLocation (Location location) {
        this.location = location;
    }

    public void setDateTimeslot (ScheduleDate scheduleDate) { this.scheduleDate = scheduleDate; }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Meeting meeting) {
            return super.equals(meeting)
                && host.equals(meeting.getHost())
                && scheduleDate.equals(meeting.getDateTimeslot())
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
