package edu.ics372.abdnn.medsched.core.catalogs;

import edu.ics372.abdnn.medsched.core.entities.Period;
import edu.ics372.abdnn.medsched.core.entities.*;

import java.time.*;
import java.util.*;
import java.util.function.*;

public enum Appointments {
    INSTANCE;
    private final ArrayList<Appointment> appointments = new ArrayList<>();

    public Appointment search (Department department, LocalDate date, LocalTime startTime) {
        for (Appointment appointment : appointments) {
            if (appointment.getDepartment().equals(department) && appointment.getPeriod().inDateTimeRange(date,startTime))
                return appointment;
        }
        return null;
    }


    public Appointment search (ExamRoom examRoom, Period period) {
        for (Appointment appointment : appointments) {
            if (appointment.getExamRoom().equals(examRoom) && appointment.getPeriod().equals(period))
                return appointment;
        }
        return null;
    }


    public Appointment search (int id) {
        for (Appointment appointment : appointments) {
            if (appointment.getId() == id)
                return appointment;
        }
        return null;
    }


    public Appointment search (Department department, Patient patient, Period period) {
        for (Appointment appointment : appointments) {
            if (appointment.getDepartment().equals(department)
                && appointment.getPatient().equals(patient)
                && appointment.getPeriod().equals(period)) {
                return appointment;
            }
        }
        return null;
    }


    public ArrayList<Appointment> getBookings (Department department, LocalDate startDate, LocalDate endDate) {
        ArrayList<Appointment> matches = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (
                appointment.getDepartment().equals(department)
                && appointment.getPeriod().getDate().isAfter(startDate.minusDays(1))
                && appointment.getPeriod().getDate().isBefore(endDate.plusDays(1))
                && !matches.contains(appointment)
            )
                matches.add(matches.size(), appointment);
        }
        return matches;
    }


    public ArrayList<Appointment> getBookings (Provider provider, LocalDate startDate, LocalDate endDate) {
        ArrayList<Appointment> matches = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (
                appointment.getProvider().equals(provider)
                    && appointment.getPeriod().getDate().isAfter(startDate.minusDays(1))
                    && appointment.getPeriod().getDate().isBefore(endDate.plusDays(1))
                    && !matches.contains(appointment)
            )
                matches.add(matches.size(), appointment);
        }
        return matches;
    }


    public ArrayList<Appointment> getBookings (Patient patient, LocalDate startDate, LocalDate endDate) {
        ArrayList<Appointment> matches = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (
                appointment.getPatient().equals(patient)
                    && appointment.getPeriod().getDate().isAfter(startDate.minusDays(1))
                    && appointment.getPeriod().getDate().isBefore(endDate.plusDays(1))
                    && !matches.contains(appointment)
            )
                matches.add(matches.size(), appointment);
        }
        return matches;
    }


    public ArrayList<Appointment> search (Patient patient, LocalDate startDate, LocalDate endDate) {
        Predicate<Appointment> predicate = appointment -> {
            return appointment.getPatient().equals(patient)
                && appointment.getPeriod().getDate().isAfter(startDate.minusDays(1))
                && appointment.getPeriod().getDate().isBefore(endDate.plusDays(1));
        };
        return search(predicate);
    }

    public ArrayList<Appointment> search (Provider provider, LocalDate startDate, LocalDate endDate) {
        Predicate<Appointment> predicate = appointment -> {
            return appointment.getProvider().equals(provider)
                && appointment.getPeriod().getDate().isAfter(startDate.minusDays(1))
                && appointment.getPeriod().getDate().isBefore(endDate.plusDays(1));
        };
        return search(predicate);
    }


    public Appointment search (Patient patient, Period period) {
        for (Appointment appointment : appointments) {
            if (appointment.getPatient().equals(patient) && appointment.getPeriod().equals(period))
                return appointment;
        }
        return null;
    }

    public Appointment search (Provider provider, Period period) {
        for (Appointment appointment : appointments) {
            if (appointment.getProvider().equals(provider) && appointment.getPeriod().equals(period))
                return appointment;
        }
        return null;
    }


    public boolean add (Appointment appointment) {
        if (!appointments.contains(appointment)) {
            return appointments.add(appointment);
        }
        return true;
    }


    public ArrayList<Appointment> search (Predicate<Appointment> predicate) {
        ArrayList<Appointment> matches = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (predicate.test(appointment) && !matches.contains(appointment))
                matches.add(matches.size(), appointment);
        }
        return matches;
    }


    public boolean cancelAppointments (Patient patient) {
        boolean successfulCancellation = true;
        while (appointments.iterator().hasNext() && successfulCancellation) {
            Appointment appointment = appointments.next();
            if (appointment.getPatient().equals(patient) && appointment.getPeriod().getDate().isAfter(LocalDate.now())) {
                successfulCancellation = appointments.remove(appointment);
            }
        }
        return successfulCancellation;
    }
} // end class Appointments
