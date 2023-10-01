package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.*;
import edu.ics372.abdnn.medsched.catalogs.*;
import edu.ics372.abdnn.medsched.enums.*;

import java.lang.reflect.*;
import java.time.*;
import java.util.*;
import java.util.function.*;

public class Provider extends Staff {

    public Provider (int id, String firstname, String lastname) {
        super(id, firstname, lastname);
    } // close constructor


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
            for (Appointment appointment : department.getAppointments()) {
                if (!this.equals(appointment.getProvider()) && !matches.contains(appointment.getPeriod()))
                    matches.add(matches.size(), period);
            }
        }
        return matches;
    }


    public Iterator<Appointment> getBookings (Department department, LocalDate startDate, LocalDate endDate) {
        Predicate<Appointment> predicate = appointment -> {
            return appointment.getProvider().equals(this)
                && appointment.getDepartment().equals(department)
                && appointment.getPeriod().getDate().isAfter(startDate.minusDays(1))
                && appointment.getPeriod().getDate().isBefore(endDate.plusDays(1));
        };
        return Appointments.INSTANCE.filter(predicate);
    }


    public Iterator<Appointment> getBookings (LocalDate startDate, LocalDate endDate) {
        Predicate<Appointment> predicate = appointment -> {
            return appointment.getProvider().equals(this)
                && appointment.getPeriod().getDate().isAfter(startDate.minusDays(1))
                && appointment.getPeriod().getDate().isBefore(endDate.plusDays(1));
        };
        return Appointments.INSTANCE.filter(predicate);
    }
} // end class Provider
