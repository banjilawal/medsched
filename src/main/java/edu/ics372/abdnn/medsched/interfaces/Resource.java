package edu.ics372.abdnn.medsched.interfaces;

import edu.ics372.abdnn.medsched.entities.Period;
import edu.ics372.abdnn.medsched.enums.Availability;

import java.util.Iterator;

public interface Resource {
    public Availability getAvailabilty ();
    public Iterator<Period> getOpenings ();
    public void setAvailabilty (Availability availability);
    public void book (Period period);
} // end interface Resource
