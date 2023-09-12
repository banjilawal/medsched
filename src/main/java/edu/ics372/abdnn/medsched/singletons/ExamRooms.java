package edu.ics372.abdnn.medsched.singletons;

import edu.ics372.abdnn.medsched.containers.Bag;
import edu.ics372.abdnn.medsched.entities.ExamRoom;
import edu.ics372.abdnn.medsched.enums.Availability;
import edu.ics372.abdnn.medsched.interfaces.BagWrapper;
import edu.ics372.abdnn.medsched.interfaces.SingletonBagWrapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;


public final class ExamRooms implements BagWrapper<ExamRoom> {
    private static ExamRooms INSTANCE;

    private ExamRooms () {
        Bag<ExamRoom> bag = new Bag<ExamRoom>();
    }

    public static ExamRooms getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ExamRooms();
        }
        return INSTANCE;
    }


    @Override
    public int size () { return getInstance().size(); }

    @Override
    public Bag<ExamRoom> getBag () {
        return null;
    }

    @Override
    public void add (ExamRoom examRoom) { getInstance().add(examRoom);}

    @Override
    public ExamRoom pop (ExamRoom examRoom) { return getInstance().pop(examRoom); }

    @Override
    public ExamRoom peek (ExamRoom examRoom) {
        return null;
    }

    @Override
    public void remove (ExamRoom examRoom) { getInstance().remove(examRoom);}

    @Override
    public Iterator<ExamRoom> iterator () { return getInstance().iterator(); }

    public ExamRoom searchByName (String name) { return getInstance().searchByName(name); }

    public ExamRoom searchById (int id) { return getInstance().searchById(id); }

    public ExamRoom find (String name, int id) { return getInstance().find(name, id); }

    public Iterator<ExamRoom> getOpenRooms () {
        Predicate<ExamRoom> predicate =  examRoom -> examRoom.getAvailabilty().equals(Availability.OPEN);
            return getInstance().filter(predicate);
    } // close getOpenRooms

    @Override
    public Iterator<ExamRoom> filter (Predicate<ExamRoom> predicate) {
        ArrayList<ExamRoom> matches = new ArrayList<ExamRoom>();
        Iterator<ExamRoom> iterator = getInstance().iterator();
        while (iterator().hasNext()) {
            ExamRoom examRoom = iterator.next();
            if (predicate.test(examRoom) && !matches.contains(examRoom))
                matches.add(matches.size(), examRoom);
        }
        return matches.iterator();
    } // close filter
} // end class ExamRooms
