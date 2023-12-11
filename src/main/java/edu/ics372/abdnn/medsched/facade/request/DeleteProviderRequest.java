package edu.ics372.abdnn.medsched.facade.request;


public class DeleteProviderRequest extends Request {
    private final String firstname;
    private final String lastname;
    private final int id;


    private DeleteProviderRequest (String firstname, String lastname, int id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
    }


    public String getFirstname () {
        return firstname;
    }

    public String getLastname () {
        return lastname;
    }

    private int getId () {
        return id;
    }
} // end class DeletePatientRequest
