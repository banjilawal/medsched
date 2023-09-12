package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.LockEntity;
import edu.ics372.abdnn.medsched.abstracts.OwnerLock;

import java.util.Date;

public class PeriodLock extends LockEntity {
    private final Period period;
    private final OwnerLock lockOwner;

    public PeriodLock (Period period, OwnerLock lockOwner) {
        this.period = period;
        this.lockOwner = lockOwner;
    } //

    public Period getPeriod () { return period; }

    public OwnerLock getLockOwner () { return lockOwner; }
}
