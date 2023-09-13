package edu.ics372.abdnn.medsched.populators;

import edu.ics372.abdnn.medsched.entities.Day;
import edu.ics372.abdnn.medsched.entities.ExamRoom;
import edu.ics372.abdnn.medsched.global.Constant;
import edu.ics372.abdnn.medsched.interfaces.Populator;
import edu.ics372.abdnn.medsched.singletons.Calendar;
import edu.ics372.abdnn.medsched.singletons.ExamRooms;
import edu.ics372.abdnn.medsched.visitors.NameGenerator;
import edu.ics372.abdnn.medsched.visitors.SerialNumberGenerator;

import java.time.LocalDate;

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
