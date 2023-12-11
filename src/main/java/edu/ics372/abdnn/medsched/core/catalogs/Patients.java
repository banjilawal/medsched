package edu.ics372.abdnn.medsched.core.catalogs;

import edu.ics372.abdnn.medsched.core.entity.*;

import java.util.*;
import java.util.function.*;

public enum Patients {
    INSTANCE;
    private final ArrayList<Patient> patients = new ArrayList<>();


    public ArrayList<Patient> getPatients () {
        return patients;
    }


    public Patient search (int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id)
                return patient;
        }
        return null;
    }

    public Patient search (String email) {
        for (Patient patient : patients) {
            if (patient.getEmail().equalsIgnoreCase(email))
                return patient;
        }
        return null;
    }


    public Patient search (String firstname, String lastname, int id) {
        for (Patient patient : patients) {
            if (patient.getFirstname().equalsIgnoreCase(firstname)
                && patient.getLastname().equalsIgnoreCase(lastname)
                && patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }


    public boolean delete (Patient patient) {
        int index = patients.indexOf(patient);
        if (index < 0) return true;
        if (index >= 0) {
            return patients.get(index).delete();
        }
      return false;
    }


    public boolean add (Patient patient) {
        if (!patients.contains(patient))
            return patients.add(patient);
        return true;
    }


    public ArrayList<Patient> filter (Predicate<Patient> predicate) {
        ArrayList<Patient> matches = new ArrayList<>();
        for (Patient patient : patients) {
            if (predicate.test(patient) && !matches.contains(patient))
                matches.add(matches.size(), patient);
        }
        return matches;
    }

    public Patient rand () {
        int index = (int) (Math.random() * (patients.size() - 1));
        return patients.get(index);
    }
} // end class patients
