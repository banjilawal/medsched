package edu.ics372.abdnn.medsched.facade.request;


public class ProviderLoginRequest extends Request {
    private final String username;
    private final String password;



    public ProviderLoginRequest (String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername () {
        return username;
    }

    public String getPassword () {
        return password;
    }
} // end class CreatePatientRequest
