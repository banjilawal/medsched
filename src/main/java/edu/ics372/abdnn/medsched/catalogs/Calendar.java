package edu.ics372.abdnn.medsched.catalogs;

import edu.ics372.abdnn.medsched.containers.*;
import edu.ics372.abdnn.medsched.entities.*;

import java.util.*;
import java.util.function.*;

public enum Calendar {
    INSTANCE;
    private final Bag<Period> calendar = new Bag<>();

    public boolean periodIsOpen (Period period) { return true; }

    public Period search (int id) { return calendar.search(id); }

    public Period peek (int id) { return calendar.peek(search(id)); }

    public Period pop (int id) { return calendar.pop(calendar.search(id)); }

    public void remove (int id) { remove(calendar.search(id)); }

    public void remove (Period period) {
        calendar.remove(calendar.indexOf(period));
    }


    public int size () { return calendar.size(); }


    public Bag<Period> getBag () { return calendar; }


    public void add (Period period) { calendar.add(period);}


    public Iterator<Period> iterator () { return calendar.iterator(); }


    public Iterator<Period> filter (Predicate<Period> predicate) { return calendar.filter(predicate); }

    @Override
    public String toString () {
        StringBuilder stringBuilder = new StringBuilder("Calendar\n----------\n");
        for (Period period : calendar.getContents()) {
            stringBuilder.append(period.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
} // end class Calendar
