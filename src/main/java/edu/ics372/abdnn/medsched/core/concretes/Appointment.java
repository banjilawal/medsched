package edu.ics372.abdnn.medsched.core.concretes;

import edu.ics372.abdnn.medsched.core.abstracts.*;
import edu.ics372.abdnn.medsched.core.enums.*;
import edu.ics372.abdnn.medsched.core.exceptions.*;
import edu.ics372.abdnn.medsched.core.global.*;

import java.time.*;
import java.util.*;

public class Appointment extends Meeting {
    private AppointmentStatus status;
    private final Department department;
    private final Patient patient;
    private final LocalTime lateArrivalThreshold;
    private final LocalTime expectedCheckInTime;
    private final LocalTime expectedCheckOutTime;
    private LocalTime actualCheckInTime;
    private LocalTime actualCheckOutTime;
    public LocalTime checkInTime;
    public LocalTime checkOutTime;



    public Appointment (
            int id,
            Provider provider,
            ExamRoom examRoom,
            Timeslot timeSlot,
            Department department,
            Patient patient
    ) {
        super(id, provider, examRoom, timeSlot);
        this.department = department;
        this.patient= patient;
        this.status = AppointmentStatus.BOOKED;
        this.expectedCheckInTime = timeSlot.getStartTime().minusMinutes(Constant.APPOINTMENT_SWITCH_OVER_TIME);
        this.expectedCheckOutTime = timeSlot.getEndTime().minusMinutes(Constant.APPOINTMENT_SWITCH_OVER_TIME);
        this.lateArrivalThreshold = timeSlot.getStartTime().plusMinutes(Constant.LATE_MINUTES_THRESHOLD);
        this.checkInTime = null;
        this.checkOutTime = null;
        this.actualCheckInTime = null;
        this.actualCheckOutTime = null;
    }


    public Patient getPatient () {
        return patient;
    }

    public Department getDepartment() {
        return department;
    }

    public Provider getProvider () {
        return (Provider) getHost();
    }


    public ExamRoom getExamRoom () {
        return (ExamRoom) getLocation();
    }


    public AppointmentStatus getStatus () {
        return status;
    }

    public LocalTime getLateArrivalThreshold () {
        return lateArrivalThreshold;
    }

    public LocalTime getExpectedCheckInTime () {
        return expectedCheckInTime;
    }

    public LocalTime getExpectedCheckOutTime () {
        return expectedCheckOutTime;
    }

    public LocalTime getActualCheckInTime () {
        return actualCheckInTime;
    }

    public LocalTime getActualCheckOutTime () {
        return actualCheckOutTime;
    }


    public void setActualCheckInTime (LocalTime actualCheckInTime) {
        this.actualCheckInTime = actualCheckInTime;
        if (actualCheckInTime.isAfter(this.lateArrivalThreshold)) {
            this.status = AppointmentStatus.CANCELLED;
        }
        else {
            this.status = AppointmentStatus.IN_PROGRESS;
        }
    }

    public void setActualCheckOutTime (LocalTime actualCheckOutTime) {
        this.actualCheckOutTime = actualCheckOutTime;
        completed();
    }


    public void setStatus (AppointmentStatus status) throws AppointStatusException {
        if (!status.equals(AppointmentStatus.IN_PROGRESS) && this.status.equals(AppointmentStatus.IN_PROGRESS)) {
            throw new AppointStatusException("Cannot change the status of an appointment in progress before it's completed");
        }
        if (!status.equals(AppointmentStatus.CANCELLED) && this.status.equals(AppointmentStatus.BOOKED)) {
            throw new AppointStatusException("COnly booked, late or no-show appointments can be cancelled");
        }
        this.status = status;
    }

    

    public void setCheckInTime (LocalTime checkInTime) {
        this.checkInTime = checkInTime;
        if (isLateCheckIn()) {
            checkOutTime = checkInTime;
            status = AppointmentStatus.NO_SHOW;
        }
        else status = AppointmentStatus.IN_PROGRESS;
    }


    public void setCheckOutTime (LocalTime checkOutTime) {
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
                && patient.equals(appointment.getPatient());
            // expectedCheckinTime, expectedCheckOutTime and lateArrivalThreshold are derived from timeslot.startTime()
            // we don't need them for equality check
//                && expectedCheckInTime.equals(appointment.getExpectedCheckInTime())
//                && expectedCheckOutTime.equals(appointment.getExpectedCheckInTime())
        }
        return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), department, patient, status, expectedCheckInTime, expectedCheckOutTime);
    }

    @Override
    public String toString () {
        return super.toString()
            + " department: " + department.getName()
            + " patient:" +  patient.getFirstname() + " " + patient.getLastname()
            + " provider:" + getHost().getFirstname() + " " + getHost().getLastname()
            + " date:" + getTimeslot().getDate().toString()
            + " checkin time:" + checkInTime.toString();
    }


    private String printLocalTime (LocalTime localTime) {
        if (localTime == null) return "";
        return localTime.toString();
    }

    private boolean isLateCheckIn () {
        LocalTime time = getTimeslot().getStartTime().plusMinutes(Constant.LATE_MINUTES_THRESHOLD);
        return checkInTime.isAfter(time);
    }
} // end class
