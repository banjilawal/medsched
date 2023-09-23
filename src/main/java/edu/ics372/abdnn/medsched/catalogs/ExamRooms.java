package edu.ics372.abdnn.medsched.catalogs;

import edu.ics372.abdnn.medsched.containers.Bag;
import edu.ics372.abdnn.medsched.entities.ExamRoom;
import edu.ics372.abdnn.medsched.entities.Period;
import edu.ics372.abdnn.medsched.interfaces.BagWrapper;
import edu.ics372.abdnn.medsched.reservations.RoomReservations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;


public enum ExamRooms implements BagWrapper<ExamRoom> {
    INSTANCE;
    private final Bag<ExamRoom> examRooms = new Bag<ExamRoom>();

    public ArrayList<ExamRoom> getOpenRooms (Period period) {
        ArrayList<ExamRoom> openRooms = new ArrayList<>();
        ArrayList<Integer> bookedRoomIds = RoomReservations.INSTANCE.getBookedRoomIds(period);

        for (ExamRoom examRoom : examRooms.getContents()) {
            if (!bookedRoomIds.contains(examRoom.getId()) && !openRooms.contains(examRoom)) {
                openRooms.add(openRooms.size(), examRoom);
            }
        }
        return openRooms;
    }

    public ExamRoom firstOpen (Period period) {
        ArrayList<ExamRoom> openRooms = getOpenRooms(period);
        if (!openRooms.isEmpty()) return openRooms.get(0);
        return null;
    }

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

    public String toString () { return getBag().toString(); }
} // end class ExamRooms