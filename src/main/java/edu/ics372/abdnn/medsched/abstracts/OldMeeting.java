package edu.ics372.abdnn.medsched.abstracts;

import edu.ics372.abdnn.medsched.entities.*;

import java.util.*;

public abstract class OldMeeting extends Entity {
    private Location location;
    private Period period;
    private int hostId;


    public OldMeeting (int id, Person host, Location location, Period period) {
        super(id);
        this.hostId = host.getId();
        this.location = location;
        this.period = period;
    } // close constructor

    public int getHostId() { return hostId; }


    public Location getLocation () {
        return location;
    }

    public Period getPeriod () { return period; }

    public void setHostId (int hostId) { this.hostId = hostId; }

    public void setLocation (Location location) {
        this.location = location;
    }
    public void setPeriod (Period period) { this.period = period; }
//    public void setHostLock () { this.hostLock = new OwnerLock(host); }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof OldMeeting meeting) {
            return super.equals(meeting)
                && hostId == meeting.getHostId()
                && period.equals((meeting.getPeriod()))
                && location.equals(meeting.getLocation());
        }
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), hostId, location, period);
    } // close hashCode

//    @Override
//    public String toString () {
//        return super.toString()
//            + " host:" + getHost().toString()
//            + " "  + period.toString();
//    } // close toString
} // end class Meeting
