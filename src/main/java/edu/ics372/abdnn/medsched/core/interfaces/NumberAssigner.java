package edu.ics372.abdnn.medsched.core.interfaces;

import edu.ics372.abdnn.medsched.core.populators.DepartmentPopulator;
import edu.ics372.abdnn.medsched.core.populators.ExamRoomPopulator;

public interface NumberAssigner {
    public int assignNumber (ExamRoomPopulator examRoomPopulator);
    public int assignNumber (DepartmentPopulator departmentPopulator);

    public int examroomId ();

    public int departmentId ();

    public int appointmentId ();

    public int patientId ();
    public int providerId ();
} // end interface NumberAssigner