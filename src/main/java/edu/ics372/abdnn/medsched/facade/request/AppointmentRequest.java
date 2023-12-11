package edu.ics372.abdnn.medsched.facade.request;

import edu.ics372.abdnn.medsched.core.abstracts.*;
import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.catalogs.reservations.*;
import edu.ics372.abdnn.medsched.core.entity.*;
import edu.ics372.abdnn.medsched.core.reservation.*;
import edu.ics372.abdnn.medsched.core.visitors.*;

public class AppointmentRequest extends AnonymousEntity {
    private Department department;
    private Provider provider;
    private ExamRoom examRoom;
    private Patient patient;
    private Timeslot timeSlot;

    private ProviderReservation providerReservation;
    private PatientReservation patientReservation;
    private RoomReservation roomReservation;


    public AppointmentRequest (Department department, Provider provider, ExamRoom examRoom, Patient patient, Timeslot timeSlot) {
        this.department = department;
        this.provider = provider;
        this.examRoom = examRoom;
        this.patient = patient;
        this.timeSlot = timeSlot;

        this.providerReservation = null;
        this.patientReservation = null;
        this.roomReservation = null;
    }


    public Appointment result () {
        requestRoom();
        requestProvider();
        requestPatient();
        if (roomReservation != null && providerReservation != null && patientReservation != null) { //&& requestProvider() && requestPatient()) {
            System.out.println("got all reservations");
            Appointment appointment = new Appointment(SerialNumberGenerator.INSTANCE.appointmentId(), provider, examRoom, timeSlot, department, patient);
            System.out.println(appointment.toString());
            if (Appointments.INSTANCE.add(appointment)) {
                RoomReservations.INSTANCE.delete(roomReservation);
                PatientReservations.INSTANCE.delete(patientReservation);
                ProviderReservations.INSTANCE.delete(providerReservation);
                return appointment;
            }
        }
        return null;
    }


    public void requestRoom () {
        this.roomReservation = RoomReservations.INSTANCE.add(department, timeSlot, examRoom);
        System.out.println("got room" + this.roomReservation.toString());
//        boolean result = !RoomReservations.INSTANCE.conflictExists(department, timeSlot, examRoom)
//            && Appointments.INSTANCE.search(examRoom, timeSlot) != null;
//        System.out.println("room request result:" + result);
//        if (result == false){
//            System.out.println("no room reservation conflict");
//            this.roomReservation = new RoomReservation(department, timeSlot, examRoom);
//            System.out.println(roomReservation.toString());
//            result = RoomReservations.INSTANCE.add(department, timeSlot, examRoom);
//
//            System.out.println("added reservation " + result + " " + RoomReservations.INSTANCE.getReservations().size());
//        }
//        return result;
    }


    public void requestProvider () {
        this.providerReservation = ProviderReservations.INSTANCE.add(department, timeSlot, provider);
//        if (
//            !ProviderReservations.INSTANCE.conflictExists(department, timeSlot, provider)
//                && Appointments.INSTANCE.search(provider, timeSlot) == null
//        ) {
//            System.out.println("no provider reservation conflict");
//            this.providerReservation = new ProviderReservation(department, timeSlot, provider);
//            System.out.println(providerReservation.toString());
//            return ProviderReservations.INSTANCE.add(this.providerReservation);
//        }
//        return false;
    }


    public void requestPatient () {
        this.patientReservation = PatientReservations.INSTANCE.add(department, timeSlot, patient);
//        if (
//            !PatientReservations.INSTANCE.conflictExists(department, timeSlot, patient)
//                && Appointments.INSTANCE.search(patient, timeSlot) == null
//        ) {
//            System.out.println("no patient reservation conflict");
//            System.out.println(patientReservation.toString());
//            this.patientReservation = new PatientReservation(department, timeSlot, patient);
//            return PatientReservations.INSTANCE.add(patientReservation);
//        }
//        return false;
    }
} // end class AppointmentRequest
