package edu.ics372.abdnn.medsched.facade.request;

import java.time.*;


public class CancelAppointmentRequest {
    private String patientEmail;
    private String departmentName;
    private LocalDate date;
    private LocalTime startTime;

    public CancelAppointmentRequest (String patientEmail, String departmentName, LocalDate date, LocalTime startTime) {
        this.patientEmail = patientEmail;
        this.departmentName = departmentName;
        this.date = date;
        this.startTime = startTime;
    }

    public String getPatientEmail () {
        return patientEmail;
    }

    public String getDepartmentName () {
        return departmentName;
    }

    public LocalDate getDate () {
        return date;
    }

    public LocalTime getStartTime () {
        return startTime;
    }
} // end class CancelAppointmentRequest
