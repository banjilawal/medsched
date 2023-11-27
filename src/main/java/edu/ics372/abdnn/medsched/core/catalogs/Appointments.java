/**
 *  @Author Banji Lawal
 *
 *  Appointments is responsible for storing all appointments. An appointment is only created when:
 *      1. The patient does not have an appointment for that date and time.
 *      2. The department has an open time period at the requested time.
 *      3. The requested provider has not been scheduled to meet a patient at that time.
 *
 *  Rescheduling an Appointment
 *  ----------------------------
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
 * @param appointments ArrayList should only be accessed with methods that either return an <code>ArrayList</code> or
 *      <code>Iterator</code>
 */

package edu.ics372.abdnn.medsched.core.catalogs;

import edu.ics372.abdnn.medsched.core.entity.Timeslot;
import edu.ics372.abdnn.medsched.core.entity.*;

import java.time.*;
import java.util.*;
import java.util.function.*;

public enum Appointments {
    INSTANCE;
    private final ArrayList<Appointment> appointments = new ArrayList<>();

    /**
     * Returns an <code>ArrayList</code> of appointments booked with a department on <code>date</code>
     * between <code>startTime</code> and closing time. If no appointments are found returns null.
     * @param department
     * @param date LocalDate
     * @param startTime LocalTime
     * @return ArrayList<Appointment><
     */
    public Appointment search (Department department, LocalDate date, LocalTime startTime) {
        for (Appointment appointment : appointments) {
            if (appointment.getDepartment().equals(department) && appointment.getTimeslot().inDateTimeRange(date, startTime))
                return appointment;
        }
        return null;
    }


    /**
     * Returns null if <code>examRoom</code> is not assigned to an <code>Appointment</code> during <code>period</code>.
     * otherwise returns the appointment.
     * @param examRoom Examroom
     * @param timeslot Period
     * @return Appointment
     */
    public Appointment search (ExamRoom examRoom, Timeslot timeslot) {
        for (Appointment appointment : appointments) {
            if (appointment.getExamRoom().equals(examRoom) && appointment.getTimeslot().equals(timeslot))
                return appointment;
        }
        return null;
    }


    /**
     * If an <code>Appointment</code> with <code>id</code> exists return it, otherwise return null.
     * @param id int
     * @return Appointment
     */
    public Appointment search (int id) {
        for (Appointment appointment : appointments) {
            if (appointment.getId() == id)
                return appointment;
        }
        return null;
    }

    /**
     * If an appointment exists for <code>patient</code> on <code>period</code> in <code>department</code>
     * return it, otherwise return null
     * @param department Department
     * @param patient Patient
     * @param timeslot Period
     * @return ArrayList
     */
    public Appointment search (Department department, Patient patient, Timeslot timeslot) {
        for (Appointment appointment : appointments) {
            if (appointment.getDepartment().equals(department)
                && appointment.getPatient().equals(patient)
                && appointment.getTimeslot().equals(timeslot)) {
                return appointment;
            }
        }
        return null;
    }


    /**
     * If we don't know under which department a patient's appointment is booked we use this version of
     * <code>search</code>. Might take longer than <code>search(Department department, Patient patient, Period period)</code>
     * returns null if no appointment exists for <code>patient</code> at <code>period</code>
     * @param patient Patient
     * @param timeslot Period
     * @return Appointment
     */
    public Appointment search (Patient patient, Timeslot timeslot) {
        for (Appointment appointment : appointments) {
            if (appointment.getPatient().equals(patient) && appointment.getTimeslot().equals(timeslot))
                return appointment;
        }
        return null;
    }


    /**
     * If an appointment exists for <code>provider</code> at <code>period</code> return it, otherwise return null
     * @param provider Provider
     * @param timeslot Period
     * @return Appointment
     */
    public Appointment search (Provider provider, Timeslot timeslot) {
        for (Appointment appointment : appointments) {
            if (appointment.getProvider().equals(provider) && appointment.getTimeslot().equals(timeslot))
                return appointment;
        }
        return null;
    }


    /**
     * Returns appointments booked with <code>department</code> between <code>startDate</code> and <code>endDate</code>
     * inclusive. If none exist returns an empty <code>ArrayList</code>
     * @param department Department
     * @param startDate LocalDate
     * @param endDate LocalDate
     * @return ArrayList
     */
    public ArrayList<Appointment> getBookings (Department department, LocalDate startDate, LocalDate endDate) {
        ArrayList<Appointment> matches = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (
                appointment.getDepartment().equals(department)
                && appointment.getTimeslot().getDate().isAfter(startDate.minusDays(1))
                && appointment.getTimeslot().getDate().isBefore(endDate.plusDays(1))
                && !matches.contains(appointment)
            )
                matches.add(matches.size(), appointment);
        }
        return matches;
    }


    /**
     * Returns appointments booked with a <code>provider</code> between <code>startDate</code> and <code>endDate</code>
     * inclusive. If none exist returns an empty <code>ArrayList</code>
     * @param provider Provider
     * @param startDate LocalDate
     * @param endDate LocalDate
     * @return ArrayList
     */
    public ArrayList<Appointment> getBookings (Provider provider, LocalDate startDate, LocalDate endDate) {
        ArrayList<Appointment> matches = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (
                appointment.getProvider().equals(provider)
                    && appointment.getTimeslot().getDate().isAfter(startDate.minusDays(1))
                    && appointment.getTimeslot().getDate().isBefore(endDate.plusDays(1))
                    && !matches.contains(appointment)
            )
                matches.add(matches.size(), appointment);
        }
        return matches;
    }


    /**
     * Returns appointments booked with a <code>patient</code> between <code>startDate</code> and <code>endDate</code>
     * inclusive. If none exist returns an empty <code>ArrayList</code>
     * @param patient Patient
     * @param startDate LocalDate
     * @param endDate LocalDate
     * @return ArrayList
     */
    public ArrayList<Appointment> getBookings (Patient patient, LocalDate startDate, LocalDate endDate) {
        ArrayList<Appointment> matches = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (
                appointment.getPatient().equals(patient)
                    && appointment.getTimeslot().getDate().isAfter(startDate.minusDays(1))
                    && appointment.getTimeslot().getDate().isBefore(endDate.plusDays(1))
                    && !matches.contains(appointment)
            )
                matches.add(matches.size(), appointment);
        }
        return matches;
    }


    public ArrayList<Appointment> getBookings (ExamRoom examRoom, LocalDate startDate, LocalDate endDate) {
        ArrayList<Appointment> matches = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (
                appointment.getExamRoom().equals(examRoom)
                    && appointment.getTimeslot().getDate().isAfter(startDate.minusDays(1))
                    && appointment.getTimeslot().getDate().isBefore(endDate.plusDays(1))
                    && !matches.contains(appointment)
            )
                matches.add(matches.size(), appointment);
        }
        return matches;
    }


    /**
     * Adds a new appointment to the catalog if it does not exist. Consistency, Isolation and Durability are maintained
     * with <code>AppointmentRequest</code>. To assure ACID <code>add</code> returns <code>false</code> if the operation
     * fails. True otherwise
     *
     * @param appointment
     * @return boolean
     */
    public boolean add (Appointment appointment) {
        if (!appointments.contains(appointment)) {
            return appointments.add(appointment);
        }
        return true;
    }


    /**
     * This method is a helper when deleting/disabling a <code>Patient</code> instance.  This should really a method in
     * <code>Patient</code>. BUt appointments are canceled in <code>Appointments</code>. If all the future appointments for
     * a patient have been cancelled returns true otherwisw false. All
     * @param patient Patient
     * @return boolean
     *
     * Precondition
     * -------------
     * None
     *
     * PostCondition
     * --------------
     * All the patient's appointments after the current time period with <code>AppointmentStatus.BOOKED</code> are changed
     * to <code>AppointmentStatus.CANCELLED</code>
     */
    public boolean cancelAppointments (Patient patient) {
        boolean successfulCancellation = true;
        while (appointments.iterator().hasNext() && successfulCancellation) {
            Appointment appointment = appointments.iterator().next();
            if (appointment.getPatient().equals(patient) && appointment.getTimeslot().getDate().isAfter(LocalDate.now())) {
                successfulCancellation = appointments.remove(appointment);
            }
        }
        return successfulCancellation;
    }


    public ArrayList<Appointment> filter (Predicate<Appointment> predicate) {
        ArrayList<Appointment> matches = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (predicate.test(appointment) && !matches.contains(appointment))
                matches.add(matches.size(), appointment);
        }
        return matches;
    }
} // end class Appointments
