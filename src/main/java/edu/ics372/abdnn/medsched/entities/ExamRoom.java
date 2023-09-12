package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.Room;
import edu.ics372.abdnn.medsched.enums.Availability;
import edu.ics372.abdnn.medsched.global.Constant;

import java.util.Objects;

public class ExamRoom extends Room {
    private Availability availability;

    public ExamRoom (int id, String name) {
        super(id, name, Constant.EXAM_ROOM_CAPACITY);
        this.availability = Availability.OPEN;
    } //

    public Availability getAvailabilty () { return availability; }
    public void setState (Availability availability) { this.availability = availability; }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof ExamRoom examRoom)
            return super.equals(examRoom) && availability.equals(examRoom.getAvailabilty());
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), availability);
    }

    @Override
    public String toString () { return super.toString() + " " + availability.toString(); }
} // end class ExamRoom
