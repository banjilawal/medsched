package edu.ics372.abdnn.medsched.test.populator;

import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.concretes.*;
import edu.ics372.abdnn.medsched.core.exceptions.*;
import edu.ics372.abdnn.medsched.core.global.*;
import edu.ics372.abdnn.medsched.core.interfaces.*;
import edu.ics372.abdnn.medsched.facade.request.*;
import edu.ics372.abdnn.medsched.facade.response.*;

public enum AppointmentPopulator implements Populator  {
    INSTANCE;

    @Override
    public void populate () {
        for (int index = 0; index < Constant.MINIMUM_APPOINTMENT_COUNT; index++) {
            Department department = Departments.INSTANCE.rand();
            Provider provider = Providers.INSTANCE.rand();
            Patient patient = Patients.INSTANCE.rand();
            ExamRoom examRoom = ExamRooms.INSTANCE.rand();
            Timeslot timeslot = department.randTimeslot();
            Response response = new Response();
            Appointment appointment = null;
            try {
                appointment = response.response(
                    new CreateAppointmentRequest(
                        department,
                        provider,
                        examRoom,
                        patient,
                        timeslot
                    ));
            } catch (
                ReservationRejectionException
                | FailedRecordDeletionException
                | RecordAdditionFailedException
                | AppointmentCreationFailedException e
            ) {
                throw new RuntimeException(e);
            }
//            if (appointment == null) {
//                System.out.println("AppointmentPopulator:L28 Appointment creation failed null returned");
//            }
        }
    }
} // end enum DepartmentPopulator
