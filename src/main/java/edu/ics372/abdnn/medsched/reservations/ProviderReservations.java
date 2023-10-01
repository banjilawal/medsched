package edu.ics372.abdnn.medsched.reservations;

import edu.ics372.abdnn.medsched.containers.*;
import edu.ics372.abdnn.medsched.reserve.*;

import java.util.*;
import java.util.function.*;

public enum ProviderReservations {
    INSTANCE;

    private final Bag<RerservationProvider> reservations = new Bag<RerservationProvider>();


    public Bag<RerservationProvider> getReservations () { return reservations; }


    public RerservationProvider search (int id) { return reservations.search(id); }
    
//
//    public ArrayList<Period>  getReservationPeriods (Provider provider) {
//        ArrayList<Period> matches = new ArrayList<>();
//        Predicate<ProviderReservation> predicate = reservation -> { return reservation.getProviderId() == provider.getId(); };
//
//        for (ProviderReservation reservation :  reservations.getContents()) {
//            Period period = reservation.getPeriod();
//            if (predicate.test(reservation) && !matches.contains(period)) {
//                matches.add(matches.size(), period);
//            }
//        }
//        return matches;
//    }

    public RerservationProvider peek (int id) { return reservations.peek(search(id)); }

    public RerservationProvider pop (int id) { return reservations.pop(reservations.search(id)); }

    public void remove (int id) { remove(reservations.search(id)); }

    public void remove (RerservationProvider reservation) {
        reservations.remove(reservations.indexOf(reservation));
    }


    public int size () { return reservations.size(); }

    
    public void add (RerservationProvider reservation) { reservations.add(reservation);}

    
    public Iterator<RerservationProvider> iterator () { return reservations.iterator(); }


    public Iterator<RerservationProvider> filter (Predicate<RerservationProvider> predicate) { return reservations.filter(predicate); }

    public String toString () { return reservations.toString(); }
} // end class ExamProviderReservations
