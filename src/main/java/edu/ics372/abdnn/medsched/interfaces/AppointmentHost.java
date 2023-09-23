package edu.ics372.abdnn.medsched.interfaces;

import edu.ics372.abdnn.medsched.entities.Provider;

public interface AppointmentHost {
    public Provider getProvider (int providerId);
    public void setProvider (Provider provider);
} // end interface AppointmentHost
