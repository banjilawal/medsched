package edu.ics372.abdnn.medsched.catalogs;

import edu.ics372.abdnn.medsched.entities.*;

import java.util.*;
import java.util.function.*;

public enum Departments  {
    INSTANCE;
    private final ArrayList<Department> departments = new ArrayList<>();

    public Department search (String name) {
        for (Department department : departments) {
            if (department.getName().equalsIgnoreCase(name))
                return department;
        }
        return null;
    }


    public Department search (int id) {
        for (Department department : departments) {
            if (department.getId() == id)
                return department;
        }
        return null;
    }


    public boolean add (Department department) {
        if (search(department.getId()) == null && search(department.getName()) == null) {
            return departments.add(department);
        }
        return false;
    }


    public boolean remove (Department department) {
        if (search(department.getId()) != null || search(department.getName()) != null) {
            if (department.canDelete())
                return departments.remove(department);
        }
        return true;
    }


    public Iterator<Department> iterator () {
        return departments.iterator();
    }


    public Iterator<Department> filter (Predicate predicate) {
        ArrayList<Department> matches = new ArrayList<>();
        for (Department department: departments) {
            if (predicate.test(department) && !matches.contains(department))
                matches.add(matches.size(), department);
        }
        return matches.iterator();
    }
} // end class Departments
