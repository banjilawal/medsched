package edu.ics372.abdnn.medsched.facade.request;


public class CreateProviderRequest extends Request {
    private final String firstname;
    private final String lastname;
    private final String departmentName;

    private CreateProviderRequest (String firstname, String lastname, String departmentName) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.departmentName = departmentName;
    }

    public String getFirstname () {
        return firstname;
    }

    public String getLastname () {
        return lastname;
    }

    public String getDepartmentName () {
        return departmentName;
    }
} // end class CreateProviderRequest
