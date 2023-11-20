package edu.ics372.abdnn.medsched.core.visitors;

import edu.ics372.abdnn.medsched.core.interfaces.*;
import edu.ics372.abdnn.medsched.core.populators.*;

public enum SerialNumberGenerator implements NumberAssigner {
    INSTANCE;

    private int examRoomSerialNumber = 1;
    private int departmentSerialNumber = 1;
    private int appointmentSerialNumber = 1;
    private int patientSerialNumber = 1;
    private int providerSerialNumber = 1;


    @Override
    public int assignNumber (ExamRoomPopulator examRoomPopulator) { return examRoomSerialNumber++;};

    @Override
    public int assignNumber (DepartmentPopulator departmentPopulator) { return departmentSerialNumber++; }

    @Override
    public int examroomId () {
        return examRoomSerialNumber++;
    }

    @Override
    public int departmentId () {
        return departmentSerialNumber++;
    }

    @Override
    public int appointmentId () {
        return appointmentSerialNumber++;
    }

    @Override
    public int patientId() {
        return patientSerialNumber++;
    }

    @Override
    public int providerId() {
        return providerSerialNumber++;
    }
} // end class SerialNumberGenerator
