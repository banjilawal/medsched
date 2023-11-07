package edu.ics372.abdnn.medsched.core.catalogs;

import edu.ics372.abdnn.medsched.core.entities.*;
import edu.ics372.abdnn.medsched.core.entities.Period;
import edu.ics372.abdnn.medsched.core.enums.*;
import edu.ics372.abdnn.medsched.core.reservations.*;

import java.util.*;
import java.util.function.*;

public enum RoomReservations  {
    INSTANCE;

    private ArrayList<RoomReservation> reservations = new ArrayList<>();

    public ArrayList<RoomReservation> getReservations () {
        return reservations;
    }


    public boolean reservationExists (Department department, Period period, Examroom examRoom) {
        return department.isPeriodBooked(period) && examRoom.inUse();
    }


    public boolean add (RoomReservation reservation) {
        if (!reservations.contains(reservation))
            return reservations.add(reservation);
        return true;
    }


    public boolean add (Department department, Period period, Examroom examRoom) {
        Predicate<RoomReservation> predicate = reservation -> {
            return reservation.getDepartment().equals(department)
                && reservation.getExamRoom().equals(examRoom)
                && reservation.getPeriod().equals(period);
        };

        if (reservations.search(predicate) ==  null && Appointments.INSTANCE.search(examRoom, period) == null)
            return reservations.add(new RoomReservation(department, period, examRoom));
//            return reservations.add(new RoomReservation(SerialNumberGenerator.INSTANCE.examRoomId(), period, examRoom));
        return false;
    }



    public RoomReservation search (Examroom examRoom, Period period) {
        for (RoomReservation reservation : reservations) {
            if (reservation.getStatus().equals(ReservationStatus.ACTIVE)
                && reservation.getExamRoom().equals(examRoom)
                && reservation.getPeriod().equals(period)) {
                return reservation;
            }
        }
        return null;
    }




    public ArrayList<RoomReservation> search (Predicate<RoomReservation> predicate) {
        ArrayList<RoomReservation> matches = new ArrayList<>();
        for (RoomReservation reservation : reservations) {
            if (predicate.test(reservation) && !matches.contains(reservation))
                matches.add(matches.size(), reservation);
        }
        return matches;
    }


    public Iterator<RoomReservation> filter (Predicate<RoomReservation> predicate) {
        ArrayList<RoomReservation> matches = new ArrayList<>();
        for (RoomReservation reservation : reservations) {
            if (predicate.test(reservation) && !matches.contains(reservation))
                matches.add(matches.size(), reservation);
        }
        return matches.iterator();
    }
} // end class ExamRoomReservations
