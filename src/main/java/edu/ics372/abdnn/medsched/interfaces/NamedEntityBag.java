package edu.ics372.abdnn.medsched.interfaces;

public interface NamedEntityBag<E> extends EntityBag<E> {
    public E searchName (String name);
} // end interface NamedEntityBag
