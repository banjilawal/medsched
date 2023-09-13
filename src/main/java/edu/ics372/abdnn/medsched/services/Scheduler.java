package edu.ics372.abdnn.medsched.services;

import edu.ics372.abdnn.medsched.entities.*;
import edu.ics372.abdnn.medsched.enums.Availability;
import edu.ics372.abdnn.medsched.interfaces.AppointmentRequest;
import edu.ics372.abdnn.medsched.singletons.Departments;
import edu.ics372.abdnn.medsched.singletons.ExamRooms;
import edu.ics372.abdnn.medsched.visitors.SerialNumberGenerator;

import java.util.Iterator;

public class Scheduler {
//
//    private static Scheduler INSTANCE;
//
//    private Scheduler () {
//        new Scheduler();
//    }
//
//     public Scheduler getInstance () {
//         if (INSTANCE == null) {
//             INSTANCE = new Scheduler();
//         }
//         return INSTANCE;
//    } // close getInstance;
//
//    public Appointment response (AppointmentRequest appointmentRequest) {
//        Day matchedSlot = null;
//        Provider provider = null;
//        Iterator<Day> slots = Departments.INSTANCE.get(appointmentRequest.getDepartment()).openSlots();
//        Iterator<Provider> providers = Departments.INSTANCE.get(appointmentRequest.getDepartment()).getAvailableProviders();
//
//        while (slots.hasNext() && providers.hasNext()) {
//            Day day = slots.next();
//            provider = providers.next();
//            if (slotMatch(appointmentRequest.getDateTimeslot(), day) && providerMatch(appointmentRequest.getProvider(), provider)) {
//                if (ExamRooms.getInstance().iterator().hasNext()) {
//                    ExamRoom examRoom = ExamRooms.getInstance().iterator().next();
//                    if (provider.getAvailabilty(appointmentRequest.getDateTimeslot()).equals(Availability.OPEN)) {
//                        provider.setAvailabilty(appointmentRequest.getDateTimeslot());
//                        return new Appointment(
//                            SerialNumberGenerator.INSTANCE.assignNumber(),
//                            SerialNumberGenerator.INSTANCE.assignName(appointmentRequest),
//                            appointmentRequest.getDepartment(),appointmentRequest.getProvider(),
//                            examRoom,
//                            appointmentRequest.getDateTimeslot(),
//                            appointmentRequest.getPatient());
//                    }
//                }
//            }
//        }
//        return null;
//    }
//
//    private boolean slotMatch (Day a, Day b) { return a.equals(b); }
//    private boolean providerMatch (Provider a, Provider b) { return a.equals(b); }
} // end class Scheduler
