package edu.ics372.abdnn.medsched.facade.request;


import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.concretes.*;
import edu.ics372.abdnn.medsched.core.visitors.*;

public class CreateExamRoomRequest {
    private String name;


    public CreateExamRoomRequest (String name) {
        this.name = name;
    }


    public String getExamRoomName () {
        return name;
    }


    public ExamRoom result () {
        String message = "";
        ExamRoom examRoom = null;
        try {
            if (ExamRooms.INSTANCE.search(name) != null) {
                message = "ExamRoom  named " + name + " already exists";
            }
            else {
                examRoom = new ExamRoom(SerialNumberGenerator.INSTANCE.examroomId(), name);
                boolean success = ExamRooms.INSTANCE.add(examRoom);
                if (!success)
                    message = "Adding examRoom " + examRoom.getName() + " failed";
                else
                    message = "Successfully added " + examRoom.getName();
            }
        } catch (Exception e) {
            System.out.println(message);
            throw new RuntimeException(e);
        }
        return examRoom;
    }
} // end class CreateExamRoomRequest
