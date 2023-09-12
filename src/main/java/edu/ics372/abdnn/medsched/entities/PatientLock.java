package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.LockEntity;
import edu.ics372.abdnn.medsched.abstracts.Person;

public class PatientLock extends LockEntity {
    private Patient patient;

    public PatientLock getPatientLock () {
        return patientLock;
    }

   public void  () { this.lockOwner = lockOwner; }

    public Person getLockOwner () { return lockOwner; }
} // end class OwnerLock
