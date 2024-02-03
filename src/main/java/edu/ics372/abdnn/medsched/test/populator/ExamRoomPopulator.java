package edu.ics372.abdnn.medsched.test.populator;

import edu.ics372.abdnn.medsched.core.concretes.ExamRoom;
import edu.ics372.abdnn.medsched.core.exceptions.*;
import edu.ics372.abdnn.medsched.core.global.Constant;
import edu.ics372.abdnn.medsched.core.interfaces.Populator;
import edu.ics372.abdnn.medsched.core.catalogs.ExamRooms;
import edu.ics372.abdnn.medsched.core.visitors.NameGenerator;
import edu.ics372.abdnn.medsched.core.visitors.SerialNumberGenerator;
import edu.ics372.abdnn.medsched.facade.request.*;
import edu.ics372.abdnn.medsched.facade.response.*;

public enum ExamRoomPopulator implements Populator  {
    INSTANCE;
    @Override
    public void populate () {
//        String name = "";
        for (int letterIndex = 0; letterIndex < Constant.LETTERS.length; letterIndex++) {
            for (int numberIndex = 0; numberIndex < Constant.ROOMS_PER_LETTER; numberIndex++) {
                int id = SerialNumberGenerator.INSTANCE.examroomId();
                String letter = Constant.LETTERS[letterIndex];
                String name = NameGenerator.INSTANCE.assignName(this, letter, numberIndex);
                Response response = new Response();
                ExamRoom examroom = null;
                try {
                    examroom = response.response(new CreateExamRoomRequest(name));
                } catch (DuplicateEntityException | RecordAdditionFailedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
} // end enum ExamRoomPopulator
