package edu.ics372.abdnn.medsched.core.catalogs;

import edu.ics372.abdnn.medsched.core.entities.*;

import java.util.ArrayList;


public enum ExamRooms {
    INSTANCE;
    private final ArrayList<ExamRoom> examRooms = new ArrayList<>();

    public ArrayList<ExamRoom> getOpenRooms (Period period) {
        ArrayList<ExamRoom> openRooms = new ArrayList<>();

        for (ExamRoom examRoom : examRooms) {
            if (Appointments.INSTANCE.search(examRoom, period) == null
                && RoomReservations.INSTANCE.search(examRoom, period) == null
                && !openRooms.contains(examRoom)
            ) {
                openRooms.add(openRooms.size(), examRoom);
            }
        }
        return openRooms;
    }


    public ExamRoom search (String name) {
        for (ExamRoom examRoom: examRoomss) {
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
        if (!examRooms.contains(examRoom))
            return examRooms.add(examRoom);
        return true;
    }
} // end class ExamRooms