package edu.ics372.abdnn.medsched.facade.request;

import java.time.*;


public class AppointmentListRequest {
    private String patientEmail;

    private LocalDate startDate;
    private LocalDate endDate;

    public AppointmentListRequest (String patientEmail, LocalDate startDate, LocalDate endDate) {
        this.patientEmail = patientEmail;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getPatientEmail () {
        return patientEmail;
    }

    public LocalDate getStartDate () {
        return startDate;
    }


    public LocalDate getEndDate () {
        return endDate;
    }
} // end class CancelAppointmentRequest
