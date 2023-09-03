package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.Meeting;

import java.util.Objects;

public class Consultation extends Meeting {

    private Department department;
    private Patient patient;


    public Consultation (int id, String name, Department department, Provider provider, ExamRoom examRoom, DateTimeslot dateTime, Patient patient) {
        super(id, name, provider, examRoom, dateTime);
        this.department = department;
        this.patient = patient;
    } //

    public Department getDepartment () { return department; }

    public Patient getPatient () {
        return patient;
    }

    public void setDepartment (Department department) { this.department = department; }

    public void setPatient (Patient patient) { this.patient = patient; }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Consultation appointment) {
            return super.equals(appointment) && department.equals(getDepartment()) && patient.equals(appointment.getPatient());
        }
        return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), department, patient);
    }

    @Override
    public String toString () {
        return super.toString() + " department: " + department.getName() + patient.toString();
    }

} // end class
