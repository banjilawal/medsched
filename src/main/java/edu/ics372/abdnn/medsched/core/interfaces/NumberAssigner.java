package edu.ics372.abdnn.medsched.core.interfaces;

import edu.ics372.abdnn.medsched.core.populators.DepartmentPopulator;
import edu.ics372.abdnn.medsched.core.populators.ExamRoomPopulator;

public interface NumberAssigner {
    public int assignNumber (ExamRoomPopulator examRoomPopulator);
    public int assignNumber (DepartmentPopulator departmentPopulator);

    public int appointmentId ();
} // end interface NumberAssigner