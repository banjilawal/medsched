package edu.ics372.abdnn.medsched.interfaces;

import edu.ics372.abdnn.medsched.entities.Duration;
import edu.ics372.abdnn.medsched.entities.DurationLock;
import edu.ics372.abdnn.medsched.entities.ScheduleDate;
import edu.ics372.abdnn.medsched.entities.Timeslot;
import edu.ics372.abdnn.medsched.enums.Availabilty;

import java.util.Date;

public interface Resource {
    public Availabilty getAvailabilty ();
    public void setAvailabilty (Availabilty availabilty);
    public void book (ScheduleDate scheduleDate, Timeslot timeslot);
    public void book (Date date, Duration duration);
} // end interface Resource
