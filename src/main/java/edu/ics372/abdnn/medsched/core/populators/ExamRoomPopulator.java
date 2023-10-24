package edu.ics372.abdnn.medsched.core.populators;

import edu.ics372.abdnn.medsched.core.entities.ExamRoom;
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
                ExamRooms.INSTANCE.add(
                    new ExamRoom(
                        SerialNumberGenerator.INSTANCE.assignNumber(this),
                        NameGenerator.INSTANCE.assignName(this, Constant.LETTERS[letterIndex], numberIndex)
                    )
                );
            }
        }
    }
} // end enum ExamRoomPopulator
