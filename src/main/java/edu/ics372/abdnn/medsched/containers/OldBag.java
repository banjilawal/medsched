package edu.ics372.abdnn.medsched.containers;

import edu.ics372.abdnn.medsched.abstracts.Entity;

import java.util.ArrayList;
import java.util.Iterator;

public class OldBag<E> {
    private ArrayList<E> contents;

    public OldBag () {
        this.contents = new ArrayList<E>();
    }

    public ArrayList<E> getContents () {
        return contents;
    }

    public int size () { return contents.size(); }


    public void addContents (ArrayList<E> contents) {
        for (E e : contents) {
            add(e);
        }
    } //

    public void add (E e) {
        if (!contents.contains(e))
            contents.add(contents.size(), e);
    } //

    public void removeContents (ArrayList<E> contents) {
        for (E e : contents) {
            if (e instanceof Entity entity) {
                remove(entity.getId());
            }
        }
    } //

    public boolean remove (E e) { return contents.remove(e); }

    public void remove (int id) {
        E e = search(id);
        if (e != null) {
            int arrayIndex = contents.indexOf(e);
            contents.remove(arrayIndex);
        }
    } //


    public boolean contains (E e) {
        return contents.contains(e);
    }

    public E search (int id) {
        for (E e : contents) {
            if (e instanceof Entity entity) {
                if (entity.getId() == id) return e;
            }
        }
        return null;
    } //

//    public ArrayList<String> getNames () {
//        ArrayList<String> names = new ArrayList<String>();
//        if (!contents.isEmpty() && (contents.get(0) instanceof NamedEntity)) {
//            for (E e : contents) {
//                NamedEntity namedEntity = (NamedEntity) e;
//                if (!names.contains(namedEntity.getName()))
//                    names.add(names.size(), namedEntity.getName());
//            }
//        }
//        return names;
//    }

    public Iterator<E> iterator () {
        return contents.iterator();
    }

    public boolean sameContents (OldBag<E> bag) {
        for (E e : contents) {
            if (!bag.getContents().contains(e)) return false;
        }
        return true;
    } //
} // end class Bag
