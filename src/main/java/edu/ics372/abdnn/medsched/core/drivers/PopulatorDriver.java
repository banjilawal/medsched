package edu.ics372.abdnn.medsched.core.drivers;

import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.populator.*;

public class PopulatorDriver {

    public static void main (String[] args) {

        ExamRoomPopulator.INSTANCE.populate();
        System.out.println("ExamRooms\n--------\n" + ExamRooms.INSTANCE.toString());

        DepartmentPopulator.INSTANCE.populate();
//        System.out.println("Departments\n----------\n" + Departments.INSTANCE.toString());

        ProviderPopulator.INSTANCE.populate();
        System.out.println("Providers\n----------\n" + Providers.INSTANCE.toString());

        PatientPopulator.INSTANCE.populate();
        System.out.println("Patients\n----------\n" + Patients.INSTANCE.toString());

        AppointmentPopulator.INSTANCE.populate();
    }
} // end class PopulatorDriver
