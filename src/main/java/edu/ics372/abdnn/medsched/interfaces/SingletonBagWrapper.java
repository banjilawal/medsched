package edu.ics372.abdnn.medsched.interfaces;

import edu.ics372.abdnn.medsched.containers.Bag;

import java.util.Iterator;
import java.util.function.Predicate;

public interface SingletonBagWrapper<T> {
    public int size ();
    public void add (T t);
    public T pop (T t);
    public void remove (T t);
    public Iterator<T> iterator ();
    public Iterator<T> filter (Predicate<T> predicate);
} // end interface BagWrapper
