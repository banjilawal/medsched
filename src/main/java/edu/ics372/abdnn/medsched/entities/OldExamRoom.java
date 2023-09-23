package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.*;
import edu.ics372.abdnn.medsched.enums.*;
import edu.ics372.abdnn.medsched.global.*;
import edu.ics372.abdnn.medsched.interfaces.*;

import java.util.*;

public class OldExamRoom extends Room implements Resource, Response  {
    private Status status;
    private PeriodLock periodLock;

    public OldExamRoom (int id, String name) {
        super(id, name, Constant.EXAM_ROOM_CAPACITY);
        this.status = Status.OPEN;
        this.periodLock = null;
    } //

    public Status getAvailability () {  return status; }

    public PeriodLock getPeriodLock () { return periodLock; }

    public boolean book (Period period, Provider provider, Patient patient) {
        if (periodLock != null && periodLock.match(period, provider, patient)) return true;
        if (periodLock == null) {
            periodLock = new PeriodLock(period, provider, patient);
            this.status = Status.BOOKED;
            return true;
        }
        return false;
    }

    public boolean cancel (Period period, Provider provider, Patient patient) {
        if (periodLock == null) return true;
        if (periodLock.match(period, provider, patient)) {
            periodLock = null;
            this.status = Status.OPEN;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof OldExamRoom examRoom)
            return super.equals(examRoom) && status.equals(examRoom.getAvailability());
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), status);
    }

    @Override
    public String toString () { return super.toString() + " " + status.toString(); }
} // end class ExamRoom
