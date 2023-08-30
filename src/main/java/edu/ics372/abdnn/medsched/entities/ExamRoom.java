package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.Room;
import edu.ics372.abdnn.medsched.enums.RoomState;
import edu.ics372.abdnn.medsched.global.Constant;

public class ExamRoom extends Room {
    private RoomState state;

    public ExamRoom (int id, String name) {
        super(id, name, Constant.EXAM_ROOM_CAPACITY);
        this.state = RoomState.EMPTY;
    }

    public RoomState getState () { return state; }
    public void setState (RoomState state) { this.state = state; }
} // end class ExamRoom
