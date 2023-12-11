/**
 *  @Author Banji Lawal
 *
 *  <code>Provider</code> is a extends <code>Staff</code>. An <code>Appointment</code> is made with a provider
 *  TO prevent side-effects a <code>Provider</code> will find bookings and departments from calling methods in
 *  <code>Appointments</code>, <code>Department</code> and other entities where there is a 1:M or M:N relationship
 *  with <code>Provider</code>
 *
 */

package edu.ics372.abdnn.medsched.core.concretes;

import edu.ics372.abdnn.medsched.core.abstracts.*;
import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.global.*;
import edu.ics372.abdnn.medsched.core.interfaces.*;

import java.time.*;
import java.util.*;

public class Provider extends Staff implements Openings {

    private String username;
    private String password;


    public Provider (int id, String firstname, String lastname, String username, String password) {
        super(id, firstname, lastname);
        this.password = password;
        this.username = username;
    }


    public String getUsername () {
        return username;
    }


    public String getPassword () {
        return password;
    }


    public void setUsername (String username) {
        this.username = username;
    }


    public void setPassword (String password) {
        this.password = password;
    }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Provider provider) {
            return super.equals(provider) && username.equalsIgnoreCase(provider.getUsername());
        }
        return false;
    }


    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), username, password);
    }

    /**
     * A provider can be in multiple departments so they can have schedules in different departments so we need to get
     * We want to know if a date and time are within the timeslot if so return <code>true</code>, otherwise <code>false</code>
     * @param date LocalDate
     * @param time LocalTime
     * @return <code>boolean</code>
     */
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


    @Override
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


    @Override
    public String toString () {
        return super.toString() + " username:" + username;
    }
} // end class Provider
