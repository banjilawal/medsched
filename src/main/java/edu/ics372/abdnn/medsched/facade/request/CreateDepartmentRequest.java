package edu.ics372.abdnn.medsched.facade.request;


import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.concretes.*;
import edu.ics372.abdnn.medsched.core.visitors.*;

public class CreateDepartmentRequest {
    private final String name;


    public CreateDepartmentRequest (String name) {
        this.name = name;
    }


    public String getDepartmentName () {
        return name;
    }

    public Department result () {
        String message = "";
        Department department = null;
        try {
            if (Departments.INSTANCE.search(name) != null) {
                message = "Department  named " + name + " already exists";
            }
            else {
                department = new Department(SerialNumberGenerator.INSTANCE.departmentId(), name);
                boolean success = Departments.INSTANCE.add(department);
                if (!success)
                    message = "Adding department " + department.getName() + " failed";
                else
                    message = "Successfully added " + department.getName();
            }
        } catch (Exception e) {
            System.out.println(message);
            throw new RuntimeException(e);
        }
        return department;
    }
} // end class CreateDepartmentRequest
