package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.*;
import edu.ics372.abdnn.medsched.reservations.*;
import edu.ics372.abdnn.medsched.reserve.*;

import java.util.*;
import java.util.function.*;

public class Provider extends Person { // implements Schedule  {
    private final ArrayList<String> departments;

    public Provider (int id, String firstname, String lastname) {
        super(id, firstname, lastname);
        this.departments = new ArrayList<String>();
    } // close constructor

    public ArrayList<String> getDepartments () {
        return departments;
    }


    public Iterator<ProviderReservation>  getReservationPeriods () {
        Predicate<ProviderReservation> predicate = reservation -> { return reservation.getProviderId() == getId(); };
        return ProviderReservations.INSTANCE.filter(predicate);
    }


    public void addMemberships (ArrayList<Department> departments) {
        for (Department department : departments) { addMembership(department); }
    } // close addDepartments

    public void addMembership (Department department) {
        department.addMember(this);
        if (!departments.contains(department.getName()))
            departments.add(departments.size(), department.getName());
    } // close addDepartment

    public void removeMemberships (ArrayList<Department> departments) {
        for (Department department : departments) { removeMembership(department); }
    } // close removeDepartments


    public void removeMembership (Department department) {
        department.removeMember(this);
        int arrayIndex = departments.indexOf(department.getName());
        if (arrayIndex >= 0) departments.remove(arrayIndex);
    } // close removeDepartment

    public String printDepartments () {
        StringBuilder stringBuilder = new StringBuilder();
        for (String departmentName: departments) {
            stringBuilder.append(departmentName).append(", ");
        }
        return stringBuilder.delete((stringBuilder.length() - 1), stringBuilder.length()).toString();
    } // close printDepartmentNames
} // end class
