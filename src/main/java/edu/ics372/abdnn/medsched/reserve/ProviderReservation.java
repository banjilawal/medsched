package edu.ics372.abdnn.medsched.reserve;

import edu.ics372.abdnn.medsched.entities.Period;
import edu.ics372.abdnn.medsched.entities.Provider;
import edu.ics372.abdnn.medsched.catalogs.Providers;

import java.util.*;

public class ProviderReservation extends Reservation {
    private final int providerId;

    public ProviderReservation (int id, Period period, Provider provider) {
        super(id, period);
        this.providerId = provider.getId();;
    }

    public int getProviderId () {
        return providerId;
    }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof ProviderReservation providerReservation) {
            return super.equals(providerReservation) && providerId == providerReservation.getProviderId();
        }
        return false;
    }


    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), providerId);
    }

    public Provider getProvider () {
        return Providers.INSTANCE.search(providerId);
    }


    @Override
    public String toString () {
        return super.toString()
            + " provider:" + providerId
            + " " + getProvider().getFirstname()
            + " " + getProvider().getLastname();
    }
} // end class ExamRoomReservation
