package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.Room;
import edu.ics372.abdnn.medsched.enums.Availability;
import edu.ics372.abdnn.medsched.global.Constant;

import java.time.LocalDate;
import java.util.Objects;

public class ExamRoom extends Room {
    private Availability availability;
    private PeriodLock periodLock;

    public ExamRoom (int id, String name) {
        super(id, name, Constant.EXAM_ROOM_CAPACITY);
        this.availability = Availability.OPEN;
        this.periodLock = null;
    } //

    public Availability getAvailability () {  return availability; }

    public PeriodLock getPeriodLock () { return periodLock; }

    public boolean book (Period period, Provider provider, Patient patient) {
        if (periodLock != null && periodLock.match(period, provider, patient)) return true;
        if (periodLock == null) {
            periodLock = new PeriodLock(period, provider, patient);
            this.availability = Availability.BOOKED;
            return true;
        }
        return false;
    }

    public boolean cancel (Period period, Provider provider, Patient patient) {
        if (periodLock == null) return true;
        if (periodLock.match(period, provider, patient)) {
            periodLock = null;
            this.availability = Availability.OPEN;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof ExamRoom examRoom)
            return super.equals(examRoom) && availability.equals(examRoom.getAvailability());
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), availability);
    }

    @Override
    public String toString () { return super.toString() + " " + availability.toString(); }
} // end class ExamRoom
