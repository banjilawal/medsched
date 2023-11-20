/**
 *  @Author Banji Lawal
 *
 *  <code>PatientReservations</code> is a singleton of all current <code>PatientReservation</code> events.
 *
 *  Fields
 *  -------
 *  @param reservations <code>ArrayList<PatientReservation></code>
 */

package edu.ics372.abdnn.medsched.core.catalogs.reservations;

import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.entities.*;
import edu.ics372.abdnn.medsched.core.reservations.*;

import java.util.*;
import java.util.function.*;

public enum PatientReservations {
    INSTANCE;

    private final ArrayList<PatientReservation> reservations = new ArrayList<>();


    public ArrayList<PatientReservation> getReservations () {
        return reservations;
    }



    /**
     * Takes the parameters needed to add a <code>PatientReservation</code> to the collection and returns the new instance back.
     * We need the reservation back so it can be removed later.  If the creation fails a null object is returned.
     * @param department <code>Department</code>
     * @param timeslot <code>Timeslot</code>
     * @param patient <code>Patient</code>
     */
    public PatientReservation add (Department department, Timeslot timeslot, Patient patient) {
        boolean result = !conflictExists(department, timeslot,  patient) && Appointments.INSTANCE.search(patient, timeslot) != null;
//        System.out.println("result "  + result);
        PatientReservation reservation = null;
        if (result == false) {
            reservation = new PatientReservation(department, timeslot, patient);
            System.out.println("Adding reservation " + reservation.toString());
            reservations.add(reservations.size(), reservation);
        }
        return reservation;
    }


    /**
     * If the <code>patient</code> already has a reservation at that<code>timeslot</code> return true. Otherwise, false.
     * We need <code>department</code> to prevent duplicates.  Would have liked to only use the timeslot
     * @param department <code>Department</code>
     * @param timeslot <code>Timeslot</code>
     * @param patient <code>Patient</code>
     * @return <code>boolean</code>
     */
    public boolean conflictExists (Department department, Timeslot timeslot, Patient patient) {
        for (PatientReservation reservation : reservations) {
            if (reservation.getPatient().equals(patient)
                && reservation.getDepartment().equals(department)
                && reservation.getTimeSlot().equals(timeslot)) {
                return true;
            }
        }
        return false;
    }




    /**
     * Deletes a <code>PatientReservation</code> from the collection if it exists.
     * @param reservation <code>PatientReservation</code>
     * @return <code>boolean</code>
     */
    public boolean delete(PatientReservation reservation) {
        int index = reservations.indexOf(reservation);
        if (index > -1 )
            return reservations.remove(reservation);
        return true;
    }




    /**
     * Returns a subset of <code>PatientReservation</code> instances that match a predicate
     * @param predicate <code>Predicate<PatientReservation</code>
     * @return <code>ArrayList<PatientReservation></code>
     */
    public ArrayList<PatientReservation> filter (Predicate<PatientReservation> predicate) {
        ArrayList<PatientReservation> matches = new ArrayList<>();
        for (PatientReservation reservation : reservations) {
            if (predicate.test(reservation) && !matches.contains(reservation))
                matches.add(matches.size(), reservation);
        }
        return matches;
    }
} // end class PatientReservations
