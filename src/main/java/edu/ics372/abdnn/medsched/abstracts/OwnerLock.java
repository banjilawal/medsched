package edu.ics372.abdnn.medsched.abstracts;

public class OwnerLock {
    private final Person lockOwner;

    public OwnerLock (Person lockOwner) { this.lockOwner = lockOwner; }

    public Person getLockOwner () { return lockOwner; }
} // end class OwnerLock
