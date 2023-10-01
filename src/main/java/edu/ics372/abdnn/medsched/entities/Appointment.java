package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.*;
import edu.ics372.abdnn.medsched.enums.*;
import edu.ics372.abdnn.medsched.global.*;

import java.time.*;
import java.util.*;

public class Appointment extends Meeting {
    private AppointmentStatus status;
    private final Department department;
    private final Patient patient;
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
        this.department = department;
        this.patient= patient;
        this.status = AppointmentStatus.BOOKED;
        this.checkInTime = LocalTime.now();
        this.checkOutTime = LocalTime.now();
    } //


    public Patient getPatient () { return patient; }
    public Department getDepartment() { return department; }

    public LocalTime getCheckInTime () { return checkInTime; }
    public LocalTime getCheckOutTime () { return checkOutTime; }

    public ExamRoom getExamRoom () { return (ExamRoom) getLocation(); }

    public Provider getProvider () { return (Provider) getHost(); }

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
                && department.equals(appointment.getDepartment())
                && patient.equals(appointment.getPatient())
                && checkInTime.equals(appointment.getCheckInTime())
                && checkOutTime.equals(appointment.getCheckOutTime());
        }
        return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), department, patient, checkInTime, checkOutTime, status);
    }

    @Override
    public String toString () {
        return super.toString()
            + " department: " + department.getName()
            + " patient:" +  patient.getFirstname() + " " + patient.getLastname()
            + " provider:" + getHost().getFirstname() + " " + getHost().getLastname()
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
