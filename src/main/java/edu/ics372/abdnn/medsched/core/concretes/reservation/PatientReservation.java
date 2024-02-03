package edu.ics372.abdnn.medsched.core.concretes.reservation;

import edu.ics372.abdnn.medsched.core.concretes.*;

import java.util.*;

public class PatientReservation extends Reservation {
    private final Patient patient;

    public PatientReservation (Department department, Timeslot timeSlot, Patient patient) {
        super(department, timeSlot);
        this.patient = patient;
    }


    public Patient getPatient() { return patient; }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof PatientReservation reservation) {
            return super.equals(reservation) && patient.equals(reservation.getPatient());
        }
        return false;
    }


    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), patient.hashCode());
    }


    @Override
    public String toString () {
        return super.toString() + " patient:" + patient.getFirstname() + " " + patient.getLastname();
    }
} // end class ExamRoomReservation
