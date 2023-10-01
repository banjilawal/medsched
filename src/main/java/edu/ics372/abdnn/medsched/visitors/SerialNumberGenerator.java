package edu.ics372.abdnn.medsched.visitors;

import edu.ics372.abdnn.medsched.interfaces.*;
import edu.ics372.abdnn.medsched.populators.*;

public enum SerialNumberGenerator implements NumberAssigner {
    INSTANCE;

    private int examRoomSerialNumber = 1;
    private int departmentSerialNumber = 1;
    private int appointmentSerialNumber = 1;
    private int calendarDaySerialNumber = 1;
    private int ExamRoomReservationSerialNumber = 1;


    @Override
    public int assignNumber (CalendarPopulator calendarPopulator) { return calendarDaySerialNumber++; }

    @Override
    public int assignNumber (ExamRoomPopulator examRoomPopulator) { return examRoomSerialNumber++;};

    @Override
    public int assignNumber (DepartmentPopulator departmentPopulator) { return departmentSerialNumber++; }

    @Override
    public int appointmentId () { return appointmentSerialNumber++; }

    public int examRoomId () { return examRoomSerialNumber++; }
} // end class SerialNumberGenerator
