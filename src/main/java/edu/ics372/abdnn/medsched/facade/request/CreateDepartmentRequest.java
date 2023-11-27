package edu.ics372.abdnn.medsched.facade.request;


public class CreateDepartmentRequest {
    private final String name;


    private CreateDepartmentRequest (String name) {
        this.name = name;
    }


    public String getName () {
        return name;
    }
} // end class CreateDepartmentRequest
