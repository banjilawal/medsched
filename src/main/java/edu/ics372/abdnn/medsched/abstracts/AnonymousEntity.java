package edu.ics372.abdnn.medsched.abstracts;

public abstract class AnonymousEntity {
    @Override
    public String toString () {
        return getClass().getSimpleName();
    }
}
