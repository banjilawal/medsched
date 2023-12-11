package edu.ics372.abdnn.medsched.core.concretes;

import edu.ics372.abdnn.medsched.core.abstracts.*;
import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.catalogs.reservations.*;
import edu.ics372.abdnn.medsched.core.global.*;
import edu.ics372.abdnn.medsched.core.interfaces.*;

import java.time.*;
import java.util.*;

public class ExamRoom extends Room implements Openings {

    public ExamRoom (int id, String name) {
        super(id, name, Constant.EXAM_ROOM_CAPACITY);
    }


    public boolean inUse (Timeslot timeSlot) {
        return Appointments.INSTANCE.search(this, timeSlot) == null
            && RoomReservations.INSTANCE.search(this, timeSlot) == null;
    }


    @Override
    public ArrayList<Timeslot> getOpenings (LocalDate startDate, LocalDate endDate) {
        ArrayList<Timeslot> timeslots = Timeslot.getTimeslots(startDate, endDate, Constant.OPENING_TIME, Constant.CLOSING_TIME);
        for (Appointment appointment : Appointments.INSTANCE.getBookings(this, startDate, endDate)) {
            Timeslot appointmentTimeslot = appointment.getTimeslot();
            if (timeslots.contains(appointmentTimeslot)) {
                timeslots.remove(timeslots.indexOf(appointmentTimeslot));
            }
        }
        return timeslots;
    }
} // end class ExamRoom
