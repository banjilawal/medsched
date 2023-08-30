package edu.ics372.abdnn.medsched.interfaces;

import edu.ics372.abdnn.medsched.abstracts.Entity;

import java.util.Iterator;

public interface BagWrapper<E> {
    public void remove (int id);
    public void remove (E e);

    public E search (int id);

    public void add (E e);

    public Iterator<E> iterator ();

} // end interface BagWrapper
