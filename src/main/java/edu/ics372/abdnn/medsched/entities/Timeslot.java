package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.enums.Availability;
import edu.ics372.abdnn.medsched.interfaces.Identified;
import edu.ics372.abdnn.medsched.interfaces.Named;

import java.time.LocalTime;
import java.util.Objects;

public class Timeslot extends Duration implements Identified, Named {
    private int id;
    private String name;
    private Availability availability;


    public Timeslot (int id, String name, LocalTime startTime, LocalTime endTime) {
        super(startTime, endTime);
        this.id = id;
        this.name = name;
        this.availability = Availability.OPEN;
    } //


    @Override
    public int getId () { return id; }

    @Override
    public String getName () { return name; }


    public Availability getAvailabilty () { return availability; }

    public void setAvailabilty (Availability availability) { this.availability = availability; }


    @Override
    public void setId (int id) { this.id = id; }

    @Override
    public void setName (String name) { this.name = name; }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Timeslot timeslot) {
            return super.equals(timeslot)
                && id == timeslot.getId()
                && availability == timeslot.getAvailabilty()
                && name.equalsIgnoreCase(timeslot.getName());
        }
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), id, name, availability);
    }

    @Override
    public String toString () {
        return super.toString() + " id:" + id + " name:" + name + " availabe:" + availability.toString();
    }
} // end class Timeslot
