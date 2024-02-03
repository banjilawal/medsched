package edu.ics372.abdnn.medsched.facade.request;

import java.time.*;


public class DeletePatientRecordRequest {
    private String patientEmail;

    public DeletePatientRecordRequest (String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getPatientEmail () {
        return patientEmail;
    }
} // end class DeletePatientRecordRequest
