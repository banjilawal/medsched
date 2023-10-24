package edu.ics372.abdnn.medsched.core.abstracts;

public abstract class AnonymousEntity {
    @Override
    public String toString () {
        return getClass().getSimpleName();
    }
}
