package edu.ics372.abdnn.medsched.interfaces;

import edu.ics372.abdnn.medsched.abstracts.AnonymousEntity;
import edu.ics372.abdnn.medsched.entities.ScheduleDate;
import edu.ics372.abdnn.medsched.entities.Department;
import edu.ics372.abdnn.medsched.entities.Patient;
import edu.ics372.abdnn.medsched.entities.Provider;

public class AppointmentRequest extends AnonymousEntity {
    private Patient patient;
    private Department department;
    private ScheduleDate scheduleDate;
    private Provider provider;

    public AppointmentRequest (Patient patient, Department department) {
        this(patient, department, null, null);
    }

    public AppointmentRequest (Patient patient, Department department, ScheduleDate scheduleDate) {
        this(patient, department, scheduleDate, null);
    }

    public AppointmentRequest (Patient patient, Department department, Provider provider) {
        this(patient, department, null, provider);
    }

    public AppointmentRequest (Patient patient, Department department, ScheduleDate scheduleDate, Provider provider) {
        super();
        this.patient = patient;
        this.department = department;
        this.scheduleDate = scheduleDate;
        this.provider = provider;
    } // close constructor

    public Patient getPatient () { return patient; }

    public Department getDepartment () { return  department; }

    public ScheduleDate getDateTimeslot () { return scheduleDate; }

    public Provider getProvider () { return provider; }

} // end class AppointmentRequest
