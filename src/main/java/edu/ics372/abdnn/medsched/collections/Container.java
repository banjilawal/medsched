package edu.ics372.abdnn.medsched.collections;

import edu.ics372.abdnn.medsched.abstracts.NamedEntity;
import edu.ics372.abdnn.medsched.interfaces.NamedEntityBagWrapper;


import java.util.ArrayList;
import java.util.Iterator;

public class Container<E> implements NamedEntityBagWrapper<NamedEntity> {
    private Bag<NamedEntity> bag;

    public Container () {
        this.bag = new Bag<NamedEntity>();
    }

    public ArrayList<NamedEntity> getContents () {
        return bag.getContents();
    }

    public int size () { return bag.size(); }


    public void addContents (ArrayList<NamedEntity> contents) {
        for (NamedEntity namedEntity : contents) {
            add(namedEntity);
        }
    } //

    @Override
    public void add (NamedEntity namedEntity) {
        if (nameExists(namedEntity.getName()))
            throw new IllegalArgumentException("A department already has that name");
        bag.add(namedEntity);
    }

    public void removeContents (ArrayList<NamedEntity> contents) {
        for (NamedEntity namedEntity : bag.getContents()) {
            remove(namedEntity.getId());
        }
    } //

    public void remove (int id) {
        int arrayIndex = bag.getContents().indexOf(search(id));
        if (arrayIndex > -1)
            bag.getContents().remove(arrayIndex);
    } //

    @Override
    public void remove (NamedEntity namedEntity) {

    }

    public NamedEntity search (int id) {
        for (NamedEntity namedEntity : bag.getContents()) {
            if (namedEntity.getId() == id) return namedEntity;
        }
        return null;
    }

    @Override
    public NamedEntity search (String name) {
        for (NamedEntity namedEntity : bag.getContents()) {
            if (namedEntity.getName().equalsIgnoreCase(name)) return namedEntity;
        }
        return null;
    }

    public boolean nameExists (String name) {
        for (NamedEntity namedEntity : bag.getContents()) {
            if (name.equalsIgnoreCase(namedEntity.getName())) return true;
        }
        return false;
    } //

    public Iterator<NamedEntity> iterator () {
        return bag.getContents().iterator();
    }
} // end class Bag
