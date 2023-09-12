package edu.ics372.abdnn.medsched.abstracts;

import edu.ics372.abdnn.medsched.entities.Period;

import java.util.Objects;

public abstract class Meeting extends NamedEntity {
    private OwnerLock hostLock;
    private Location location;
    private Period period;
    private Person host;


    public Meeting (int id, String name, Person host, Location location, Period period) {
        super(id, name);
        this.host = host;
        this.location = location;
        this.period = period;
        this.hostLock = new OwnerLock(host);
    } // close constructor

    public Person getHost () {
        return host;
    }

    public Location getLocation () {
        return location;
    }

    public Period getPeriod () { return period; }
    public OwnerLock getHostLock () { return hostLock; }

    public void setHost (Person host) {
        this.host = host;
        setHostLock();
    }

    public void setLocation (Location location) {
        this.location = location;
    }
    public void setPeriod (Period period) { this.period = period; }
    public void setHostLock () { this.hostLock = new OwnerLock(host); }
    public void removeHostLock () { this.hostLock = null; }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Meeting meeting) {
            return super.equals(meeting)
                && host.equals(meeting.getHost())
                && period.equals((meeting.getPeriod()))
                && location.equals(meeting.getLocation())
                && hostLock.equals(meeting.getHostLock());
        }
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), host, location, period);
    } // close hashCode

    @Override
    public String toString () {
        return super.toString()
            + " host:" + host.getFirstname() + " " + host.getLastname()
            + " "  + period.toString();
    } // close toString
} // end class Meeting
