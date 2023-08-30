package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.Person;
import edu.ics372.abdnn.medsched.singletons.Departments;

import java.util.ArrayList;

public class Provider extends Person  {
    private ArrayList<String> departments;

    public Provider (int id, String firstname, String lastname, Department department) {
        super(id, firstname, lastname);
        this.departments = new ArrayList<String>();
    } //

    public ArrayList<String> getDepartments () {
        return departments;
    }

    public void addDepartments (ArrayList<Department> departments) {
        for (Department department : departments) {
            addDeparment(department);
        }
    } //

    public void addDeparment (Department department) {
        Departments.INSTANCE.getContainer().add(department);
        department.addMember(this);
        if (!departments.contains(department.getName()))
            departments.add(departments.size(), department.getName());
    } //

    public void removeDepartments (ArrayList<Department> departments) {
        for (Department department : departments) {
            removeDeparment(department);

        }
    } //


    public void removeDeparment (Department department) {
        department.removeMember(this.getId());
        int arrayIndex = departments.indexOf(department.getName());
        if (arrayIndex >= 0) {
            departments.remove(arrayIndex);
        }
    }
} // end class
