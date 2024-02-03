package edu.ics372.abdnn.medsched.core.visitors;

import edu.ics372.abdnn.medsched.core.interfaces.NameAssigner;
import edu.ics372.abdnn.medsched.test.populator.ExamRoomPopulator;

public enum NameGenerator implements NameAssigner {
    INSTANCE;


    @Override
    public String assignName (ExamRoomPopulator examRoomPopulator, String letter, int number) {
        return letter + "-" + (++number);
    }
} // end class NameGenerator
