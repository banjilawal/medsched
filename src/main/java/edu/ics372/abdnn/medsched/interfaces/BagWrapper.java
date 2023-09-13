package edu.ics372.abdnn.medsched.interfaces;

import edu.ics372.abdnn.medsched.abstracts.Entity;
import edu.ics372.abdnn.medsched.containers.Bag;

import java.util.Iterator;
import java.util.function.Predicate;

public interface BagWrapper<T> {
    public int size ();
    public Bag<T> getBag ();
    public void add (T t);
    public T pop (int id);
    public T pop (String name);
    public T peek (int id);
    public T peek (String name);
    public void remove (int id);

    public void remove (String name);
    public Iterator<T> iterator ();
    public Iterator<T> filter (Predicate<T> predicate);
} // end interface BagWrapper
