package edu.ics372.abdnn.medsched.catalogs;

import edu.ics372.abdnn.medsched.containers.*;
import edu.ics372.abdnn.medsched.entities.*;
import edu.ics372.abdnn.medsched.interfaces.*;

import java.util.*;
import java.util.function.*;

public enum Departments implements BagWrapper<Department> {
    INSTANCE;
    private final Bag<Department> departments = new Bag<Department>();

    public Department search (String name) { return departments.search(name); }
    public Department search (int id) { return departments.search(id); }

    public Department peek (String name) { return departments.peek(search(name)); }
    public Department peek (int id) { return departments.peek(search(id)); }

    public Department pop (String name) { return departments.pop(departments.search(name)); }
    public Department pop (int id) { return departments.pop(departments.search(id)); }

    public void remove (String name) { remove(departments.search(name)); }
    public void remove (int id) { remove(departments.search(id)); }

    @Override
    public int size () { return departments.size(); }

    @Override
    public Bag<Department> getBag () { return departments; }


    @Override
    public void add (Department department) { departments.add(department);}


    public void remove (Department department) {
        Iterator<Provider> iterator = department.getMembers();
        while (iterator().hasNext()) {
            Provider provider = iterator.next();
            department.removeMember(provider);
            provider.removeMembership(department);
        }
        departments.remove(departments.indexOf(department));
    } // close pop

//    public Department pop (Department department) {
//        Iterator<Provider> iterator = department.getMembers();
//        while (iterator().hasNext()) {
//            Provider provider = iterator.next();
//            department.removeMember(provider);
//            provider.removeMembership(department);
//        }
//        departments.
//    } // close pop


    @Override
    public Iterator<Department> iterator () { return departments.iterator(); }

    @Override
    public Iterator<Department> filter (Predicate<Department> predicate) { return departments.filter(predicate); }

    public String toString () { return getBag().toString(); }
} // end class Departments
