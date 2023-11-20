package edu.ics372.abdnn.medsched.core.entities;

import edu.ics372.abdnn.medsched.core.abstracts.*;
import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.enums.*;
import edu.ics372.abdnn.medsched.core.global.*;
import edu.ics372.abdnn.medsched.core.interfaces.*;

import java.time.*;
import java.util.*;

public class Patient extends Person  {
    private String email;

    public Patient (int id, String firstname, String lastname, String email) {
        super(id, firstname, lastname);
        this.email = email;
    }


    public String getEmail () {
        return email;
    }


    public void setEmail (String email) {
        this.email = email;
    }


    public boolean delete () {
        if (Appointments.INSTANCE.cancelAppointments(this)) {
            setStatus(Status.DELETED);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Patient patient) {
            return super.equals(patient) && email.equalsIgnoreCase(patient.getEmail());
        }
        return false;
    }


    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), email);
    }


    @Override
    public String toString () {
        return super.toString() + " email:" + email;
    }


    public ArrayList<Timeslot> getOpenings (LocalDate startDate, LocalDate endDate) {
        ArrayList<Timeslot> timeslots = Timeslot.getTimeslots(startDate, endDate, Constant.OPENING_TIME, Constant.CLOSING_TIME);
        for (Appointment appointment : Appointments.INSTANCE.getBookings(this, startDate, endDate)) {
            Timeslot appointmentTimeslot = appointment.getTimeslot();
            if (timeslots.contains(appointmentTimeslot)) {
                timeslots.remove(timeslots.indexOf(appointmentTimeslot));
            }
        }
        return timeslots;
    }
} // end class Patient
