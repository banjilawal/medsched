package edu.ics372.abdnn.medsched.singletons;

import edu.ics372.abdnn.medsched.abstracts.Person;
import edu.ics372.abdnn.medsched.containers.Bag;
import edu.ics372.abdnn.medsched.entities.ExamRoom;
import edu.ics372.abdnn.medsched.entities.ExamRoom;
import edu.ics372.abdnn.medsched.entities.Provider;
import edu.ics372.abdnn.medsched.enums.Availability;
import edu.ics372.abdnn.medsched.interfaces.BagWrapper;
import edu.ics372.abdnn.medsched.interfaces.SingletonBagWrapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;


public enum ExamRooms implements BagWrapper<ExamRoom> {
    INSTANCE;
    private final Bag<ExamRoom> examRooms = new Bag<ExamRoom>();

    public ExamRoom search (String name) { return examRooms.search(name); }
    public ExamRoom search (int id) { return examRooms.search(id); }

    public ExamRoom peek (String name) { return examRooms.peek(search(name)); }
    public ExamRoom peek (int id) { return examRooms.peek(search(id)); }

    public ExamRoom pop (String name) { return examRooms.pop(examRooms.search(name)); }
    public ExamRoom pop (int id) { return examRooms.pop(examRooms.search(id)); }

    public void remove (String name) { remove(examRooms.search(name)); }
    public void remove (int id) { remove(examRooms.search(id)); }

    public void remove (ExamRoom examRoom) {
        examRooms.remove(examRooms.indexOf(examRoom));
    }

    @Override
    public int size () { return examRooms.size(); }

    @Override
    public Bag<ExamRoom> getBag () { return examRooms; }


    @Override
    public void add (ExamRoom examRoom) { examRooms.add(examRoom);}


    @Override
    public Iterator<ExamRoom> iterator () { return examRooms.iterator(); }

    @Override
    public Iterator<ExamRoom> filter (Predicate<ExamRoom> predicate) { return examRooms.filter(predicate); }
} // end class ExamRooms