package edu.ics372.abdnn.medsched.catalogs;

import edu.ics372.abdnn.medsched.entities.Period;
import edu.ics372.abdnn.medsched.entities.*;

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


    public ArrayList<Appointment> search (Provider provider, Period period) {
        Predicate<Appointment> predicate = appointment -> {
            return appointment.getProvider().equals(provider) && appointment.getPeriod().equals(period);
        };
        return search(predicate);
    }


    public boolean add (Appointment appointment) {
        if (!appointments.contains(appointment)) {
            return appointments.add(appointment);
        }
        return true;
    }


    public Iterator<Appointment> iterator () { return appointments.iterator(); }


    public ArrayList<Appointment> search (Predicate<Appointment> predicate) {
        ArrayList<Appointment> matches = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (predicate.test(appointment) && !matches.contains(appointment))
                matches.add(matches.size(), appointment);
        }
        return matches;
    }


    public Iterator<Appointment> filter (Predicate<Appointment> predicate) {
        ArrayList<Appointment> matches = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (predicate.test(appointment) && !matches.contains(appointment))
                matches.add(matches.size(), appointment);
        }
        return matches.iterator();
    }
} // end class Appointments
