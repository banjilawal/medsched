package edu.ics372.abdnn.medsched.test.drivers;

import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.facade.request.*;
import edu.ics372.abdnn.medsched.facade.response.*;
import edu.ics372.abdnn.medsched.test.populator.*;

import java.util.*;

public class PopulatorDriver {

    public static void main (String[] args) {

        ExamRoomPopulator.INSTANCE.populate();
        System.out.println(ExamRooms.INSTANCE.toString());

        DepartmentPopulator.INSTANCE.populate();
        System.out.println(Departments.INSTANCE.toString());

        ProviderPopulator.INSTANCE.populate();
        System.out.println(Providers.INSTANCE.toString());

        PatientPopulator.INSTANCE.populate();
        System.out.println(Patients.INSTANCE.toString());

        AppointmentPopulator.INSTANCE.populate();
        System.out.println(Appointments.INSTANCE.toString());

        ArrayList<String> departmentNames = new Response().response(new DepartmentNamesRequest());
        System.out.println(departmentNames.size());
    }
} // end class PopulatorDriver
