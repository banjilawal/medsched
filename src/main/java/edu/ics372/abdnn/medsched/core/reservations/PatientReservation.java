package edu.ics372.abdnn.medsched.core.reservations;

import edu.ics372.abdnn.medsched.core.entities.*;

import java.util.*;

public class PatientReservation extends Rerservation {
    private final Patient patient;

    public PatientReservation (Department department, Period period, Patient patient) {
        super(department, period);
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
        return Objects.hash(super.hashCode(), patientId);
    }


    @Override
    public String toString () {
        return super.toString()
            + " patient:" + patientId
            + " " + getPatient().getFirstname()
            + " " + getPatient().getLastname();
    }
} // end class ExamRoomReservation
