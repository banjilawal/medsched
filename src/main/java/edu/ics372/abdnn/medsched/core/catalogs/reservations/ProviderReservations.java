/**
 *  @Author Banji Lawal
 *
 *  <code>ProviderReservations</code> is a singleton of all current <code>ProviderReservation</code> events.
 *
 *  Fields
 *  -------
 *  @param reservations <code>ArrayList<ProviderReservation></code>
 */
package edu.ics372.abdnn.medsched.core.catalogs.reservations;

import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.concretes.*;
import edu.ics372.abdnn.medsched.core.concretes.reservation.*;

import java.util.*;
import java.util.function.*;

public enum ProviderReservations {
    INSTANCE;

    private final ArrayList<ProviderReservation> reservations = new ArrayList<>();


    public ArrayList<ProviderReservation> getReservations () {
        return reservations;
    }

    public void add (ProviderReservation reservation) {
        if (!reservations.contains(reservation))
            reservations.add(reservations.size(), reservation);
    }


    /**
     * Takes the parameters needed to add a <code>ProviderReservation</code> to the collection and returns the new instance back.
     * We need the reservation back so it can be removed later.  If the creation fails a null object is returned.
     * @param department <code>Department</code>
     * @param timeslot <code>Timeslot</code>
     * @param provider <code>Provider</code>
     * @return <code>ProviderReservation</code>
     */
    public ProviderReservation add (Department department, Timeslot timeSlot, Provider provider) {
        boolean result = !conflictExists(department, timeSlot,  provider) && Appointments.INSTANCE.search(provider, timeSlot) != null;
        System.out.println("result "  + result);
        ProviderReservation reservation = null;
        if (result == false) {
            reservation = new ProviderReservation(department, timeSlot, provider);
            System.out.println("Adding reservation " + reservation.toString());
            reservations.add(reservations.size(), reservation);
        }
        return reservation;
    }



//    public boolean add (Department department, Timeslot timeSlot, Provider provider) {
//        boolean result = !conflictExists(department, timeSlot,  provider) && Appointments.INSTANCE.search(provider, timeSlot) != null;
//        if (result == false)
//            return reservations.add(new ProviderReservation(department,timeSlot, provider));
//        return result;
//    }

//    public boolean add (Department department, Timeslot timeSlot, Provider provider) {
//        Predicate<ProviderReservation> predicate = reservation -> {
//            return reservation.getDepartment().equals(department)
//                && reservation.getProvider().equals(provider)
//                && reservation.getTimeSlot().equals(timeSlot);
//        };
//        if (filter(predicate) ==  null && Appointments.INSTANCE.search(provider, timeSlot) == null)
//            return reservations.add(new ProviderReservation(department, timeSlot, provider));
//        return false;
//    }


    /**
     * If the <code>provider</code> already has a reservation at that<code>timeslot</code> return true. Otherwise, false.
     * We need <code>department</code> to prevent duplicates.  Would have liked to only use the timeslot
     * @param department <code>Department</code>
     * @param timeslot <code>Timeslot</code>
     * @param provider <code>Provider</code>
     * @return <code>boolean</code>
     */
    public boolean conflictExists (Department department, Timeslot timeslot, Provider provider) {
        for (ProviderReservation reservation : reservations) {
            if (reservation.getProvider().equals(provider)
                && reservation.getDepartment().equals(department)
                && reservation.getTimeSlot().equals(timeslot)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Deletes a <code>ProviderReservation</code> from the collection if it exists.
     * @param reservation <code>ProviderReservation</code>
     * @return <code>boolean</code>
     */
    public boolean delete(ProviderReservation reservation) {
        int index = reservations.indexOf(reservation);
        if (index > -1 )
            return reservations.remove(reservation);
        return true;
    }


    /**
     * Returns a subset of <code>ProviderReservation</code> instances that match a predicate
     * @param predicate <code>Predicate<ProviderReservation</code>
     * @return <code>ArrayList<ProviderReservation></code>
     */
    public ArrayList<ProviderReservation> filter (Predicate<ProviderReservation> predicate) {
        ArrayList<ProviderReservation> matches = new ArrayList<>();

        for (ProviderReservation reservation : reservations) {
            if (predicate.test(reservation) && !matches.contains(reservation))
                matches.add(matches.size(), reservation);
        }
        return matches;
    }
} // end class ProviderReservations
