package edu.ics372.abdnn.medsched.facade.request;


public class CreateExamRoomRequest {
    private final String examRoomName;


    private CreateExamRoomRequest (String examRoomName) {
        this.examRoomName = examRoomName;
    }


    public String getExamRoomName () {
        return examRoomName;
    }
} // end class CreateExamRoomRequest
