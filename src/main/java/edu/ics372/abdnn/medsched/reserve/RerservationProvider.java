package edu.ics372.abdnn.medsched.reserve;

import edu.ics372.abdnn.medsched.entities.Period;
import edu.ics372.abdnn.medsched.entities.Provider;

import java.util.*;

public class RerservationProvider extends Rerservation {
    private final Provider provider;

    public RerservationProvider (int id, Period period, Provider provider) {
        super(id, period);
        this.provider = provider;;
    }


    public Provider getProvider () {
        return provider;
    }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof RerservationProvider reservation) {
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
