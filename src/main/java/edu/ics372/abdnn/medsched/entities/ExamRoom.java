package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.*;
import edu.ics372.abdnn.medsched.global.*;
import edu.ics372.abdnn.medsched.interfaces.*;

public class ExamRoom extends Room implements Resource, Response  {

    public ExamRoom (int id, String name) {
        super(id, name, Constant.EXAM_ROOM_CAPACITY);
    }
} // end class ExamRoom
