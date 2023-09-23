package edu.ics372.abdnn.medsched.catalogs;

import edu.ics372.abdnn.medsched.containers.Bag;
import edu.ics372.abdnn.medsched.entities.Appointment;
import edu.ics372.abdnn.medsched.entities.Patient;
import edu.ics372.abdnn.medsched.entities.Period;
import edu.ics372.abdnn.medsched.entities.Provider;
import edu.ics372.abdnn.medsched.interfaces.BagWrapper;

import java.util.Iterator;
import java.util.function.Predicate;

public enum Appointments implements BagWrapper<Appointment> {
    INSTANCE;
    private final Bag<Appointment> appointments = new Bag<Appointment>();

    public Appointment search (String name) { return appointments.search(name); }
    public Appointment search (int id) { return appointments.search(id); }

    public Appointment search (Patient patient, Period period) {
        for (Appointment appointment : appointments.getContents()) {
            if (appointment.getPatientId() == patient.getId() && appointment.getPeriod().equals(period))
                return appointment;
        }
        return null;
    }

    public Appointment search (Provider provider, Period period) {
        for (Appointment appointment : appointments.getContents()) {
            if (appointment.getHostId() == provider.getId() && appointment.getPeriod().equals(period))
                return appointment;
        }
        return null;
    }

    public Iterator<Appointment> getPatientAppointments (Patient patient) {
        Predicate<Appointment> predicate = appointment -> appointment.getPatientId() == patient.getId();
        return appointments.filter(predicate);
    }



    public Appointment peek (String name) { return appointments.peek(search(name)); }
    public Appointment peek (int id) { return appointments.peek(search(id)); }

    public Appointment pop (String name) { return appointments.pop(appointments.search(name)); }
    public Appointment pop (int id) { return appointments.pop(appointments.search(id)); }

    public void remove (String name) { remove(appointments.search(name)); }
    public void remove (int id) { remove(appointments.search(id)); }

    public void remove (Appointment appointment) {
        appointments.remove(appointments.indexOf(appointment));
    }

    @Override
    public int size () { return appointments.size(); }

    @Override
    public Bag<Appointment> getBag () { return appointments; }


    @Override
    public void add (Appointment Appointment) { appointments.add(Appointment);}



    @Override
    public Iterator<Appointment> iterator () { return appointments.iterator(); }

    @Override
    public Iterator<Appointment> filter (Predicate<Appointment> predicate) { return appointments.filter(predicate); }

    public String toString () { return getBag().toString(); }
} // end class Appointments
