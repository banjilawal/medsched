package edu.ics372.abdnn.medsched.core.reservations;

import edu.ics372.abdnn.medsched.core.entities.*;

import java.util.*;

public class ProviderReservation extends Rerservation {
    private final Provider provider;

    public ProviderReservation (Department department, Period period, Provider provider) {
        super(department, period);
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
        return Objects.hash(super.hashCode(), providerId);
    }


    @Override
    public String toString () {
        return super.toString()
            + " provider:" + providerId
            + " " + getProvider().getFirstname()
            + " " + getProvider().getLastname();
    }
} // end class ExamRoomReservation