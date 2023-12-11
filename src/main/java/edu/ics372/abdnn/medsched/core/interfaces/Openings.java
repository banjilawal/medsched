package edu.ics372.abdnn.medsched.core.interfaces;

import edu.ics372.abdnn.medsched.core.entity.*;

import java.time.*;
import java.util.*;

public interface Openings {
    public ArrayList<Timeslot> getOpenings (LocalDate startDate, LocalDate endDate);
} // end interface Openings
