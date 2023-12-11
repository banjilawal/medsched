package edu.ics372.abdnn.medsched.facade.request;


import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.concretes.*;
import edu.ics372.abdnn.medsched.core.visitors.*;

public class PatientLoginRequest extends Request {
    private final String email;
    private final String password;



    public PatientLoginRequest (String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail () {
        return email;
    }

    public String getPassword () {
        return password;
    }
} // end class CreatePatientRequest
