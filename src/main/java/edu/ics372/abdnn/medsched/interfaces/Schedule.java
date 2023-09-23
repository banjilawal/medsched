package edu.ics372.abdnn.medsched.interfaces;

import edu.ics372.abdnn.medsched.entities.*;

public interface Schedule {
    public void book (Department department, Provider provider, Patient patient, Period period);
    public void  cancel (Patient patient, Appointment appointment);
}
