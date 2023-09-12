package edu.ics372.abdnn.medsched.interfaces;

import edu.ics372.abdnn.medsched.entities.PeriodLock;
import edu.ics372.abdnn.medsched.enums.Availability;

import java.util.Date;

public interface DurationLockable {
    public Availability getAvailabilty ();
    public PeriodLock getDurationLock ();
    public void book (Date date);
    public void cancel ();
;} // end DurationLockable
