package edu.ics372.abdnn.medsched.core.reservations;

import edu.ics372.abdnn.medsched.core.abstracts.*;
import edu.ics372.abdnn.medsched.core.entities.*;
import edu.ics372.abdnn.medsched.core.enums.*;

import java.util.*;

public abstract class Reservation extends AnonymousEntity { // Entity  {
    Department department;
    private final Timeslot timeSlot;

    public Reservation (Department department, Timeslot timeSlot) {
        super();
        this.department = department;
        this.timeSlot = timeSlot;
    }

    public Department getDepartment () {
        return department;
    }

    public Timeslot getTimeSlot () {
        return timeSlot;
    }



    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Reservation reservation) {
            return super.equals(reservation)
                && department.equals(reservation.getDepartment())
                && timeSlot.equals(reservation.getTimeSlot());
        }
        return false;
    }


    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), department, timeSlot);
    }


    @Override
    public String toString () {
        return super.toString()  +  "department:" + department.getName() +   " timeslot:" + timeSlot.toString();
    }
} // end class Reservation
