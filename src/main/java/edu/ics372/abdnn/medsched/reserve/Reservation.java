package edu.ics372.abdnn.medsched.reserve;

import edu.ics372.abdnn.medsched.abstracts.Entity;
import edu.ics372.abdnn.medsched.entities.Period;

import java.util.Objects;

public abstract class Reservation extends Entity  {
    private final Period period;

    public Reservation (int id, Period period) {
        super(id);
        this.period = period;
    }

    public Period getPeriod () {
        return period;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Reservation reservation) {
            return super.equals(reservation)  && period.equals(reservation.getPeriod());
        }
        return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), period);
    }


    @Override
    public String toString () {
        return super.toString()  + " period:" + period.toString();
    }
} // end class Reservation
