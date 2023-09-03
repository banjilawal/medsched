package edu.ics372.abdnn.medsched.visitors;

import edu.ics372.abdnn.medsched.interfaces.AppointmentRequest;

public enum SerialNumberGenerator {
    INSTANCE;
    private int appointmentSerialNumber = 1;

    public int assignNumber() { return appointmentSerialNumber++; }

    public String assignName (AppointmentRequest appointmentRequest) { return appointmentRequest.getPatient().toString(); }
} // end class SerialNumberGenerator
