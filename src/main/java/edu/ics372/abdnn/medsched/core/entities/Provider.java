package edu.ics372.abdnn.medsched.core.entities;

import edu.ics372.abdnn.medsched.core.abstracts.*;
import edu.ics372.abdnn.medsched.core.catalogs.*;

import java.time.*;
import java.util.*;

public class Provider extends Staff {

    public Provider (int id, String firstname, String lastname) {
        super(id, firstname, lastname);
    }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Provider provider) {
            return super.equals(provider);
        }
        return false;
    }


    public ArrayList<Department> getDepartments () {
        ArrayList<Department> matches = new ArrayList<>();
        Iterator<Department> iterator = Departments.INSTANCE.iterator();
        while (iterator.hasNext()) {
            Department department = iterator.next();
            if (department.isMember(this) && !matches.contains(department))
                matches.add(matches.size(),department);
        }
        return matches;
    } //


    public boolean addDepartment (Department department) {
        return department.addMember(this);
    }


    public boolean removeDepartment (Department department) {
        return department.removeMember(this);
    }


    public ArrayList<Period> getOpenings (LocalDate startDate, LocalDate endDate) {
        ArrayList<Period> matches = new ArrayList<>();
        for (Department department : getDepartments()) {
            for (Appointment appointment : department.getAppointments(startDate, endDate)) {
                if (!this.equals(appointment.getProvider()) && !matches.contains(appointment.getPeriod()))
                    matches.add(matches.size(), period);
            }
        }
        return matches;
    }
} // end class Provider
