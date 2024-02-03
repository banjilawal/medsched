package edu.ics372.abdnn.medsched.core.exceptions;

public class DuplicateEntityException extends Exception {

    public DuplicateEntityException () {
        super();
    }


    public DuplicateEntityException (String message) {
        super(message);
    }
}
