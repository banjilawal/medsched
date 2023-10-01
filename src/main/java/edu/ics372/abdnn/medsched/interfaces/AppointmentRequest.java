package edu.ics372.abdnn.medsched.interfaces;

import edu.ics372.abdnn.medsched.abstracts.*;
import edu.ics372.abdnn.medsched.catalogs.*;
import edu.ics372.abdnn.medsched.entities.*;
import edu.ics372.abdnn.medsched.enums.*;
import edu.ics372.abdnn.medsched.reservations.*;
import edu.ics372.abdnn.medsched.visitors.*;

public class AppointmentRequest extends AnonymousEntity {
    private Department department;
    private Provider provider;
    private ExamRoom examRoom;
    private Patient patient;
    private Period period;

    public AppointmentRequest (Department department, Provider provider, ExamRoom examRoom, Patient patient, Period period) {
        this.department = department;
        this.provider = provider;
        this.examRoom = examRoom;
        this.patient = patient;
        this.period = period;
    }


    public boolean request () {
        if (requestRoom())
            return ppointments.INSTANCE.add(
                new Appointment(SerialNumberGenerator.INSTANCE.appointmentId(), provider, examRoom, period, department, patient)
            );
        return false;
    }


    public boolean requestRoom () {
        if (!RoomReservations.INSTANCE.reservationExists(department, period, examRoom))
            return RoomReservations.INSTANCE.add(department, period, examRoom);
        return false;
    }
//    private Patient patient;
//    private Department department;
//    private Period period;
//    private Provider provider;
//
//    public AppointmentRequest (Patient patient, Department department) {
//        this(patient, department, null, null);
//    }
//
//    public AppointmentRequest (Patient patient, Department department, Day day) {
//        this(patient, department, day, null);
//    }
//
//    public AppointmentRequest (Patient patient, Department department, Provider provider) {
//        this(patient, department, null, provider);
//    }
//
//    public AppointmentRequest (Patient patient, Department department, Day day, Provider provider) {
//        super();
//        this.patient = patient;
//        this.department = department;
//        this.day = day;
//        this.provider = provider;
//    } // close constructor
//
//    public Patient getPatient () { return patient; }
//
//    public Department getDepartment () { return  department; }
//
//    public Day getDateTimeslot () { return day; }
//
//    public Provider getProvider () { return provider; }

} // end class AppointmentRequest
