package edu.ics372.abdnn.medsched.facade.request;


public class DeletePatientRequest extends Request {
    private final String firstname;
    private final String lastname;
    private final String email;
    private final int id;

    public DeletePatientRequest (String firstname, String lastname, String email, int id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.id = id;
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

    public int getId () {
        return id;
    }
} // end class DeletePatientRequest
