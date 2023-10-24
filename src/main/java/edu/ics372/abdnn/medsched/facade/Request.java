package edu.ics372.abdnn.medsched.facade;

import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.entities.*;
import edu.ics372.abdnn.medsched.core.visitors.*;

public class Request {

    public static boolean patientRequest (String firstname, String lastname, String email, String password) {
        return Patients.INSTANCE.add(new Patient(SerialNumberGenerator.INSTANCE.patientId(), firstname, lastname));
    }
}
