package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.*;
import edu.ics372.abdnn.medsched.reservations.*;
import edu.ics372.abdnn.medsched.reserve.*;

import java.util.*;
import java.util.function.*;

public class Patient extends Person { //implements Request, ServiceRequest {


    public Patient (int id, String firstname, String lastname) {
        super(id, firstname, lastname);
    }

    public Iterator<PatientReservation> getReservations () {
        Predicate<PatientReservation> predicate = patientReservation -> patientReservation.getPatientId() == getId();
        return PatientReservations.INSTANCE.filter(predicate);
    }
//
//    public boolean areOpen (Period period, Provider provider) {
//        return Calendar.INSTANCE.periodIsOpen(period) && Providers.INSTANCE.isOpen(period, provider);
//    }
//
//    public void lockProvider (Provider provider) { }
//    public void lockPeriod (Period period) {}
//    public void lockExamRoom (ExamRoom examRoom) {}
//
//    public boolean book (Department department, Provider provider, Period period) {
//        if (areOpen(period, provider)) {
//            lockProvider(provider);
//            lockPeriod(period);
//            ExamRoom examRoom = ExamRooms.INSTANCE.firstOpen(period);
//            if (examRoom != null) {
//                lockExamRoom(examRoom);
//                int id = SerialNumberGenerator.INSTANCE.appointmentId();
//                Appointment appointment = new Appointment(id, ("" + id), provider,examRoom,period,department, this);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public Appointment getAppointment (Period period) {
//        return Appointments.INSTANCE.search(this, period);
//
//    }
//
//    @Override
//    public void canel (Appointment appointment) {
//
//    }
//
//    @Override
//    public boolean bookEarliestAvailable (Department department) {
//        return false;
//    }

} // end class Patient
