package edu.ics372.abdnn.medsched.core.drivers;

import edu.ics372.abdnn.medsched.core.populators.DepartmentPopulator;
import edu.ics372.abdnn.medsched.core.populators.ExamRoomPopulator;
import edu.ics372.abdnn.medsched.core.catalogs.Departments;
import edu.ics372.abdnn.medsched.core.catalogs.Examrooms;

public class PopulatorDriver {

    public static void main (String[] args) {

        ExamRoomPopulator.INSTANCE.populate();
        System.out.println("ExamRooms\n--------\n" + Examrooms.INSTANCE.toString());

        DepartmentPopulator.INSTANCE.populate();
        System.out.println("Departments\n----------\n" + Departments.INSTANCE.toString());
    }
} // end class PopulatorDriver
