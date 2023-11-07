package edu.ics372.abdnn.medsched.core.entities;

import edu.ics372.abdnn.medsched.core.abstracts.*;
import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.global.*;

import java.time.*;
import java.util.*;
import java.util.function.*;

public class Examroom extends Room {

    public Examroom (int id, String name) {
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
