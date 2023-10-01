package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.*;
import edu.ics372.abdnn.medsched.catalogs.*;
import edu.ics372.abdnn.medsched.global.*;
import edu.ics372.abdnn.medsched.interfaces.*;
import edu.ics372.abdnn.medsched.reservations.*;

import java.time.*;
import java.util.*;
import java.util.function.*;

public class ExamRoom extends Room implements Resource, Response  {

    public ExamRoom (int id, String name) {
        super(id, name, Constant.EXAM_ROOM_CAPACITY);
    }


    public boolean inUse (Period period) {
        return Appointments.INSTANCE.search(this, period) == null
            && RoomReservations.INSTANCE.search(this, period) == null;
    }


    public Iterator<Appointment> getBookings (LocalDate startDate, LocalDate endDate) {
        Predicate<Appointment> predicate = appointment -> {
            return appointment.getExamRoom().equals(this)
                && appointment.getPeriod().getDate().isAfter(startDate.minusDays(1))
                && appointment.getPeriod().getDate().isBefore(endDate.plusDays(1));
        };
        return Appointments.INSTANCE.filter(predicate);
    }
} // end class ExamRoom
