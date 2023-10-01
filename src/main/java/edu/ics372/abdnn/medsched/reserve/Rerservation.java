package edu.ics372.abdnn.medsched.reserve;

import edu.ics372.abdnn.medsched.abstracts.*;
import edu.ics372.abdnn.medsched.entities.*;
import edu.ics372.abdnn.medsched.enums.*;

import java.util.*;

public abstract class Rerservation extends AnonymousEntity { // Entity  {
    Department department;
    private final Period period;
    private ReservationStatus status;

    public Rerservation (Department department, Period period) { // (int id, Department department, Period period) {
//        super(id);
        super();
        this.status = ReservationStatus.ACTIVE;
        this.department = department;
        this.period = period;
    }

    public Department getDepartment () {
        return department;
    }

    public Period getPeriod () {
        return period;
    }


    public ReservationStatus getStatus () {
        return status;
    }


    public void setStatus (ReservationStatus status) {
        this.status = status;
    }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Rerservation rerservation) {
            return super.equals(rerservation)
                && department.equals(rerservation.getDepartment())
                && period.equals(rerservation.getPeriod())
                && status.equals(rerservation.getStatus());
        }
        return false;
    }


    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), department, period);
    }


    @Override
    public String toString () {
        return super.toString()  + " period:" + period.toString();
    }
} // end class Reservation
