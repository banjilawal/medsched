package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.Meeting;
import edu.ics372.abdnn.medsched.enums.AppointmentStatus;
import edu.ics372.abdnn.medsched.global.*;
import edu.ics372.abdnn.medsched.catalogs.Departments;
import edu.ics372.abdnn.medsched.catalogs.Patients;
import edu.ics372.abdnn.medsched.catalogs.Providers;

import java.time.*;
import java.util.Objects;

public class Appointment extends Meeting {
    private AppointmentStatus status;
    private final int departmentId;
    private final int patientId;
    public LocalTime checkInTime;
    public LocalTime checkOutTime;



    public Appointment (
            int id,
            Provider provider,
            ExamRoom examRoom,
            Period period,
            Department department,
            Patient patient
    ) {
        super(id, provider, examRoom, period);
        this.departmentId = department.getId();
        this.patientId = patient.getId();
        this.status = AppointmentStatus.BOOKED;
        this.checkInTime = LocalTime.now();
        this.checkOutTime = LocalTime.now();;
    } //


    public int getPatientId () { return patientId; }
    public int getDepartmentId () { return departmentId; }

    public LocalTime getCheckInTime () { return checkInTime; }
    public LocalTime getCheckOutTime () { return checkOutTime; }

    public Patient getPatient () { return Patients.INSTANCE.search(patientId); }
    public Provider getProvider () { return Providers.INSTANCE.search(getHostId()); }
    public Department getDepartment () { return Departments.INSTANCE.search(departmentId); }
    public AppointmentStatus getStatus () { return status; }


    public void checkIn (LocalTime checkInTime) {
        if (checkInTime == null)
            throw new IllegalArgumentException("Appointment 55: Cannot set checkinTime to null");

        this.checkInTime = checkInTime;
        if (isLateCheckIn()) {
            checkOutTime = checkInTime;
            status = AppointmentStatus.NO_SHOW;
        }
        else status = AppointmentStatus.IN_PROGRESS;
    }


    public void checkout (LocalTime checkOutTime) {
        if (checkOutTime == null)
            throw new IllegalArgumentException("Appointment 66: Cannot set checkOutTime to null");
        this.checkOutTime = checkOutTime;
        status = AppointmentStatus.COMPLETED;
    }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Appointment appointment) {
            return super.equals(appointment)
                && departmentId == appointment.getDepartmentId()
                && patientId == appointment.getPatientId()
                && checkInTime.equals(appointment.getCheckInTime())
                && checkOutTime.equals(appointment.getCheckOutTime());
        }
        return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), departmentId, patientId, departmentId, checkInTime, checkOutTime, status);
    }

    @Override
    public String toString () {
        return super.toString()
            + " department: " + getDepartment().toString()
            + " patient:" +  getPatient().toString()
            + " provider:" + getProvider().toString()
            + " checkin:" + printLocalTime(checkInTime)
            + " checkout:" + printLocalTime(checkOutTime);
    }

    private String printLocalTime (LocalTime localTime) {
        if (localTime == null) return "";
        return localTime.toString();
    }

    private boolean isLateCheckIn () {
        LocalTime time = getPeriod().getStartTime().plusMinutes(Constant.LATE_MINUTES_THRESHOLD);
        return checkInTime.isAfter(time);
    }
} // end class
