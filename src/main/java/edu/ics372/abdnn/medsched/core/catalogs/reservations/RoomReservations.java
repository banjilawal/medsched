/**
 *  @Author Banji Lawal
 *
 *  <code>RoomReservations</code> is the collection of current room reservations.
 *
 *
 *  Fields
 *  -------
 * @param appointments ArrayList should only be accessed with methods that either return an <code>ArrayList</code> or
 *      <code>Iterator</code>
 */

package edu.ics372.abdnn.medsched.core.catalogs.reservations;

import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.entity.*;
import edu.ics372.abdnn.medsched.core.entity.Timeslot;
import edu.ics372.abdnn.medsched.core.reservation.*;

import java.util.*;
import java.util.function.*;

public enum RoomReservations  {
    INSTANCE;

    private ArrayList<RoomReservation> reservations = new ArrayList<RoomReservation>();

    public ArrayList<RoomReservation> getReservations () {
        return reservations;
    }



    /**
     * Takes the parameters needed to add a <code>ExamReservation</code> to the collection and returns the new instance back.
     * We need the reservation back so it can be removed later.  If the creation fails a null object is returned.
     * @param department <code>Department</code>
     * @param timeslot <code>Timeslot</code>
     * @param examRoom <code>Examroom</code>
     * @return <code>RoomReservation</code>
     */
    public RoomReservation add (Department department, Timeslot timeSlot, ExamRoom examRoom) {
        boolean result = !conflictExists(department, timeSlot,  examRoom) && Appointments.INSTANCE.search(examRoom, timeSlot) != null;
        System.out.println("result "  + result);
        RoomReservation reservation = null;
        if (result == false) {
            reservation = new RoomReservation(department, timeSlot, examRoom);
            System.out.println("Adding reservation " + reservation.toString());
            reservations.add(reservations.size(), reservation);
        }
        return reservation;
    }


    /**
     * If the <code>examRoom/code> already has a reservation at that<code>timeslot</code> return true. Otherwise, false.
     * We need <code>department</code> to prevent duplicates.  Would have liked to only use the timeslot
     * @param department <code>Department</code>
     * @param timeslot <code>Timeslot</code>
     * @param examRoomr <code>ExamRoom</code>
     * @return <code>boolean</code>
     */
    public boolean conflictExists (Department department, Timeslot timeslot, ExamRoom examRoom) {
        for (RoomReservation reservation : reservations) {
            if (reservation.getExamRoom().equals(examRoom)
                && reservation.getDepartment().equals(department)
                && reservation.getTimeSlot().equals(timeslot)) {
                return true;
            }
        }
        return false;
    }



    /**
     * Deletes a <code>Roomeservation</code> from the collection if it exists.
     * @param reservation <code>Roomeservation</code>
     * @return <code>boolean</code>
     */
    public boolean delete (RoomReservation reservation) {
        if (reservations.contains(reservation))
            return reservations.remove(reservation);
        return true;
    }



    public RoomReservation search (ExamRoom examRoom, Timeslot timeSlot) {
        for (RoomReservation reservation : reservations) {
            if (reservation.getExamRoom().equals(examRoom) && reservation.getTimeSlot().equals(timeSlot)) {
                return reservation;
            }
        }
        return null;
    }




    /**
     * Returns a subset of <code>RoomReservation</code> instances that match a predicate
     * @param predicate <code>Predicate<RoomReservation</code>
     * @return <code>ArrayList<RoomReservation></code>
     */
    public ArrayList<RoomReservation> filter (Predicate<RoomReservation> predicate) {
        ArrayList<RoomReservation> matches = new ArrayList<>();
        for (RoomReservation reservation : reservations) {
            if (predicate.test(reservation) && !matches.contains(reservation))
                matches.add(matches.size(), reservation);
        }
        return matches;
    }
} // end class ExamRoomReservations
