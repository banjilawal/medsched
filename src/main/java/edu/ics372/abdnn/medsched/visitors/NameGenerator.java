package edu.ics372.abdnn.medsched.visitors;

import edu.ics372.abdnn.medsched.interfaces.NameAssigner;
import edu.ics372.abdnn.medsched.populators.ExamRoomPopulator;

public enum NameGenerator implements NameAssigner {
    INSTANCE;


    @Override
    public String assignName (ExamRoomPopulator examRoomPopulator, String letter, int number) {
        return letter + "-" + (++number);
    }
} // end class NameGenerator
