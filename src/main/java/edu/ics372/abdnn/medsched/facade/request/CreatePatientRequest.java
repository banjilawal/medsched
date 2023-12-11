package edu.ics372.abdnn.medsched.facade.request;


public class CreatePatientRequest extends Request {
    private final String firstname;
    private final String lastname;
    private final String email;
    private final String password;

    private CreatePatientRequest (String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public String getFirstname () {
        return firstname;
    }

    public String getLastname () {
        return lastname;
    }

    public String getEmail () {
        return email;
    }

    public String getPassword () {
        return password;
    }
} // end class CreatePatientRequest
