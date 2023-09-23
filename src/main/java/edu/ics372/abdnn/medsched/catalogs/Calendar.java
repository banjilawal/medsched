package edu.ics372.abdnn.medsched.catalogs;

import edu.ics372.abdnn.medsched.containers.Bag;
import edu.ics372.abdnn.medsched.entities.Day;
import edu.ics372.abdnn.medsched.entities.Period;
import edu.ics372.abdnn.medsched.interfaces.BagWrapper;

import java.util.Iterator;
import java.util.function.Predicate;

public enum Calendar implements BagWrapper<Day> {
    INSTANCE;
    private final Bag<Day> calendar = new Bag<Day>();

    public boolean periodIsOpen (Period period) { return true; }

    public Day search (String name) { return calendar.search(name); }
    public Day search (int id) { return calendar.search(id); }

    public Day peek (String name) { return calendar.peek(search(name)); }
    public Day peek (int id) { return calendar.peek(search(id)); }

    public Day pop (String name) { return calendar.pop(calendar.search(name)); }
    public Day pop (int id) { return calendar.pop(calendar.search(id)); }

    public void remove (String name) { remove(calendar.search(name)); }
    public void remove (int id) { remove(calendar.search(id)); }

    public void remove (Day day) {
        calendar.remove(calendar.indexOf(day));
    }

    @Override
    public int size () { return calendar.size(); }

    @Override
    public Bag<Day> getBag () { return calendar; }


    @Override
    public void add (Day day) { calendar.add(day);}

    

    @Override
    public Iterator<Day> iterator () { return calendar.iterator(); }

    @Override
    public Iterator<Day> filter (Predicate<Day> predicate) { return calendar.filter(predicate); }

    @Override
    public String toString () {
        StringBuilder stringBuilder = new StringBuilder("Calendar\n----------\n");
        for (Day day : calendar.getContents()) {
            stringBuilder.append(day.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
} // end class Calendar