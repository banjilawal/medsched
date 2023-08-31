package edu.ics372.abdnn.medsched.singletons;

import edu.ics372.abdnn.medsched.containers.Bag;
import edu.ics372.abdnn.medsched.entities.Department;

public enum Departments {
    INSTANCE;
    private Bag<Department> bag;

    Departments () {
        this.bag = new Bag<Department>();
    }
    public Bag<Department> getBag () { return bag; }

} // end class
