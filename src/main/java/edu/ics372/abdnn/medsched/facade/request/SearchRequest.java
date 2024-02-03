package edu.ics372.abdnn.medsched.facade.request;

import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.concretes.*;

import java.time.*;
import java.util.*;


public final class SearchRequest extends Request {


    public static Patient patientSearchRequest (String patientEmail) {
        return Patients.INSTANCE.search(patientEmail);
    }


    public static Provider providerSearchRequest (String providerUsername) {
        return Providers.INSTANCE.search(providerUsername);
    }


    public static Provider providerSearchRequest (int providerId) {
        return Providers.INSTANCE.search(providerId);
    }


    public static Department departmentSearchRequest (String departmentName) {
        return Departments.INSTANCE.search(departmentName);
    }


    public static ExamRoom examRoomSearchRequest (String examRoomName) {
        return ExamRooms.INSTANCE.search(examRoomName);
    }


    public static Appointment appointmentSearchRequest (String departmentName, String patientEmail, LocalDate date,  LocalTime appointmentStartTime) {
        Patient patient = patientSearchRequest(patientEmail);
        Department department = departmentSearchRequest(departmentName);
        Appointment appointment = Appointments.INSTANCE.search(department, date, appointmentStartTime);
        if (appointment.getPatient().equals(patient))
            return appointment;
        return null;
    }
} // end class SearchRequest
