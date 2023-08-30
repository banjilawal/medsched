package edu.ics372.abdnn.medsched.singletons;

import edu.ics372.abdnn.medsched.abstracts.NamedEntity;
import edu.ics372.abdnn.medsched.collections.Container;
import edu.ics372.abdnn.medsched.entities.Department;
import edu.ics372.abdnn.medsched.entities.ExamRoom;
import edu.ics372.abdnn.medsched.enums.RoomState;

import java.util.ArrayList;
import java.util.Iterator;

public enum Departments {
    INSTANCE;
    private Container<Department> container;

    Departments () {
        this.container = new Container<Department>();
    }
    public Container<Department> getContainer () { return container; }

} // end class
