package edu.ics372.abdnn.medsched.reservations;

import edu.ics372.abdnn.medsched.containers.*;
import edu.ics372.abdnn.medsched.reserve.*;

import java.time.*;
import java.util.*;
import java.util.function.*;

public enum RoomReservations  {
    INSTANCE;

    private final Bag<RoomReservation> reservations = new Bag<RoomReservation>();


    public Bag<RoomReservation> getReservations () { return reservations; }


    public RoomReservation search (int id) { return reservations.search(id); }


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

    public RoomReservation peek (int id) { return reservations.peek(search(id)); }

    public RoomReservation pop (int id) { return reservations.pop(reservations.search(id)); }

    public void remove (int id) { remove(reservations.search(id)); }

    public void remove (RoomReservation reservation) {
        reservations.remove(reservations.indexOf(reservation));
    }


    public int size () { return reservations.size(); }


    public void add (RoomReservation reservation) { reservations.add(reservation);}


    public Iterator<RoomReservation> iterator () { return reservations.iterator(); }


    public Iterator<RoomReservation> filter (Predicate<RoomReservation> predicate) { return reservations.filter(predicate); }

    public String toString () { return reservations.toString(); }
} // end class ExamRoomReservations
