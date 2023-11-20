package edu.ics372.abdnn.medsched.core.reservations;

import edu.ics372.abdnn.medsched.core.entities.*;
import edu.ics372.abdnn.medsched.core.enums.*;

import java.util.*;

public class RoomReservation extends Reservation {

    private final ExamRoom examRoom;

    public RoomReservation (Department department, Timeslot timeSlot, ExamRoom examRoom) {
        super(department, timeSlot);
        this.examRoom = examRoom;
    }


    public ExamRoom getExamRoom () {
        return examRoom;
    }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof RoomReservation reservation) {
            return super.equals(reservation) && examRoom.equals(reservation.getExamRoom());
        }
        return false;
    }


    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), examRoom);
    }

    @Override
    public String toString () {
        return super.toString() + " examRoom:" + examRoom.getName();
    }
} // end class ExamRoomReservation
