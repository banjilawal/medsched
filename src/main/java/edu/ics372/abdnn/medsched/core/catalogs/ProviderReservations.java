package edu.ics372.abdnn.medsched.core.catalogs;

import edu.ics372.abdnn.medsched.core.entities.*;
import edu.ics372.abdnn.medsched.core.reservations.*;

import java.util.*;
import java.util.function.*;

public enum ProviderReservations {
    INSTANCE;

    private final ArrayList<ProviderReservation> reservations = new ArrayList<>();


    public ArrayList<ProviderReservation> getReservations () { return reservations; }

    public boolean add (ProviderReservation reservation) {
        if (!reservations.contains(reservation))
            return reservations.add(reservation);
        return true;
    }

    public boolean add (Department department, Period period, Provider provider) {
        Predicate<ProviderReservation> predicate = reservation -> {
            return reservation.getDepartment().equals(department)
                && reservation.getProvider().equals(provider)
                && reservation.getPeriod().equals(period);
        };

        if (reservations.search(predicate) ==  null && Appointments.INSTANCE.search(provider, period) == null)
            return reservations.add(new RoomReservation(department, period, examRoom));
//            return reservations.add(new RoomReservation(SerialNumberGenerator.INSTANCE.examRoomId(), period, examRoom));
        return false;
    }

    

    public void delete (ProviderReservation reservation) {
        reservations.remove(reservations.indexOf(reservation));
    }



} // end class ExamProviderReservations
