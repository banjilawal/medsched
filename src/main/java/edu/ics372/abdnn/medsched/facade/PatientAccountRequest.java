package edu.ics372.abdnn.medsched.facade;

import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.entities.*;
import edu.ics372.abdnn.medsched.core.enums.*;
import edu.ics372.abdnn.medsched.core.visitors.*;

import java.time.*;

public class PatientAccountRequest extends ServiceRequest {
    private String patientFirstname;
    private String patientLastname;
    private String patientEmail;
    private String patientPassword;
    private String providerFirstname;
    private String providerLastname;
    private String departmentName;
    private int patientId;
    private int providerId;
    private int appointmentId;
    private LocalDate appointmentDate;
    private LocalTime appointmentStartTime;


    public boolean createPatientAccountRequest (String patientFirstname, String patientLastname, String patientEmail, String patientPassword) {
        Patient patient = new Patient(SerialNumberGenerator.INSTANCE.patientId(), patientFirstname, patientLastname, patientEmail);
        return Patients.INSTANCE.add(patient);
    }


    public boolean createProviderAccountRequest (String providerFirstname, String providerLastname) {
        return Providers.INSTANCE.add(
            SerialNumberGenerator.INSTANCE.providerId(),
            providerFirstname,
            providerLastname
        );
    }


    public boolean createDepartmentRequest (String departmentName) {
        Department department = new Department(SerialNumberGenerator.INSTANCE.departmentId(), departmentName);
        return Departments.INSTANCE.add(department);
    }


    public Patient patientSearchRequest (String patientEmail) {
        return Patients.INSTANCE.search(email);
    }


    public Provider providerSearchRequest (int providerId) {
        return Providers.INSTANCE.search(providerId);
    }


    public Appointment appointmentSearchRequest (String departmentName, String patientEmail, LocalDate date,  LocalTime appointmentStartTime) {
        Patient patient = Patients.INSTANCE.search(patientEmail);
        Department department = Departments.INSTANCE.search(departmentName);
        for (Appointment appointment : Appointments.INSTANCE.search(departmeent, date, appointmentStartTime)) {
            if (appointment.getPatient().equals(patient))
                return appointment;
        }
        return null;
    }


    public void cancelAppointmentRequest (String patientEmail, String departmentName, LocalDate date,  LocalTime startTime) {
        appointmentSearchRequest(departmentName, patientEmail, date, startTime).seStatus(AppointmentStatus.CANCELLED);
    }
} // end class PatientRequest
