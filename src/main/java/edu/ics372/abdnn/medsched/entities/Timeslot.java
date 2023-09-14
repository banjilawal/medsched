package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.enums.Availability;
import edu.ics372.abdnn.medsched.interfaces.Identified;
import edu.ics372.abdnn.medsched.interfaces.Named;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Timeslot extends Duration implements Identified, Named {
    private final int id;
    private final String name;
    private Availability availability;
//    private PeriodLock periodLock;


    public Timeslot (int id, String name, LocalTime startTime, LocalTime endTime) {
        super(startTime, endTime);
        this.id = id;
        this.name = name;
//        this.periodLock = null;
        this.availability = Availability.OPEN;
    } //


    @Override
    public int getId () { return id; }

    @Override
    public String getName () { return name; }


    public Availability getAvailability () { return availability; }

//    public PeriodLock getPeriodLock () { return periodLock; }

//    public boolean book (LocalDate date, Provider provider, Patient patient) {
//        Period period = new Period(date, this );
//        if (periodLock != null && periodLock.match(period, provider, patient)) return true;
//        if (periodLock == null) {
//            periodLock = new PeriodLock(new Period(date, this), provider, patient);
//            this.availability = Availability.BOOKED;
//            return true;
//        }
//        return false;
//    }

//    public boolean cancel (LocalDate date, Provider provider, Patient patient) {
//        if (periodLock == null) return true;
//        if (periodLock != null && periodLock.match(new Period(date, this), provider, patient)) {
//            periodLock = null;
//            this.availability = Availability.OPEN;
//            return true;
//        }
//        return false;
//    }

//    public void setAvailabilty (Availability availability) { this.availability = availability; }


    @Override
    public void setId (int id) {}

    @Override
    public void setName (String name) { }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Timeslot timeslot) {
            return super.equals(timeslot)
                && id == timeslot.getId()
                && availability == timeslot.getAvailability()
                && name.equalsIgnoreCase(timeslot.getName());
        }
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), id, name, availability);
    }

    @Override
    public String toString () {
        return super.toString() + " id:" + id + " name:" + name + " availabe:" + availability.toString();
    }
} // end class Timeslot
