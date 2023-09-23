package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.enums.*;
import edu.ics372.abdnn.medsched.interfaces.Identified;
import edu.ics372.abdnn.medsched.interfaces.Named;

import java.time.LocalTime;
import java.util.Objects;

public class Timeslot extends Interval implements Identified, Named {
    private final int id;
    private final String name;
    private TimeSlotStatus status;
//    private PeriodLock periodLock;


    public Timeslot (int id, String name, LocalTime startTime, LocalTime endTime) {
        super(startTime, endTime);
        this.id = id;
        this.name = name;
        this.status = TimeSlotStatus.AVAILABLE;
    } //


    @Override
    public int getId () { return id; }

    @Override
    public String getName () { return name; }

    public TimeSlotStatus getStatus () { return status; }

    public void  setStatus (TimeSlotStatus status) { this.status = status; }

//    public PeriodLock getPeriodLock () { return periodLock; }

//    public boolean book (LocalDate date, Provider provider, Patient patient) {
//        Period period = new Period(date, this );
//        if (periodLock != null && periodLock.match(period, provider, patient)) return true;
//        if (periodLock == null) {
//            periodLock = new PeriodLock(new Period(date, this), provider, patient);
//            this.state = State.BOOKED;
//            return true;
//        }
//        return false;
//    }

//    public boolean cancel (LocalDate date, Provider provider, Patient patient) {
//        if (periodLock == null) return true;
//        if (periodLock != null && periodLock.match(new Period(date, this), provider, patient)) {
//            periodLock = null;
//            this.state = State.OPEN;
//            return true;
//        }
//        return false;
//    }

//    public void setAvailabilty (State state) { this.state = state; }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Timeslot timeslot) {
            return super.equals(timeslot)
                && id == timeslot.getId()
                && status.equals(timeslot.getStatus())
                && name.equalsIgnoreCase(timeslot.getName());
        }
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), id, name, status);
    }

    @Override
    public String toString () {
        return super.toString() + " id:" + id + " name:" + name + " availabe:" + status.toString();
    }
} // end class Timeslot
