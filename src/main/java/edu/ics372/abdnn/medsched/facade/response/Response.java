package edu.ics372.abdnn.medsched.facade.response;

import edu.ics372.abdnn.medsched.core.abstracts.*;
import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.catalogs.reservations.*;
import edu.ics372.abdnn.medsched.core.concretes.*;
import edu.ics372.abdnn.medsched.core.concretes.reservation.*;
import edu.ics372.abdnn.medsched.core.exceptions.*;
import edu.ics372.abdnn.medsched.core.visitors.*;
import edu.ics372.abdnn.medsched.facade.request.*;

import java.util.*;

public class Response {

    public Provider response (ProviderLoginRequest request) throws AuthenticationFailureException {
        Provider provider = Providers.INSTANCE.search(request.getUsername());
        if (provider == null) {
            throw new AuthenticationFailureException(request.getUsername() + " user does not exist");
        }
        if (provider.getPassword().compareTo(request.getPassword()) != 0) {
            throw new AuthenticationFailureException("incorrect password or username");
        }
        return provider;
    }

    public Patient response (PatientLoginRequest request) throws AuthenticationFailureException {
        Patient patient = Patients.INSTANCE.search(request.getEmail());
        if (patient == null) {
            throw new AuthenticationFailureException(request.getEmail() + " user does not exist");
        }
        if (patient.getPassword().compareTo(request.getPassword()) != 0) {
            throw new AuthenticationFailureException("incorrect password or username");
        }
        return patient;
    }


    public ArrayList<String> response (DepartmentMembersRequest request) {
        ArrayList<String> answer = new ArrayList<>();
        Department department = Departments.INSTANCE.search(request.getDepartmentName());
        for (Staff member : department.getMembers()) {
            String name = member.getFirstname() + " " + member.getLastname();
            answer.add(answer.size(), name);
        }
        return answer;
    }


    public ArrayList<String> response (DepartmentNamesRequest request) {
        ArrayList<String> answer = new ArrayList<>();
        for (Department department : Departments.INSTANCE.getDepartments()) {
            String name = department.getName();
            if (!answer.contains(name)) {
                answer.add(answer.size(), name);
            }
        }
        return answer;
    }


    public Patient response (CreatePatientRequest request) {
        String message = "";
        if (Patients.INSTANCE.search(request.getEmail()) == null) {
            Patient patient = new Patient(
                SerialNumberGenerator.INSTANCE.patientId(),
                request.getFirstname(),
                request.getLastname(),
                request.getPassword(),
                request.getEmail()
            );
            try {
                boolean success = Patients.INSTANCE.add(patient);
                if (success) {
                    System.out.println("Successfully added " + patient.toString());
                    return patient;
                } else
                    message = "Adding provider " + patient.toString() + " failed";
            } catch (Exception e) {
                System.out.println(message);
                throw new RuntimeException(e);
            }
        }
        return null;
    }


    public Provider response (CreateProviderRequest request) {
        String message = "";
        if (Providers.INSTANCE.search(request.getUsername()) == null) {
            Provider provider = new Provider(
                SerialNumberGenerator.INSTANCE.providerId(),
                request.getFirstname(),
                request.getLastname(),
                request.getUsername(),
                request.getPassword()
            );
            provider.addDepartment(SearchRequest.departmentSearchRequest(request.getDepartmentName()));
            try {
                boolean success = Providers.INSTANCE.add(provider);
                if (success) {
                    System.out.println("Successfully added " + provider.toString());
                    return provider;
                } else
                    message = "Adding provider " + provider.toString() + " failed";
            } catch (Exception e) {
                System.out.println(message);
                throw new RuntimeException(e);
            }
        }
        return null;
    }


    public Department response (CreateDepartmentRequest request) {
        String message = "";
        if (Departments.INSTANCE.search(request.getDepartmentName()) == null) {
            Department department = new Department(SerialNumberGenerator.INSTANCE.departmentId(), request.getDepartmentName());
            try {
                boolean success = Departments.INSTANCE.add(department);
                if (success) {
                    System.out.println("Successfully added " + department.getName());
                    return department;
                } else
                    message = "Adding department " + department.getName() + " failed";

            } catch (Exception e) {
                System.out.println(message);
                throw new RuntimeException(e);
            }
        }
        return null;
    }


    public ExamRoom response (CreateExamRoomRequest request) {
        String message = "";
        if (ExamRooms.INSTANCE.search(request.getExamRoomName()) == null) {
            ExamRoom examRoom = new ExamRoom(SerialNumberGenerator.INSTANCE.examroomId(), request.getExamRoomName());
            try {
                boolean success = ExamRooms.INSTANCE.add(examRoom);
                if (success) {
                    System.out.println("Successfully added " + examRoom.getName());
                    return examRoom;
                } else
                    message = "Adding examRoom " + examRoom.getName() + " failed";
            } catch (Exception e) {
                System.out.println(message);
                throw new RuntimeException(e);
            }
        }
        return null;
    }



    public Appointment response (CreateAppointmentRequest request) {
        String message = "";
        ProviderReservation providerReservation = getProviderReservation(
            request.getDepartment(),
            request.getTimeSlot(),
            request.getProvider()
        );
        PatientReservation patientReservation = getPatientReservation(
            request.getDepartment(),
            request.getTimeSlot(),
            request.getPatient()
        );
        RoomReservation roomReservation = getRoomReservation(
            request.getDepartment(),
            request.getTimeSlot(),
            request.getExamRoom()
        );

        if (roomReservation != null && providerReservation != null && patientReservation != null) {
            System.out.println("got all reservations");
            Appointment appointment = new Appointment(
                SerialNumberGenerator.INSTANCE.appointmentId(),
                request.getProvider(),
                request.getExamRoom(),
                request.getTimeSlot(),
                request.getDepartment(),
                request.getPatient()
            );
            System.out.println(appointment.toString());
            try {
                boolean success = Appointments.INSTANCE.add(appointment);
                if (success) {
                    System.out.println("Successfully added " + appointment.getId());
                    try {
                        if (RoomReservations.INSTANCE.delete(roomReservation))
                            System.out.println("Successfully deleted " + roomReservation.toString());
                        else
                            message = "roomReservation deletion failed";
                    } catch (Exception e) {
                        System.out.println(message);
                        throw new RuntimeException(e);
                    }

                    try {
                        if (PatientReservations.INSTANCE.delete(patientReservation))
                            System.out.println("Successfully deleted " + patientReservation.toString());
                        else
                            message = "patientReservation deletion failed";
                    } catch (Exception e) {
                        System.out.println(message);
                        throw new RuntimeException(e);
                    }

                    try {
                        if (ProviderReservations.INSTANCE.delete(providerReservation))
                            System.out.println("Successfully deleted " + providerReservation.toString());
                        else
                            message = "providerReservation deletion failed";
                    } catch (Exception e) {
                        System.out.println(message);
                        throw new RuntimeException(e);
                    }
                    return appointment;
                } else
                    message = "Adding the appointment failed";
//            } catch (Exception e) {
//                System.out.println(message);
//                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
//            if (Appointments.INSTANCE.add(appointment)) {
//                RoomReservations.INSTANCE.delete(roomReservation);
//                PatientReservations.INSTANCE.delete(patientReservation);
//                ProviderReservations.INSTANCE.delete(providerReservation);
//                System.out.println(Appointments.INSTANCE.getAppointments().size());
//                return appointment;
//
//            }
        }
        return null;
    }


    private static RoomReservation getRoomReservation (Department department, Timeslot timeslot, ExamRoom examRoom) {
        return RoomReservations.INSTANCE.add(department, timeslot, examRoom);
    }

    private static ProviderReservation getProviderReservation (Department department, Timeslot timeslot, Provider provider) {
        return  ProviderReservations.INSTANCE.add(department, timeslot, provider);
    }

    private static PatientReservation getPatientReservation (Department department, Timeslot timeslot, Patient patient) {
        return PatientReservations.INSTANCE.add(department, timeslot, patient);
    }
} // end class Response
