package edu.ics372.abdnn.medsched.reservations;

import edu.ics372.abdnn.medsched.catalogs.*;
import edu.ics372.abdnn.medsched.entities.*;
import edu.ics372.abdnn.medsched.entities.Period;
import edu.ics372.abdnn.medsched.enums.*;
import edu.ics372.abdnn.medsched.reserve.*;

import java.time.*;
import java.util.*;
import java.util.function.*;

public enum RoomReservations  {
    INSTANCE;

    private ArrayList<RoomReservation> reservations = new ArrayList<>();


    public boolean reservationExists (Department department, Period period, ExamRoom examRoom) {
        return department.isPeriodBooked(period) && examRoom.inUse();
    }


    public boolean add (Department department, Period period, ExamRoom examRoom) {
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


    public boolean delete (RoomReservation reservation) {
        if (reservations.contains(reservation))
            return reservations.remove(reservation);
        return true;
    }


//    public boolean cancelReservation (RoomReservation target) {
//        for (RoomReservation reservation : reservations) {
//            if (reservation.equals(target))
//                return reservation.cancel();
//        }
//        return true;
//    }
//
//
//    public boolean expireReservation (RoomReservation target) {
//        for (RoomReservation reservation : reservations) {
//            if (reservation.equals(target))
//                return reservation.expire();
//        }
//        return true;
//    }


    public RoomReservation search (Appointment appointment) {
        for (RoomReservation reservation : reservations) {
            if (reservation.getStatus().equals(ReservationStatus.ACTIVE)
                && appointment.getPeriod().equals(reservation.getPeriod())
                && appointment.getExamRoom().equals(reservation.getExamRoom())) {
                return reservation;
            }
        }
        return null;
    }


    public RoomReservation search (ExamRoom examRoom, Period period) {
        for (RoomReservation reservation : reservations) {
            if (reservation.getStatus().equals(ReservationStatus.ACTIVE)
                && reservation.getExamRoom().equals(examRoom)
                && reservation.getPeriod().equals(period)) {
                return reservation;
            }
        }
        return null;
    }


    public RoomReservation search (int id) {
        for (RoomReservation reservation : reservations) {
            if (reservation.getId() == id)
                return reservation;
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


    public ArrayList<Integer>  getRoomIds (LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
        LocalDate dateA = startDate.minusDays(1);
        LocalDate dateB = endDate.plusDays(1);

        LocalTime timeA = startTime.minusMinutes(1);
        LocalTime timeB = endTime.plusMinutes(1);

        ArrayList<Integer> matches = new ArrayList<Integer>();
        Predicate<RoomReservation> predicate = reservation -> {
            LocalDate date = reservation.getPeriod().getDate();
            LocalTime start = reservation.getPeriod().getStartTime();
            LocalTime end = reservation.getPeriod().getEndTime();

            return date.isAfter(dateA) && date.isBefore(dateB)
                && start.isAfter(timeA) && end.isBefore(timeB);
        };
        for (RoomReservation reservation :  reservations.getContents()) {
            Integer id = reservation.getId();
            if (predicate.test(reservation) && !matches.contains(id)) {
                matches.add(matches.size(), id);
            }
        }
        return matches;
    }




    public Iterator<RoomReservation> iterator () { return reservations.iterator(); }




    public Iterator<RoomReservation> filter (Predicate<RoomReservation> predicate) {
        ArrayList<RoomReservation> matches = new ArrayList<>();
        for (RoomReservation reservation : reservations) {
            if (predicate.test(reservation) && !matches.contains(reservation))
                matches.add(matches.size(), reservation);
        }
        return matches.iterator();
    }
} // end class ExamRoomReservations
