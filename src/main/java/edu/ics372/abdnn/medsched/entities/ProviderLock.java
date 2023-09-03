package edu.ics372.abdnn.medsched.entities;

public class ProviderLock {
    DateTimeslot duration;

    public ProviderLock (DateTimeslot dateTimeslot) {
        this.duration = dateTimeslot;
    } //

    public DateTimeslot getDuration () {
        return duration;
    }
}
