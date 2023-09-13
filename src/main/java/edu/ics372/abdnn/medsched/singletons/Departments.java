package edu.ics372.abdnn.medsched.singletons;

import edu.ics372.abdnn.medsched.abstracts.Person;
import edu.ics372.abdnn.medsched.containers.Bag;
import edu.ics372.abdnn.medsched.entities.Department;
import edu.ics372.abdnn.medsched.entities.ExamRoom;
import edu.ics372.abdnn.medsched.entities.Provider;
import edu.ics372.abdnn.medsched.interfaces.BagWrapper;
import edu.ics372.abdnn.medsched.interfaces.SingletonBagWrapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

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

    public void remove (Department department) {
        departments.remove(departments.indexOf(department));
    }

    @Override
    public int size () { return departments.size(); }

    @Override
    public Bag<Department> getBag () { return departments; }


    @Override
    public void add (Department department) { departments.add(department);}


    public Department pop (Department department) {
        for (Person person: department.getMembers().getBag().getContents()) {
            Provider provider = (Provider) person;
            provider.removeDepartment(department);
        }
        return departments.pop(department);
    } // close pop


    @Override
    public Iterator<Department> iterator () { return departments.iterator(); }

    @Override
    public Iterator<Department> filter (Predicate<Department> predicate) { return departments.filter(predicate); }

    public String toString () { return getBag().toString(); }
} // end class Departments
