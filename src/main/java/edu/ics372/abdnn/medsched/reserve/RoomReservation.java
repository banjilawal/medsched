package edu.ics372.abdnn.medsched.reserve;

import edu.ics372.abdnn.medsched.entities.*;
import edu.ics372.abdnn.medsched.enums.*;

import java.util.*;

public class RoomReservation extends Rerservation {

    private final ExamRoom examRoom;

    public RoomReservation (Department department,  Period period, ExamRoom examRoom) { // (int id, Department department,  Period period, ExamRoom examRoom) {
//        super(id, department, period);
        super(department, period);
        this.examRoom = examRoom;
    }


    public ExamRoom getExamRoom () {
        return examRoom;
    }


    public boolean cancel () {
        setStatus(ReservationStatus.CANCELLED);
        return getStatus().equals(ReservationStatus.CANCELLED);
    }


    public boolean expire () {
        setStatus(ReservationStatus.EXPIRED);
        return getStatus().equals(ReservationStatus.EXPIRED);
    }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof RoomReservation reservation) {
            return super.equals(roomReservation) && examRoom.equals(reservation.getExamRoom());
        }
        return false;
    }


    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), examRoom);
    }

    @Override
    public String toString () {
        return super.toString() + " room:" + getExamRoom().getName();
    }
} // end class ExamRoomReservation
