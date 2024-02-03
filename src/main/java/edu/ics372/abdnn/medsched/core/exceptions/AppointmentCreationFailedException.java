package edu.ics372.abdnn.medsched.core.exceptions;

public class AppointmentCreationFailedException extends Exception {

    public AppointmentCreationFailedException () {
        super();
    }


    public AppointmentCreationFailedException (String message) {
        super(message);
    }
}
