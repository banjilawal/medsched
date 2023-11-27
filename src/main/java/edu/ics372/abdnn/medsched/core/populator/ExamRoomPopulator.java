package edu.ics372.abdnn.medsched.core.populator;

import edu.ics372.abdnn.medsched.core.entity.ExamRoom;
import edu.ics372.abdnn.medsched.core.global.Constant;
import edu.ics372.abdnn.medsched.core.interfaces.Populator;
import edu.ics372.abdnn.medsched.core.catalogs.ExamRooms;
import edu.ics372.abdnn.medsched.core.visitors.NameGenerator;
import edu.ics372.abdnn.medsched.core.visitors.SerialNumberGenerator;

public enum ExamRoomPopulator implements Populator  {
    INSTANCE;
    @Override
    public void populate () {
        String name = "";
        for (int letterIndex = 0; letterIndex < Constant.LETTERS.length; letterIndex++) {
            for (int numberIndex = 0; numberIndex < Constant.ROOMS_PER_LETTER; numberIndex++) {
                int id = SerialNumberGenerator.INSTANCE.examroomId();
                String letter = Constant.LETTERS[letterIndex];
                ExamRoom examroom =  new ExamRoom(id, NameGenerator.INSTANCE.assignName(this, letter, numberIndex));
                if (ExamRooms.INSTANCE.add(examroom)) {
                    System.out.println(examroom.toString());
                }
            }
        }
    }
} // end enum ExamRoomPopulator
