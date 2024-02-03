package edu.ics372.abdnn.medsched.facade.response;

import edu.ics372.abdnn.medsched.core.abstracts.*;
import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.catalogs.reservations.*;
import edu.ics372.abdnn.medsched.core.concretes.*;
import edu.ics372.abdnn.medsched.core.concretes.reservation.*;
import edu.ics372.abdnn.medsched.core.enums.*;
import edu.ics372.abdnn.medsched.core.exceptions.*;
import edu.ics372.abdnn.medsched.core.visitors.*;
import edu.ics372.abdnn.medsched.facade.request.*;

import java.time.*;
import java.util.*;

public class Response {


    public boolean response (DeletePatientRecordRequest request) throws AuthenticationFailureException {
        if (patient == null) {
            throw new AuthenticationFailureException(request.getPatientEmail() + " user does not exist");
        }
        LocalDateTime currentDate = LocalDate.now();

        for (Appointment appointment : Appointments.INSTANCE.getAppointments()) {
            if (appointment.getTimeslot().getDate().isEqual((LocalDate)currentDateTime.getDa))
        }
        return false;
    }

    public Appointment response (CancelAppointmentRequest request) throws AuthenticationFailureException {
        Patient patient = Patients.INSTANCE.search(request.getPatientEmail());
        if (patient == null) {
            throw new AuthenticationFailureException(request.getPatientEmail() + " user does not exist");
        }
        Appointment cancellationTarget = null;
        for (Appointment appointment : patient.getBookings()) {
            if (appointment.getTimeslot().getDate().equals(request.getDate())
                && appointment.getTimeslot().getStartTime().equals(request.getStartTime())
            ) {
                try {
                    appointment.setStatus(AppointmentStatus.CANCELLED);
                    cancellationTarget = appointment;
                    break;
                } catch (AppointStatusException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return cancellationTarget;
    } //


    public ArrayList<Appointment> response (ProviderBookingsRequest request) throws AuthenticationFailureException {
        Provider provider = Providers.INSTANCE.search(request.getUsername());
        if (provider == null) {
            throw new AuthenticationFailureException(request.getUsername() + " provider does not exist");
        }
        return Appointments.INSTANCE.getBookings(provider, request.getStartDate(), request.getEndDate());
    }

    public ArrayList<Appointment> response (AppointmentListRequest request) throws AuthenticationFailureException {
        Patient patient = Patients.INSTANCE.search(request.getPatientEmail());
        if (patient == null) {
            throw new AuthenticationFailureException(request.getPatientEmail() + " user does not exist");
        }
        return Appointments.INSTANCE.getBookings(patient, request.getStartDate(), request.getEndDate());;
    }

    public Provider response (ProviderLoginRequest request) throws AuthenticationFailureException {
        Provider provider = SearchRequest.providerSearchRequest(request.getUsername());
        if (provider == null) {
            throw new AuthenticationFailureException(request.getUsername() + " user does not exist");
        }
        if (provider.getPassword().compareTo(request.getPassword()) != 0) {
            throw new AuthenticationFailureException("incorrect password or username");
        }
        return provider;
    }

    public Patient response (PatientLoginRequest request) throws AuthenticationFailureException {
        Patient patient = Patients.INSTANCE.search(request.getEmail());
        if (patient == null) {
            throw new AuthenticationFailureException(request.getEmail() + " user does not exist");
        }
        if (patient.getPassword().compareTo(request.getPassword()) != 0) {
            throw new AuthenticationFailureException("incorrect password or username");
        }
        return patient;
    }


    public ArrayList<String> response (DepartmentMembersRequest request) {
        ArrayList<String> answer = new ArrayList<>();
        Department department = Departments.INSTANCE.search(request.getDepartmentName());
        for (Staff member : department.getMembers()) {
            String name = member.getFirstname() + " " + member.getLastname();
            answer.add(answer.size(), name);
        }
        return answer;
    }


    public ArrayList<String> response (DepartmentNamesRequest request) {
        ArrayList<String> answer = new ArrayList<>();
        for (Department department : Departments.INSTANCE.getDepartments()) {
            String name = department.getName();
            if (!answer.contains(name)) {
                answer.add(answer.size(), name);
            }
        }
        return answer;
    }


    public Patient response (CreatePatientRequest request) throws
        UserCreationFailureException,
        RecordAdditionFailedException
    {
        if (Patients.INSTANCE.search(request.getEmail()) != null) {
            throw new UserCreationFailureException(request.getEmail() + " already exists");
        }
        Patient patient = new Patient(
            SerialNumberGenerator.INSTANCE.patientId(),
            request.getFirstname(),
            request.getLastname(),
            request.getPassword(),
            request.getEmail()
        );
        boolean success = Patients.INSTANCE.add(patient);
        if (!success) {
            throw new RecordAdditionFailedException("Adding " + patient.toString() + " failed");
        }
        System.out.println("Successfully added " + patient.toString());
        return patient;
    }


    public Provider response (CreateProviderRequest request) throws
        UserCreationFailureException,
        RecordAdditionFailedException
    {
        if (Providers.INSTANCE.search(request.getUsername()) != null) {
            throw new UserCreationFailureException(request.getUsername() + " already exists");
        }
        Provider provider = new Provider(
            SerialNumberGenerator.INSTANCE.providerId(),
            request.getFirstname(),
            request.getLastname(),
            request.getUsername(),
            request.getPassword()
        );
        provider.addDepartment(SearchRequest.departmentSearchRequest(request.getDepartmentName()));
        boolean success = Providers.INSTANCE.add(provider);
        if (!success) {
            throw new RecordAdditionFailedException("Adding " + provider.toString() + " failed");
        }
        System.out.println("Successfully added " + provider.toString());
        return provider;
    }


    public Department response (CreateDepartmentRequest request) throws
        DuplicateEntityException,
        RecordAdditionFailedException
    {
        if (Departments.INSTANCE.search(request.getDepartmentName()) != null) {
            throw new DuplicateEntityException(request.getDepartmentName() + " already exists");
        }
        Department department = new Department(SerialNumberGenerator.INSTANCE.departmentId(), request.getDepartmentName());
        boolean success = Departments.INSTANCE.add(department);
        if (!success) {
            throw new RecordAdditionFailedException("Adding department " + department.getName() + " failed");
        }
        System.out.println("Successfully added " + department.getName());
        return department;
    }


    public ExamRoom response (CreateExamRoomRequest request)
        throws DuplicateEntityException,
        RecordAdditionFailedException
    {
        if (ExamRooms.INSTANCE.search(request.getExamRoomName()) != null) {
            throw new DuplicateEntityException(request.getExamRoomName() + " already exists");
        }
        ExamRoom examRoom = new ExamRoom(SerialNumberGenerator.INSTANCE.examroomId(), request.getExamRoomName());
        boolean success = ExamRooms.INSTANCE.add(examRoom);
        if (!success) {
            throw new RecordAdditionFailedException("Adding examRoom " + examRoom.getName() + " failed");
        }
        System.out.println("Successfully added " + examRoom.getName());
        return examRoom;
    }


    public Appointment response (CreateAppointmentRequest request) throws
        ReservationRejectionException,
        FailedRecordDeletionException,
        RecordAdditionFailedException,
        AppointmentCreationFailedException
    {
        String message = "";
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
//        if (roomReservation == null || providerReservation == null || patientReservation == null) {
//            if (roomReservation != null && !RoomReservations.INSTANCE.delete(roomReservation)) {
//                throw new FailedRecordDeletionException("Delete failed " + roomReservation.toString());
//            }
//            if (providerReservation != null && !ProviderReservations.INSTANCE.delete(providerReservation)) {
//                throw new FailedRecordDeletionException("Delete failed " + providerReservation.toString());
//            }
//            if (patientReservation != null && !PatientReservations.INSTANCE.delete(patientReservation)) {
//                throw new FailedRecordDeletionException("Delete failed " + patientReservation.toString());
//            }
//            throw new ReservationRejectionException("Appointment resource reservation failed");
//        }

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
            boolean success = Appointments.INSTANCE.add(appointment);
            if (!success) {
                throw new RecordAdditionFailedException("Adding appointment " + appointment.toString() + " failed");
            }
            if (!RoomReservations.INSTANCE.delete(roomReservation)) {
                throw new FailedRecordDeletionException("Delete failed " + roomReservation.toString());
            }
            if (!PatientReservations.INSTANCE.delete(patientReservation)) {
                throw new FailedRecordDeletionException("Delete failed " + patientReservation.toString());
            }
            if (!ProviderReservations.INSTANCE.delete(providerReservation)) {
                throw new FailedRecordDeletionException("Delete failed " + providerReservation.toString());
            }
            System.out.println("Successfully deleted " + roomReservation.toString());
            System.out.println("Successfully deleted " + patientReservation.toString());
            System.out.println("Successfully deleted " + providerReservation.toString());
            System.out.println("Successfully added " + appointment.getId());
            return appointment;
        } else {
            throw new AppointmentCreationFailedException(
                "Failed appointment creation for  "
                    + request.getPatient().getEmail()
                    + " at " + request.getTimeSlot().toString()
            );
        }
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
