package edu.ics372.abdnn.medsched.services;

import edu.ics372.abdnn.medsched.entities.*;

public class Request {
    private final Department department;
    private final Provider departmentMember;
    private final Patient patient;
    private final Period period;

    public Request (Department department, Provider departmentMember, Patient patient, Period period) {
        this.department = department;
        this.departmentMember = departmentMember;
        this.patient = patient;
        this.period = period;
    }


    public Department getDepartment () {
        return department;
    }

    public Provider getDepartmentMember () {
        return departmentMember;
    }

    public Patient getPatient () {
        return patient;
    }

    public Period getPeriod () {
        return period;
    }
} // end class Request
