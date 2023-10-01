package edu.ics372.abdnn.medsched.reservations;

import edu.ics372.abdnn.medsched.containers.*;
import edu.ics372.abdnn.medsched.reserve.*;

import java.util.*;
import java.util.function.*;

public enum PatientReservations {
    INSTANCE;

    private final Bag<RerservationPatient> reservations = new Bag<RerservationPatient>();


    public Bag<RerservationPatient> getReservations () { return reservations; }


    public RerservationPatient search (int id) { return reservations.search(id); }
    

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

    public RerservationPatient peek (int id) { return reservations.peek(search(id)); }

    public RerservationPatient pop (int id) { return reservations.pop(reservations.search(id)); }

    public void remove (int id) { remove(reservations.search(id)); }

    public void remove (RerservationPatient reservation) {
        reservations.remove(reservations.indexOf(reservation));
    }


    public int size () { return reservations.size(); }

    
    public void add (RerservationPatient reservation) { reservations.add(reservation);}

    
    public Iterator<RerservationPatient> iterator () { return reservations.iterator(); }


    public Iterator<RerservationPatient> filter (Predicate<RerservationPatient> predicate) { return reservations.filter(predicate); }

    public String toString () { return reservations.toString(); }
} // end class ExamPatientReservations
