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

    public E get (E e) {
        if (contents.contains(e)) return e;
        return null;
    } //

    public E namedEntityMatch (String name, int id) {
        for (E e : contents) {
            if (e instanceof NamedEntity namedEntity) {
                if (name.equalsIgnoreCase(namedEntity.getName()) && id == namedEntity.getId())
                    return e;
            }
        }
        return null;
    } // close namedEntityMatch

    public E entityMatch (int id) {
        for (E e : contents) {
            if (e instanceof Entity entity) {
                if (id == entity.getId()) return e;
            }
        }
        return null;
    } // close entityMatch

    public E find (E e) {
        if (e instanceof NamedEntity namedEntity) {
            return namedEntityMatch(namedEntity.getName(), namedEntity.getId());
        }
        else if (e instanceof Entity entity) return entityMatch(entity.getId());
        else return null;
    } // close find


    public void addNamedEntity (E e) {
        if (e instanceof NamedEntity namedEntity) {
            if (namedEntityMatch(namedEntity.getName(), namedEntity.getId()) != null) {
                contents.add(contents.size(), e);
            }
        }
    } // close addNamedEntity

    public void addEntity (E e) {
        if (!(e instanceof NamedEntity)) {
            assert e instanceof Entity;
            Entity entity = (Entity) e;
            if (entityMatch(entity.getId()) != null) {
                contents.add(contents.size(), e);
            }
        }
    } // close addEntity

    public void add (E e) {
        if ()
    }

//    public void add (E e) {
//        if (e instanceof NamedEntity namedEntity) addNamedEntity(e);
//        else addEntity(e);
//    } // close add

    public void removeNamedEntity (E e) {
        if (e instanceof NamedEntity namedEntity) {
            if (namedEntityMatch(namedEntity.getName(), namedEntity.getId()) != null) {
                contents.remove(contents.indexOf(e));
            }
        }
    } // close removeNamedEntity

    public void removeEntity (E e) {
        if (!(e instanceof NamedEntity)) {
            assert e instanceof Entity;
            Entity entity = (Entity) e;
            if (entityMatch(entity.getId()) != null) {
                contents.remove(contents.indexOf(e));
            }
        }
    } // close removeEntity

    public void remove (E e) { if (contents.contains(e)) contents.remove(contents.indexOf(e)); } // close removeEntity

//    public void remove (E e) {
//        if (e instanceof NamedEntity namedEntity) removeNamedEntity(e);
//        else removeEntity(e);
//    } // close removeEntity

    public E pop (E e) {
        int arrayIndex = contents.indexOf(e);
        if (arrayIndex >= 0) {
            contents.remove(arrayIndex);
            return e;
        }
        return null;
    } // close pop

    public E peek (E e) {
        E item = find(e);
        if (item != null) return contents.get(contents.indexOf(e));
        return null;
    }

    public Iterator<E> iterator () {
        return contents.iterator();
    } // close iterator

    public Iterator<E> filter (Predicate<E> predicate) {
        ArrayList<E> matches = new ArrayList<E>();
        for (E e : contents) {
            if (predicate.test(e) && !matches.contains(e))
                matches.add(matches.size(), e);
        }
        return matches.iterator();
    } // close filter

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

    private boolean  namedEntityMatch (NamedEntity namedEntity, String name, int id) {
        return name.equalsIgnoreCase(namedEntity.getName()) && id == namedEntity.getId();
    }

    private boolean entityMatch (Entity entity, int id) {
        return id == entity.getId();
    }
} // end class Bag
