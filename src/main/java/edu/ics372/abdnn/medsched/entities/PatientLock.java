package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.LockEntity;
import edu.ics372.abdnn.medsched.abstracts.Person;

public class PatientLock extends LockEntity {
    private final Patient patient;

    public PatientLock (Patient patient) {
        super();
        this.patient = patient;
    }

    public Patient getLockOwner () { return patient; }
} // end class OwnerLock
