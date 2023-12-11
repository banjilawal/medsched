package edu.ics372.abdnn.medsched.facade.request;

import edu.ics372.abdnn.medsched.core.entity.*;

public class CreateAppointmentRequest extends Request {
    private final Department department;
    private final Provider provider;
    private final ExamRoom examRoom;
    private final Patient patient;
    private final Timeslot timeSlot;


    public CreateAppointmentRequest (Department department, Provider provider, ExamRoom examRoom, Patient patient, Timeslot timeSlot) {
        this.department = department;
        this.provider = provider;
        this.examRoom = examRoom;
        this.patient = patient;
        this.timeSlot = timeSlot;
    }

    public Department getDepartment () {
        return department;
    }

    public Provider getProvider () {
        return provider;
    }

    public ExamRoom getExamRoom () {
        return examRoom;
    }

    public Patient getPatient () {
        return patient;
    }

    public Timeslot getTimeSlot () {
        return timeSlot;
    }
} // end class CreateAppointmentRequest
