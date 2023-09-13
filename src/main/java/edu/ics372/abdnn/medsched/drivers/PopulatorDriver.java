package edu.ics372.abdnn.medsched.drivers;

import edu.ics372.abdnn.medsched.populators.CalendarPopulator;
import edu.ics372.abdnn.medsched.populators.DepartmentPopulator;
import edu.ics372.abdnn.medsched.populators.ExamRoomPopulator;
import edu.ics372.abdnn.medsched.singletons.Calendar;
import edu.ics372.abdnn.medsched.singletons.Departments;
import edu.ics372.abdnn.medsched.singletons.ExamRooms;

public class PopulatorDriver {

    public static void main (String[] args) {
        CalendarPopulator.INSTANCE.populate();
        System.out.println(Calendar.INSTANCE.toString());

        ExamRoomPopulator.INSTANCE.populate();
        System.out.println("ExamRooms\n--------\n" + ExamRooms.INSTANCE.toString());

        DepartmentPopulator.INSTANCE.populate();
        System.out.println("Departments\n----------\n" + Departments.INSTANCE.toString());
    }
} // end class PopulatorDriver
