package edu.ics372.abdnn.medsched.core.entities;

import edu.ics372.abdnn.medsched.core.abstracts.*;
import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.enums.*;
import edu.ics372.abdnn.medsched.core.global.*;
import edu.ics372.abdnn.medsched.core.interfaces.*;

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
        Iterator<Department> iterator = Departments.INSTANCE.getDepartments().iterator();
        while (iterator.hasNext()) {
            Department department = iterator.next();
            if (department.getMembers().contains(this) && !matches.contains(department))
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


    public ArrayList<Timeslot> getOpenings (LocalDate startDate, LocalDate endDate) {
        ArrayList<Timeslot> timeslots = Timeslot.getTimeslots(startDate, endDate,Constant.OPENING_TIME, Constant.CLOSING_TIME);
        for (Appointment appointment : Appointments.INSTANCE.getBookings(this, startDate, endDate)) {
            Timeslot appointmentTimeslot = appointment.getTimeslot();
            if (timeslots.contains(appointmentTimeslot)) {
                timeslots.remove(timeslots.indexOf(appointmentTimeslot));
            }
        }
        return timeslots;
    }
} // end class Provider
