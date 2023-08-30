package edu.ics372.abdnn.medsched.interfaces;

import java.util.Iterator;

public interface NamedEntityBagWrapper<E> extends BagWrapper<E> {

    public E search (String name);
    public boolean nameExists (String name);

} // end interface BagWrapper
