package edu.ics372.abdnn.medsched.interfaces;

import edu.ics372.abdnn.medsched.entities.Duration;
import edu.ics372.abdnn.medsched.entities.DurationLock;
import edu.ics372.abdnn.medsched.enums.Availabilty;

import java.util.Date;

public interface DurationLockable {
    public Availabilty getAvailabilty ();
    public DurationLock getDurationLock ();
    public void book (Date date);
    public void cancel ();
;} // end DurationLockable
