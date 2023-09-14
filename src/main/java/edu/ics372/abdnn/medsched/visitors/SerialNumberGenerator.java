package edu.ics372.abdnn.medsched.visitors;

import edu.ics372.abdnn.medsched.interfaces.AppointmentRequest;
import edu.ics372.abdnn.medsched.interfaces.NumberAssigner;
import edu.ics372.abdnn.medsched.populators.CalendarPopulator;
import edu.ics372.abdnn.medsched.populators.DepartmentPopulator;
import edu.ics372.abdnn.medsched.populators.ExamRoomPopulator;

public enum SerialNumberGenerator implements NumberAssigner {
    INSTANCE;

    private int examRoomSerialNumber = 1;
    private int departmentSerialNumber = 1;
    private int appointmentSerialNumber = 1;
    private int calendarDaySerialNumber = 1;


    @Override
    public int assignNumber (CalendarPopulator calendarPopulator) { return calendarDaySerialNumber++; }

    @Override
    public int assignNumber (ExamRoomPopulator examRoomPopulator) { return examRoomSerialNumber++;};

    @Override
    public int assignNumber (DepartmentPopulator departmentPopulator) { return departmentSerialNumber++; }

    @Override
    public int appointmentId () { return appointmentSerialNumber++; }

    public String assignName (AppointmentRequest appointmentRequest) { return appointmentRequest.getPatient().toString(); }
} // end class SerialNumberGenerator
