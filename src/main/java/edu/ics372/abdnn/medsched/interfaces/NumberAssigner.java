package edu.ics372.abdnn.medsched.interfaces;

import edu.ics372.abdnn.medsched.populators.CalendarPopulator;
import edu.ics372.abdnn.medsched.populators.DepartmentPopulator;
import edu.ics372.abdnn.medsched.populators.ExamRoomPopulator;

public interface NumberAssigner {
    public int assignNumber (CalendarPopulator calendarPopulator);
    public int assignNumber (ExamRoomPopulator examRoomPopulator);
    public int assignNumber (DepartmentPopulator departmentPopulator);

    public int appointmentId ();
} // end interface NumberAssigner