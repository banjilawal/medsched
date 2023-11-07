package edu.ics372.abdnn.medsched.core.catalogs;

import edu.ics372.abdnn.medsched.core.entities.*;

import java.util.ArrayList;


public enum Examrooms {
    INSTANCE;
    private final ArrayList<Examroom> examrooms = new ArrayList<>();

    public ArrayList<Examroom> getOpenRooms (Period period) {
        ArrayList<Examroom> openRooms = new ArrayList<>();

        for (Examroom examRoom : examrooms) {
            if (Appointments.INSTANCE.search(examRoom, period) == null
                && RoomReservations.INSTANCE.search(examRoom, period) == null
                && !openRooms.contains(examRoom)
            ) {
                openRooms.add(openRooms.size(), examRoom);
            }
        }
        return openRooms;
    }


    public Examroom search (String name) {
        for (Examroom examRoom: examRoomss) {
            if (examRoom.getName().equalsIgnoreCase(name))
                return examRoom;
        }
        return null;
    }


    public Examroom search (int id) {
        for (Examroom examRoom : examrooms) {
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
    public boolean remove (Examroom examRoom) {
       return false;
    }


    public boolean  add (Examroom examRoom) {
        if (!examrooms.contains(examRoom))
            return examrooms.add(examRoom);
        return true;
    }
} // end class ExamRooms