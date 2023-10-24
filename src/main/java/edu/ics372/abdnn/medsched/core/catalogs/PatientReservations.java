package edu.ics372.abdnn.medsched.core.catalogs;

import edu.ics372.abdnn.medsched.core.entities.*;
import edu.ics372.abdnn.medsched.core.reservations.*;

import java.util.*;
import java.util.function.*;

public enum PatientReservations {
    INSTANCE;

    private final ArrayList<PatientReservation> reservations = new ArrayList<>()


    public ArrayList<PatientReservation> getReservations () { return reservations; }


    public boolean add (PatientReservation reservation) {
        if (!reservations.contains(reservation))
            return reservations.add(reservation);
        return true;
    }

    public boolean add (Department department, Period period, Patient patient) {
        Predicate<PatientReservation> predicate = reservation -> {
            return reservation.getDepartment().equals(department)
                && reservation.getPatient().equals(patient)
                && reservation.getPeriod().equals(period);
        };

        if (reservations.search(predicate) ==  null && Appointments.INSTANCE.search(patient, period)== null)
            return reservations.add(new RoomReservation(department, period, examRoom));
//            return reservations.add(new RoomReservation(SerialNumberGenerator.INSTANCE.examRoomId(), period, examRoom));
        return false;
    }



    public void remove (PatientReservation reservation) {
        reservations.remove(reservations.indexOf(reservation));
    }

} // end class ExamPatientReservations
