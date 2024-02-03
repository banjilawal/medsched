package edu.ics372.abdnn.medsched.core.exceptions;

public class AuthenticationFailureException extends Exception {

    public AuthenticationFailureException () {
        super();
    }


    public AuthenticationFailureException (String message) {
        super(message);
    }
}
