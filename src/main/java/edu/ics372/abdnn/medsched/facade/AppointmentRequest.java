package edu.ics372.abdnn.medsched.facade;

import edu.ics372.abdnn.medsched.core.abstracts.*;
import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.entities.*;
import edu.ics372.abdnn.medsched.core.reservations.*;
import edu.ics372.abdnn.medsched.core.visitors.*;

public class AppointmentRequest extends AnonymousEntity {
    private Department department;
    private Provider provider;
    private ExamRoom examRoom;
    private Patient patient;
    private Period period;

    private ProviderReservation providerReservation;
    private PatientReservation patientReservation;
    private RoomReservation roomReservation;


    public AppointmentRequest (Department department, Provider provider, ExamRoom examRoom, Patient patient, Period period) {
        this.department = department;
        this.provider = provider;
        this.examRoom = examRoom;
        this.patient = patient;
        this.period = period;

        this.providerReservation = null;
        this.patientReservation = null;
        this.roomReservation = null;
    }


    public boolean request () {
        if (requestRoom() && requestProvider() && requestPatient()) {
            Appointment appointment = new Appointment(SerialNumberGenerator.INSTANCE.appointmentId(), provider, examRoom, period, department, patient);
            if (ppointments.INSTANCE.add(appointment)) {
                RoomReservations.INSTANCE.getReservations().remove(reservations.indexOf(reservation);
                PatientReservations.INSTANCE.getReservations().remove(reservations.indexOf(reservation);
                ProviderReservations.INSTANCE.getReservations().remove(reservations.indexOf(reservation);
                return Appointments.INSTANCE.add(appointment);
            }
        }
        return false;
    }


    public boolean requestRoom () {
        if (
            !RoomReservations.INSTANCE.reservationExists(department, period, examRoom)
            && Appointments.INSTANCE.search(examRoom, period) == null
        ) {
            this.romReservation = new RoomReservation(department, period, examRoom);
            return RoomReservations.INSTANCE.add(department, period, examRoom);
        }
        return false;
    }

    public boolean requestProvider () {
        if (
            !ProviderReservations.INSTANCE.reservationExists(department, period, provider)
                && Appointments.INSTANCE.search(provider, period)
        ) {
            this.providerReservation = new ProviderReservation(department, period, provider);
            return ProviderReservations.INSTANCE.add(this.providerReservation);
        }
        return false;
    }


    public boolean requestPatient () {
        if (
            !PatientReservations.INSTANCE.reservationExists(department, period, patient)
                && Appointments.INSTANCE.search(patient, period)
        ) {
            this.patientReservation = new PatientReservation(department, period, patient);
            return PatientReservations.INSTANCE.add(this.patientReservation);
        }
        return false;
    }
} // end class AppointmentRequest
