package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.Room;
import edu.ics372.abdnn.medsched.enums.Availabilty;
import edu.ics372.abdnn.medsched.enums.RoomState;
import edu.ics372.abdnn.medsched.global.Constant;

import java.util.Objects;

public class ExamRoom extends Room {
    private Availabilty availabilty;

    public ExamRoom (int id, String name) {
        super(id, name, Constant.EXAM_ROOM_CAPACITY);
        this.availabilty = Availabilty.OPEN;
    } //

    public Availabilty getAvailabilty () { return availabilty; }
    public void setState (Availabilty availabilty) { this.availabilty = availabilty; }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof ExamRoom examRoom)
            return super.equals(examRoom) && availabilty.equals(examRoom.getAvailabilty());
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), availabilty);
    }

    @Override
    public String toString () { return super.toString() + " " + availabilty.toString(); }
} // end class ExamRoom
