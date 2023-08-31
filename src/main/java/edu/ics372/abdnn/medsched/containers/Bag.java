package edu.ics372.abdnn.medsched.containers;


import edu.ics372.abdnn.medsched.abstracts.Entity;
import edu.ics372.abdnn.medsched.abstracts.NamedEntity;
import edu.ics372.abdnn.medsched.global.Constant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public class Bag<E>  {
    private final ArrayList<E> contents;

    public Bag () {
        contents = new ArrayList<E>();
    } // close constructor

    public ArrayList<E> getContents () {
        return contents;
    }

    public int size () {
        return contents.size();
    } // close size

    public int indexOf (E e) {
        return contents.indexOf(e);
    } // close getIndex

    public E get(int index) {
        return contents.get(index);
    }

//    public boolean contains (E e) {
//        return (contents.contains(e));
//    }

    public E search (int id) {
        return search("", id);
    } // close search

    public E search (String name) {
        return search(name, Integer.MIN_VALUE);
    } // close search

    private E search (String name, int id) {
        if (!name.isBlank()) {
            for (E e : contents) {
                if (e instanceof NamedEntity ne && ne.getName().equalsIgnoreCase(name)) return e;
//                NamedEntity ne = (NamedEntity) e;
//                if (ne.getName().equalsIgnoreCase(name)) {
//                    return e;
//                }
            }
        }
        if (id >= Constant.MINIMUM_ENTITY_ID) {
            for (E e : contents) {
                if (e instanceof Entity et && et.getId() == id) return e;
//
//                })
//                NamedEntity ne = (NamedEntity) e;
//                if (ne.getId() == id) {
//                    return e;
//                }
            }
        }
        return null;
    } // close search

    public void add (E e) {
        if (!contents.contains(e)) contents.add(contents.size(), e);
    } // close add

    public boolean remove (int id) {
        return remove("", id);
    } // close remove

    public boolean remove (String name) {
        return remove(name, Integer.MIN_VALUE);
    } // close remove


    public E remove (E e) {
        return contents.remove(contents.indexOf(e));
    } // close remove

    private boolean remove (String name, int id) {
        E e = null;
        if (!name.isBlank()) {
            e = search(name);
        }
        if (id >= Constant.MINIMUM_ENTITY_ID ) {
            e = search(id);
        }
        if (e != null) {
            return contents.remove(e);
        }
        return false;
    } // close remove

    public Iterator<E> iterator () {
        return contents.iterator();
    }

    @Override
    public String toString () {
        String string = "";

        for (E e : contents) {
            string += "\n" + e.toString(); //namedEntity.getName() + " " + namedEntity.getId();
        }
        return string;
    } // close to String

    private String getClasName (E e) {
        return e.getClass().getSimpleName();
    }
} // end class Bag
