package edu.ics372.abdnn.medsched.reservations;

import edu.ics372.abdnn.medsched.containers.*;
import edu.ics372.abdnn.medsched.reserve.*;

import java.util.*;
import java.util.function.*;

public enum PatientReservations {
    INSTANCE;

    private final Bag<PatientReservation> reservations = new Bag<PatientReservation>();


    public Bag<PatientReservation> getReservations () { return reservations; }


    public PatientReservation search (int id) { return reservations.search(id); }
    

//    public ArrayList<Period>  getReservationPeriods (Patient patient) {
//        ArrayList<Period> matches = new ArrayList<>();
//        Predicate<PatientReservation> predicate = reservation -> { return reservation.getPatientId() == patient.getId(); };
//
//        for (PatientReservation reservation :  reservations.getContents()) {
//            Period period = reservation.getPeriod();
//            if (predicate.test(reservation) && !matches.contains(period)) {
//                matches.add(matches.size(), period);
//            }
//        }
//        return matches;
//    }

    public PatientReservation peek (int id) { return reservations.peek(search(id)); }

    public PatientReservation pop (int id) { return reservations.pop(reservations.search(id)); }

    public void remove (int id) { remove(reservations.search(id)); }

    public void remove (PatientReservation reservation) {
        reservations.remove(reservations.indexOf(reservation));
    }


    public int size () { return reservations.size(); }

    
    public void add (PatientReservation reservation) { reservations.add(reservation);}

    
    public Iterator<PatientReservation> iterator () { return reservations.iterator(); }


    public Iterator<PatientReservation> filter (Predicate<PatientReservation> predicate) { return reservations.filter(predicate); }

    public String toString () { return reservations.toString(); }
} // end class ExamPatientReservations
