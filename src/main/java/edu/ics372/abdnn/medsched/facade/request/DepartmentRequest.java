package edu.ics372.abdnn.medsched.facade.request;

public abstract class DepartmentRequest extends Request {
    private String departmentName;

    public DepartmentRequest (String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName () {
        return departmentName;
    }
} // end class DepartmentRequest
