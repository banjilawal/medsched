package edu.ics372.abdnn.medsched.core.interfaces;

import edu.ics372.abdnn.medsched.test.populator.ExamRoomPopulator;

public interface NameAssigner {
    public String assignName (ExamRoomPopulator examRoomPopulator, String letter, int number);
} // end interface NameAssigner
