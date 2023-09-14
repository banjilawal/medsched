package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.Person;
import edu.ics372.abdnn.medsched.enums.Availability;
import edu.ics372.abdnn.medsched.singletons.Calendar;
import edu.ics372.abdnn.medsched.singletons.ExamRooms;
import edu.ics372.abdnn.medsched.singletons.Providers;
import edu.ics372.abdnn.medsched.visitors.SerialNumberGenerator;

public class Patient extends Person  {


    public Patient (int id, String firstname, String lastname) {
        super(id, firstname, lastname);
    }

    public boolean areOpen (Period period, Provider provider) {
        return Calendar.INSTANCE.periodIsOpen(period) && Providers.INSTANCE.isOpen(period, provider);
    }

    public void lockProvider (Provider provider) { }
    public void lockPeriod (Period period) {}
    public void lockExamRoom (ExamRoom examRoom) {}

    public boolean book (Department department, Provider provider, Period period) {
        if (areOpen(period, provider)) {
            lockProvider(provider);
            lockPeriod(period);
            ExamRoom examRoom = ExamRooms.INSTANCE.firstOpen(period);
            if (examRoom != null) {
                lockExamRoom(examRoom);
                int id = SerialNumberGenerator.INSTANCE.appointmentId();
                Appointment appointment = new Appointment(id, ("" + id), provider,examRoom,period,department, this);
                return true;
            }
        }
        return false;
    }

} // end class Patient
