package edu.ics372.abdnn.medsched.facade;

import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.entities.*;
import edu.ics372.abdnn.medsched.core.visitors.*;

import java.time.*;

public class PatientAccountRequest extends ServiceRequest {
    private String patientFirstname;
    private String patientLastname;
    private String patientEmail;
    private String patientPassword;
    private String providerFirstname;
    private String providerLastname;
    private String departmentName
    private int patientId;
    private int providerId;
    private int appointmentId;
    private LocalDate appointmentDate;
    private LocalTime appointmentStartTime;


    public boolean createPatientAccountRequest (String patientFirstname, String patientLastname, String patientEmail, String patientPassword) {
        patient = new Patient(SerialNumberGenerator.INSTANCE.patientId(), patientFirstname, patientLastname);
        return Patients.INSTANCE.add(patient);
    }


    public boolean createProviderAccountRequest (String providerFirstname, String providerLastname) {
        providert = new Provider(SerialNumberGenerator.INSTANCE.providerId(), providerFirstname, providerLastname);
        return Providers.INSTANCE.add(provider);
    }



    public deleteAppointmentRequest (String patientEmail, )
} // end class PatientRequest
