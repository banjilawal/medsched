package edu.ics372.abdnn.medsched.core.abstracts;

import edu.ics372.abdnn.medsched.core.entities.Period;

import java.util.Objects;

public abstract class Meeting extends Entity {
    private Location location;
    private Period period;
    private Staff host;


    public Meeting (int id, Staff staffMember, Location location, Period period) {
        super(id);
        this.host = staff;
        this.location = location;
        this.period = period;
    } // close constructor

    public Staff getHost () { return host; }


    public Location getLocation () {
        return location;
    }

    public Period getPeriod () { return period; }

    public void setStaff (Staff host) { this.host = host; }

    public void setLocation (Location location) {
        this.location = location;
    }
    public void setPeriod (Period period) { this.period = period; }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Meeting meeting) {
            return super.equals(meeting)
                && host == meeting.getHost()
                && period.equals((meeting.getPeriod()))
                && location.equals(meeting.getLocation());
        }
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), host, location, period);
    } // close hashCode

//    @Override
//    public String toString () {
//        return super.toString()
//            + " host:" + getHost().toString()
//            + " "  + period.toString();
//    } // close toString
} // end class Meeting
