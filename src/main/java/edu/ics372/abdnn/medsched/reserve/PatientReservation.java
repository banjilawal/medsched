package edu.ics372.abdnn.medsched.reserve;

import edu.ics372.abdnn.medsched.entities.Patient;
import edu.ics372.abdnn.medsched.entities.Period;
import edu.ics372.abdnn.medsched.catalogs.Patients;

import java.util.*;

public class PatientReservation extends Reservation {
    private final int patientId;

    public PatientReservation (int id, Period period, Patient patient) {
        super(id, period);
        this.patientId = patient.getId();;
    }


    public int getPatientId () { return patientId; }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof PatientReservation patientReservation) {
            return super.equals(patientReservation) && patientId == patientReservation.getId();
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


    public Patient getPatient () { return Patients.INSTANCE.search(patientId); }
} // end class ExamRoomReservation
