package edu.ics372.abdnn.medsched.core.entities;

import edu.ics372.abdnn.medsched.core.abstracts.*;
import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.enums.*;

public class Patient extends Person { //implements Request, ServiceRequest {

    public Patient (int id, String firstname, String lastname) {
        super(id, firstname, lastname);
    }


    public boolean delete () {
        if (Appointments.INSTANCE.cancelAppointments(this)) {
            setStatus(Status.DELETED);
            return true;
        }
        return false;
    }



    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Patient patient) {
            return super.equals(patient);
        }
        return false;
    }
} // end class Patient
