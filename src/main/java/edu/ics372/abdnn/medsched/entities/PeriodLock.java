package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.LockEntity;

import java.util.Date;

public class PeriodLock extends LockEntity {
    private Period period;

    public PeriodLock (Period period) { this.period = period; } //

    public Period getPeriod () { return period; }
}
