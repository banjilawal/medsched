package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.Meeting;
import edu.ics372.abdnn.medsched.abstracts.OwnerLock;

import java.util.Objects;

public class OldAppointment extends Meeting {
    private final Department department;
    private final Patient patient;
    private final OwnerLock patientLock;


    public OldAppointment (
            int id,
            String name,
            Provider provider,
            ExamRoom examRoom,
            Period period,
            Department department,
            Patient patient
    ) {
        super(id, name, provider, examRoom, period);
        this.department = department;
        this.patient = patient;
        this.patientLock = new OwnerLock(patient);
    } //

    public Department getDepartment () { return department; }

    public Patient getPatient () {
        return patient;
    }

    public OwnerLock getPatientLock () { return patientLock; }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof OldAppointment appointment) {
            return super.equals(appointment)
                && department.equals(getDepartment())
                && patient.equals(appointment.getPatient());
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