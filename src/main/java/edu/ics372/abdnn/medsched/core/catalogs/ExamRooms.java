package edu.ics372.abdnn.medsched.core.catalogs;

import edu.ics372.abdnn.medsched.core.catalogs.reservations.*;
import edu.ics372.abdnn.medsched.core.concretes.*;

import java.util.ArrayList;


public enum ExamRooms {
    INSTANCE;
    private final ArrayList<ExamRoom> examRooms = new ArrayList<>();

    public ArrayList<ExamRoom> getOpenRooms (Timeslot timeSlot) {
        ArrayList<ExamRoom> openRooms = new ArrayList<>();

        for (ExamRoom examRoom : examRooms) {
            if (Appointments.INSTANCE.search(examRoom, timeSlot) == null
                && RoomReservations.INSTANCE.search(examRoom, timeSlot) == null
                && !openRooms.contains(examRoom)
            ) {
                openRooms.add(openRooms.size(), examRoom);
            }
        }
        return openRooms;
    }


    public ExamRoom search (String name) {
        for (ExamRoom examRoom: examRooms) {
            if (examRoom.getName().equalsIgnoreCase(name))
                return examRoom;
        }
        return null;
    }


    public ExamRoom search (int id) {
        for (ExamRoom examRoom : examRooms) {
            if (examRoom.getId() == id)
                return examRoom;
        }
        return null;
    }


    /**
     * Only delete an examRoom if its not been reserved or assigned to an appointment
     * @param examRoom
     * @return
     */
    public boolean remove (ExamRoom examRoom) {
       return false;
    }


    public boolean  add (ExamRoom examRoom) {
        if (!examRooms.contains(examRoom)) {
            return examRooms.add(examRoom);
        }
        return true;
    }

    @Override
    public String toString () {
        String string = "ExamRooms\n--------\n";
        for (ExamRoom examroom : examRooms)
            string += examroom.toString() + "\n";
        return string;
    }


    public ExamRoom rand () {
        int index = (int) (Math.random() * (examRooms.size() - 1));
        return examRooms.get(index);
    }
} // end class ExamRooms