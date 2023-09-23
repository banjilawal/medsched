package edu.ics372.abdnn.medsched.catalogs;

import edu.ics372.abdnn.medsched.containers.Bag;
import edu.ics372.abdnn.medsched.entities.Patient;
import edu.ics372.abdnn.medsched.interfaces.BagWrapper;

import java.util.Iterator;
import java.util.function.Predicate;

public enum Patients implements BagWrapper<Patient> {
    INSTANCE;
    private final Bag<Patient> patients = new Bag<Patient>();

    public Patient search (String name) { return patients.search(name); }
    public Patient search (int id) { return patients.search(id); }

    public Patient peek (String name) { return patients.peek(search(name)); }
    public Patient peek (int id) { return patients.peek(search(id)); }

    public Patient pop (String name) { return patients.pop(patients.search(name)); }
    public Patient pop (int id) { return patients.pop(patients.search(id)); }

    public void remove (String name) { remove(patients.search(name)); }
    public void remove (int id) { remove(patients.search(id)); }

    public void remove (Patient Patient) { patients.remove(patients.indexOf(Patient)); }

    @Override
    public int size () { return patients.size(); }

    @Override
    public Bag<Patient> getBag () { return patients; }


    @Override
    public void add (Patient Patient) { patients.add(Patient);}


    @Override
    public Iterator<Patient> iterator () { return patients.iterator(); }

    @Override
    public Iterator<Patient> filter (Predicate<Patient> predicate) { return patients.filter(predicate); }
} // end class patients
