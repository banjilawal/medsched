package edu.ics372.abdnn.medsched.facade.request;


import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.concretes.*;
import edu.ics372.abdnn.medsched.core.visitors.*;

public class CreatePatientRequest extends Request {
    private final String firstname;
    private final String lastname;
    private final String password;
    private final String email;


    public CreatePatientRequest (String firstname, String lastname, String password, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
    }

    public String getFirstname () {
        return firstname;
    }

    public String getLastname () {
        return lastname;
    }

    public String getPassword () {
        return password;
    }

    public String getEmail () {
        return email;
    }


    public Patient result () {
        String message = "";
        Patient patient = null;
        try {
            if (Patients.INSTANCE.search(email) != null) {
                message = "An account with " + email + " already exists";
            } else {
                patient = new Patient(SerialNumberGenerator.INSTANCE.patientId(), firstname, lastname, password, email);
                boolean success = Patients.INSTANCE.add(patient);
                if (!success)
                    message = "Adding patient " + patient.toString() + " failed";
                else
                    message = "Successfully added " + patient.toString();
            }
        } catch (Exception e) {
            System.out.println(message);
            throw new RuntimeException(e);
        }
        return patient;
    }
} // end class CreatePatientRequest
