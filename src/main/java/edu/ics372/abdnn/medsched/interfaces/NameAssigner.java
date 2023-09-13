package edu.ics372.abdnn.medsched.interfaces;

import edu.ics372.abdnn.medsched.populators.ExamRoomPopulator;

public interface NameAssigner {
    public String assignName (ExamRoomPopulator examRoomPopulator, String letter, int number);
} // end interface NameAssigner
