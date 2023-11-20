/**
 *  @Author Banji Lawal
 *
 *  A meeting occurs at <code>Location</code> starting at a specified <code>Timeslot</code>. Meetings are led by a
 *  <code>Staff</code>
 *
 *  Rescheduling an Appointment
 *  ----------------------------s h
 *  Appointments are immutable. They cannot be rescheduled. If a patient or provider needs to change when the appointment
 *  occurs the appointment is marked as deleted or cancelled then a new one is created.
 *
 *  Deleting an Appointment
 *  ------------------------
 *  Appointments cannot be removed from the collection.  Instead of being deleted an <code>Appointment</code> then
 *  <code>Appointment.status</code> is set to <code>AppointmentStatus.CANCELLED</code>. When an appointment is cancelled
 *  the provider, patient, and examroom are marked as available. That <code>period</code> on the
 *  <code>Department.calendar</code> is open. There is no cancel method in the collection because <code>Appointment</code>
 *  has a method for changing its' status.
 *
 *  Overloads
 *  ----------
 *  <code>Appointments</code> methods fall into three categories, Two ot them are overloads. Overloads are:
 *      1. search -> returns a single instance <code><Appointment</code> instance if it exists for a <code>NamedEntity</code>
 *          during a <code>Period</code>
 *      2. getBookings -> returns  <code>ArrayList<Appointment></code>  of appointments booked with a <code>NamedEntity</code>
 *          The <code>getBookings</code>
 *
 *  Fields
 *  -------
 *  @param location <code>Location</code>
 *  @param timeslot <code>Timeslot</code>
 *  @param host <code>Staff</code>
 */
package edu.ics372.abdnn.medsched.core.abstracts;

import edu.ics372.abdnn.medsched.core.abstracts.*;
import edu.ics372.abdnn.medsched.core.entities.Timeslot;

import java.util.Objects;

public abstract class Meeting extends Entity {
    private Location location;
    private Timeslot timeSlot;
    private Staff host;


    public Meeting (int id, Staff staffMember, Location location, Timeslot timeSlot) {
        super(id);
        this.host = staffMember;
        this.location = location;
        this.timeSlot = timeSlot;
    } // close constructor

    public Staff getHost () {
        return host;
    }


    public Location getLocation () {
        return location;
    }

    public Timeslot getTimeslot () {
        return timeSlot;
    }

    public void setHost (Staff host) {
        this.host = host;
    }

    public void setLocation (Location location) {
        this.location = location;
    }


    public void setTimeSlot  (Timeslot timeSlot) {
        this.timeSlot = timeSlot;
    }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Meeting meeting) {
            return super.equals(meeting)
                && host == meeting.getHost()
                && timeSlot.equals((meeting.getTimeslot()))
                && location.equals(meeting.getLocation());
        }
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), host, location, timeSlot);
    } // close hashCode
} // end class Meeting
