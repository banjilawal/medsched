package edu.ics372.abdnn.medsched.core.reservation;

import edu.ics372.abdnn.medsched.core.entity.*;

import java.util.*;

public class ProviderReservation extends Reservation {
    private final Provider provider;

    public ProviderReservation (Department department, Timeslot timeSlot, Provider provider) {
        super(department, timeSlot);
        this.provider = provider;;
    }


    public Provider getProvider () {
        return provider;
    }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof ProviderReservation reservation) {
            return super.equals(reservation) && provider.equals(reservation.getProvider());
        }
        return false;
    }


    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), provider);
    }

    @Override
    public String toString () {
        return super.toString() + " provider:" + provider.getFirstname() + " " + provider.getLastname();
    }
} // end class ExamRoomReservation
