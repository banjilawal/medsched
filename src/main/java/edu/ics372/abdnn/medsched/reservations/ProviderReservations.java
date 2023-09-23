package edu.ics372.abdnn.medsched.reservations;

import edu.ics372.abdnn.medsched.containers.*;
import edu.ics372.abdnn.medsched.reserve.*;

import java.util.*;
import java.util.function.*;

public enum ProviderReservations {
    INSTANCE;

    private final Bag<ProviderReservation> reservations = new Bag<ProviderReservation>();


    public Bag<ProviderReservation> getReservations () { return reservations; }


    public ProviderReservation search (int id) { return reservations.search(id); }
    
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

    public ProviderReservation peek (int id) { return reservations.peek(search(id)); }

    public ProviderReservation pop (int id) { return reservations.pop(reservations.search(id)); }

    public void remove (int id) { remove(reservations.search(id)); }

    public void remove (ProviderReservation reservation) {
        reservations.remove(reservations.indexOf(reservation));
    }


    public int size () { return reservations.size(); }

    
    public void add (ProviderReservation reservation) { reservations.add(reservation);}

    
    public Iterator<ProviderReservation> iterator () { return reservations.iterator(); }


    public Iterator<ProviderReservation> filter (Predicate<ProviderReservation> predicate) { return reservations.filter(predicate); }

    public String toString () { return reservations.toString(); }
} // end class ExamProviderReservations
