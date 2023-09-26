package edu.ics372.abdnn.medsched.catalogs;

import edu.ics372.abdnn.medsched.containers.*;
import edu.ics372.abdnn.medsched.entities.*;

import java.util.*;
import java.util.function.*;

public enum Patients {
    INSTANCE;
    private final Bag<Patient> patients = new Bag<Patient>();

    public Iterator<Patient> search (String firstname, String lastname) {
        Predicate<Patient> predicate = patient -> {
            return  patient.getFirstname().equalsIgnoreCase(firstname)
                && patient.getLastname().equalsIgnoreCase(lastname);
        };
        return patients.filter(predicate);
    }
    public Patient search (int id) { return patients.search(id); }

    public void remove (int id) { remove(patients.search(id)); }

    public void remove (Patient Patient) { patients.remove(patients.indexOf(Patient)); }


    public int size () { return patients.size(); }


    public Bag<Patient> getBag () { return patients; }



    public void add (Patient Patient) { patients.add(Patient);}



    public Iterator<Patient> iterator () { return patients.iterator(); }


    public Iterator<Patient> filter (Predicate<Patient> predicate) { return patients.filter(predicate); }
} // end class patients
