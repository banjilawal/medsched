package edu.ics372.abdnn.medsched.facade.response;

import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.catalogs.reservations.*;
import edu.ics372.abdnn.medsched.core.entity.*;
import edu.ics372.abdnn.medsched.core.reservation.*;
import edu.ics372.abdnn.medsched.core.visitors.*;
import edu.ics372.abdnn.medsched.facade.request.*;

public class Response {


    public Patient response(CreatePatientRequest request) {
//        if ()
//            throw new Exception("Patient account already exists");
        if (Patients.INSTANCE.search(request.getEmail()) == null) {
            Patient patient = new Patient(
                SerialNumberGenerator.INSTANCE.patientId(),
                request.getFirstname(),
                request.getLastname(),
                request.getEmail()
            );
            if (Patients.INSTANCE.add(patient))
                return patient;
            else return null;

        }
        return null;
    }


    public Provider response(CreateProviderRequest request) {
        Provider provider = new Provider(
            SerialNumberGenerator.INSTANCE.providerId(),
            request.getFirstname(),
            request.getLastname()
        );
        provider.addDepartment(SearchRequest.departmentSearchRequest(request.getDepartmentName()));
        if (Providers.INSTANCE.add(provider))
            return provider;
        return null;
    }


    public Department response(CreateDepartmentRequest request) {
        if (Departments.INSTANCE.search(request.getName()) == null);
        Department department = new Department(SerialNumberGenerator.INSTANCE.departmentId(), request.getName());
        if (Departments.INSTANCE.add(department))
            return department;
        return null;
    }


    public ExamRoom response(CreateExamRoomRequest request) {
        if (ExamRooms.INSTANCE.search(request.getExamRoomName()) == null);
        ExamRoom examRoom = new ExamRoom(SerialNumberGenerator.INSTANCE.examroomId(), request.getExamRoomName());
        if (ExamRooms.INSTANCE.add(examRoom))
            return examRoom;
        return null;
    }


    public Appointment response(CreateAppointmentRequest request) {
        ProviderReservation providerReservation = getProviderReservation(
            request.getDepartment(),
            request.getTimeSlot(),
            request.getProvider()
        );
        PatientReservation patientReservation = getPatientReservation(
            request.getDepartment(),
            request.getTimeSlot(),
            request.getPatient()
        );
        RoomReservation roomReservation = getRoomReservation(
            request.getDepartment(),
            request.getTimeSlot(),
            request.getExamRoom()
        );

        if (roomReservation != null && providerReservation != null && patientReservation != null) {
            System.out.println("got all reservations");
            Appointment appointment = new Appointment(
                SerialNumberGenerator.INSTANCE.appointmentId(),
                request.getProvider(),
                request.getExamRoom(),
                request.getTimeSlot(),
                request.getDepartment(),
                request.getPatient()
            );
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


    private static RoomReservation getRoomReservation (Department department, Timeslot timeslot, ExamRoom examRoom) {
        return RoomReservations.INSTANCE.add(department, timeslot, examRoom);
    }

    private static ProviderReservation getProviderReservation (Department department, Timeslot timeslot, Provider provider) {
        return  ProviderReservations.INSTANCE.add(department, timeslot, provider);
    }

    private static PatientReservation getPatientReservation (Department department, Timeslot timeslot, Patient patient) {
        return PatientReservations.INSTANCE.add(department, timeslot, patient);
    }
} // end class Response
