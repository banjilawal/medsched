package edu.ics372.abdnn.medsched.core.populator;

import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.entity.*;
import edu.ics372.abdnn.medsched.core.global.*;
import edu.ics372.abdnn.medsched.core.interfaces.*;
import edu.ics372.abdnn.medsched.facade.request.*;

public enum AppointmentPopulator implements Populator  {
    INSTANCE;

    @Override
    public void populate () {
        for (int index = 0; index < Constant.MINIMUM_APPOINTMENT_COUNT; index++) {
            Department department = Departments.INSTANCE.rand();
            Provider provider = Providers.INSTANCE.rand();
            Patient patient = Patients.INSTANCE.rand();
            ;
            ExamRoom examRoom = ExamRooms.INSTANCE.rand();
            Timeslot timeslot = department.randTimeslot();

            AppointmentRequest request = new AppointmentRequest(department, provider, examRoom, patient, timeslot);
            Appointment appointment = request.result();
            if (appointment != null) {
                System.out.println(appointment.toString());
            }
            else {
                System.out.println("Appointment creation failed");
            }
        }
    }
} // end enum DepartmentPopulator
