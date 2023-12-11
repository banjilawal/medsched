package edu.ics372.abdnn.medsched.facade.request;


import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.concretes.*;
import edu.ics372.abdnn.medsched.core.visitors.*;

public class CreateProviderRequest extends Request {

    private final String departmentName;
    private final String firstname;
    private final String lastname;
    private final String username;
    private final String password;


    public CreateProviderRequest (String departmentName, String firstname, String lastname, String username, String password) {
        this.departmentName = departmentName;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    public String getDepartmentName () {
        return departmentName;
    }

    public String getFirstname () {
        return firstname;
    }

    public String getLastname () {
        return lastname;
    }


    public String getUsername () {
        return username;
    }


    public String getPassword () {
        return password;
    }



    public Provider result () {
        String message = "";
        Provider provider = null;
        try {
            provider = new Provider(SerialNumberGenerator.INSTANCE.providerId(), firstname, lastname, username, password);
            provider.addDepartment(Departments.INSTANCE.search(departmentName));
            boolean success = Providers.INSTANCE.add(provider);
            if (!success)
                message = "Adding provider " + provider.toString() + " failed";
            else
                message = "Successfully added " + provider.toString();
        } catch (Exception e) {
            System.out.println(message);
            throw new RuntimeException(e);
        }
        return provider;
    }
} // end class CreateProviderRequest
