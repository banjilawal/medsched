package edu.ics372.abdnn.medsched.interfaces;

import edu.ics372.abdnn.medsched.entities.Appointment;
import edu.ics372.abdnn.medsched.entities.Department;
import edu.ics372.abdnn.medsched.entities.Period;
import edu.ics372.abdnn.medsched.entities.Provider;

public interface Request {
    public boolean book (Department department, Provider provider, Period period);
    public void canel (Appointment appointment);

    public boolean bookEarliestAvailable (Department department);
} // end interface Request
