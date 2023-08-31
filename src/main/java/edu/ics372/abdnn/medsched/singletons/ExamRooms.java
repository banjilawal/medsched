package edu.ics372.abdnn.medsched.singletons;

import edu.ics372.abdnn.medsched.abstracts.NamedEntity;
import edu.ics372.abdnn.medsched.containers.Bag;
import edu.ics372.abdnn.medsched.entities.ExamRoom;
import edu.ics372.abdnn.medsched.enums.RoomState;

import java.util.ArrayList;
import java.util.Iterator;


public final class ExamRooms {
    private static ExamRooms INSTANCE;
    private Bag<ExamRoom> bag;

    private static ExamRooms getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ExamRooms();
        }
        return INSTANCE;
    }

//    public Iterator<ExamRoom> iterator () { return container.iterator(); }
//
//    public void add (ExamRoom examRoom) {
//        container.add(examRoom);
//    }
//
//    public ExamRoom search (int id) { return bag.search(id); }
//    public ExamRoom search (String name) {
//        for (ExamRoom examRoom : bag.getContents()) {
//            if (examRoom.getName().equalsIgnoreCase(name)) return examRoom;
//        }
//        return null;
//    }

    public Iterator<ExamRoom> getOpenRooms () {
        ArrayList<ExamRoom> results = new ArrayList<ExamRoom>();
        for (NamedEntity ne : container.getContents()) {
            ExamRoom examRoom = (ExamRoom) ne;
            if (examRoom.getState().equals(RoomState.EMPTY) && !results.contains(examRoom))
                results.add(results.size(), examRoom);
        }
        return results.iterator();
    }
} // end class ExamRooms
