package edu.ics372.abdnn.medsched.reserve;

import edu.ics372.abdnn.medsched.entities.Patient;
import edu.ics372.abdnn.medsched.entities.Period;

import java.util.*;

public class RerservationPatient extends Rerservation {
    private final Patient patient;

    public RerservationPatient (int id, Period period, Patient patient) {
        super(id, period);
        this.patient = patient;
    }


    public Patient getPatient() { return patient; }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof RerservationPatient reservation) {
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
