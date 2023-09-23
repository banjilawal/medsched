package edu.ics372.abdnn.medsched.reserve;

import edu.ics372.abdnn.medsched.entities.ExamRoom;
import edu.ics372.abdnn.medsched.entities.Period;
import edu.ics372.abdnn.medsched.catalogs.ExamRooms;

import java.util.*;

public class RoomReservation extends Reservation {

    private final int examRoomId;

    public RoomReservation (int id, Period period, ExamRoom examRoom) {
        super(id, period);
        this.examRoomId = examRoom.getId();
    }


    public int getExamRoomId () {
        return examRoomId;
    }


    public ExamRoom getExamRoom () {
        return ExamRooms.INSTANCE.search(examRoomId);
    }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof RoomReservation roomReservation) {
            return super.equals(roomReservation) && examRoomId == roomReservation.getExamRoomId();
        }
        return false;
    }


    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), examRoomId);
    }

    @Override
    public String toString () {
        return super.toString() + " room:" + getExamRoom().getName();
    }
} // end class ExamRoomReservation
