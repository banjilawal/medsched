package edu.ics372.abdnn.medsched.interfaces;

import edu.ics372.abdnn.medsched.abstracts.AnonymousEntity;
import edu.ics372.abdnn.medsched.entities.DateTimeslot;
import edu.ics372.abdnn.medsched.entities.Department;
import edu.ics372.abdnn.medsched.entities.Patient;
import edu.ics372.abdnn.medsched.entities.Provider;
import edu.ics372.abdnn.medsched.services.Scheduler;

public class AppointmentRequest extends AnonymousEntity {
    private Patient patient;
    private Department department;
    private DateTimeslot dateTimeslot;
    private Provider provider;

    public AppointmentRequest (Patient patient, Department department) {
        this(patient, department, null, null);
    }

    public AppointmentRequest (Patient patient, Department department, DateTimeslot dateTimeslot) {
        this(patient, department, dateTimeslot, null);
    }

    public AppointmentRequest (Patient patient, Department department, Provider provider) {
        this(patient, department, null, provider);
    }

    public AppointmentRequest (Patient patient, Department department, DateTimeslot dateTimeslot, Provider provider) {
        super();
        this.patient = patient;
        this.department = department;
        this.dateTimeslot = dateTimeslot;
        this.provider = provider;
    } // close constructor

    public Patient getPatient () { return patient; }

    public Department getDepartment () { return  department; }

    public DateTimeslot getDateTimeslot () { return  dateTimeslot; }

    public Provider getProvider () { return provider; }

} // end class AppointmentRequest
