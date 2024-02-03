package edu.ics372.abdnn.medsched.facade.request;

import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.catalogs.reservations.*;
import edu.ics372.abdnn.medsched.core.concretes.*;
import edu.ics372.abdnn.medsched.core.concretes.reservation.*;
import edu.ics372.abdnn.medsched.core.visitors.*;

import java.time.*;

public class CreateAppointmentRequest extends Request {
    private Department department;
    private Provider provider;
    private ExamRoom examRoom;
    private Patient patient;
    private Timeslot timeSlot;
//
//    private ProviderReservation providerReservation;
//    private PatientReservation patientReservation;
//    private RoomReservation roomReservation;


    public CreateAppointmentRequest (Department department, Provider provider, ExamRoom examRoom, Patient patient, Timeslot timeSlot) {
        this.department = department;
        this.provider = provider;
        this.examRoom = examRoom;
        this.patient = patient;
        this.timeSlot = timeSlot;
//        this.providerReservation = null;
//        this.patientReservation = null;
//        this.roomReservation = null;
    }

    public Department getDepartment () {
        return department;
    }

    public Provider getProvider () {
        return provider;
    }

    public ExamRoom getExamRoom () {
        return examRoom;
    }

    public Patient getPatient () {
        return patient;
    }

    public Timeslot getTimeSlot () {
        return timeSlot;
    }
//
//    public Appointment result () {
//        reservePatient();
//        reserveProvider();
//        reserveExamRoom();
//        Appointment appointment = null;
//        if (roomReservation != null && patientReservation != null && providerReservation != null) {
//            appointment = new Appointment(
//                SerialNumberGenerator.INSTANCE.appointmentId(),
//                provider,
//                examRoom,
//                timeSlot,
//                department,
//                patient
//            );
//            try {
//                boolean success = Appointments.INSTANCE.add(appointment);
//                if (success)
//                    System.out.println("Appointment " + appointment.toString() + " successfully created");
//                else
//                    System.out.println("Appointment creation failed");
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//       try {
//           boolean success = ProviderReservations.INSTANCE.delete(providerReservation);
//           if (!success)
//               System.out.println("Failed to remove providerReservation");
//       } catch (Exception e) {
//           throw new RuntimeException(e);
//       }
//
//        try {
//            boolean success = RoomReservations.INSTANCE.delete(roomReservation);
//            if (!success)
//                System.out.println("Failed to remove roomReservation");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//        try {
//            boolean success = PatientReservations.INSTANCE.delete(patientReservation);
//            if (!success)
//                System.out.println("Failed to remove patientReservation");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return appointment;
//    }
//
//    private void reserveProvider () {
//        if (ProviderReservations.INSTANCE.conflictExists(department, timeSlot, provider)
//            && Appointments.INSTANCE.search(provider,timeSlot) == null) {
//            providerReservation = new ProviderReservation(department, timeSlot, provider);
//            ProviderReservations.INSTANCE.add(providerReservation);       }
//    }
//
//
//    private void reserveExamRoom () {
//        if (RoomReservations.INSTANCE.conflictExists(department, timeSlot, examRoom)
//            && Appointments.INSTANCE.search(examRoom, timeSlot) == null) {
//            roomReservation = new RoomReservation(department, timeSlot, examRoom);
//            RoomReservations.INSTANCE.add(roomReservation);
//        }
//    }


//    private void reservePatient () {
//        if (PatientReservations.INSTANCE.conflictExists(department, timeSlot, patient)
//            && Appointments.INSTANCE.search(patient, timeSlot) == null) {
//            patientReservation = new PatientReservation(department, timeSlot, patient);
//            PatientReservations.INSTANCE.add(patientReservation);
//        }
//    }
//
//
//
//    public Appointment appointmentSearchRequest (String departmentName, String patientEmail, LocalDate date, LocalTime appointmentStartTime) {
//        Patient patient = Patients.INSTANCE.search(patientEmail);
//        Department department = Departments.INSTANCE.search(departmentName);
//        for (Appointment appointment : Appointments.INSTANCE.search(departmeent, date, appointmentStartTime)) {
//            if (appointment.getPatient().equals(patient))
//                return appointment;
//        }
//        return null;
//    }
} // end class CreateAppointmentRequest
