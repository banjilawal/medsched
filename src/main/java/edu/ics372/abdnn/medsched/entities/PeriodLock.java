package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.LockEntity;
import edu.ics372.abdnn.medsched.abstracts.OwnerLock;

import java.util.Date;

public class PeriodLock extends LockEntity {
    private final Period period;
    private final Provider provider;
    private final Patient patient;

    public PeriodLock (Period period, Provider provider,  Patient patient) {
        this.period = period;
        this.provider = provider;
        this.patient = patient;
    } //

    public Period getPeriod () { return period; }

    public Provider getProvider () { return provider; }

    public Patient getPatient () { return patient; }

    public boolean match (Period targetPeriod,  Provider targetProvider, Patient targetPatient) {
        return this.period.equals(targetPeriod)
            && this.provider.equals(targetProvider)
            && this.patient.equals(targetPatient);
    }
}
