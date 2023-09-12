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

    public Department get (Department department) { return departments.get(department); }

    public Iterator<Department> findByName (String name) {
        Predicate<Department> predicate = department -> name.equalsIgnoreCase(department.getName());
        return departments.filter(predicate);
    } //

    public Iterator<Department> findById (int id) {
        Predicate<Department> predicate = department -> id == department.getId();
        return departments.filter(predicate);
    } //
    @Override
    public int size () { return departments.size(); }

    @Override
    public Bag<Department> getBag () {
        return null;
    }


    @Override
    public void add (Department department) { departments.add(department);}

    @Override
    public Department pop (Department department) {
        for (Person person: department.getMembers().getPeople()) {
            Provider provider = (Provider) person;
            provider.removeDepartment(department);
        }
        return departments.pop(department);
    } // close pop

    @Override
    public Department peek (Department department) {
        return null;
    }

    @Override
    public void remove (Department department) { departments.add(department); }

    @Override
    public Iterator<Department> iterator () { return departments.iterator(); }

    @Override
    public Iterator<Department> filter (Predicate<Department> predicate) {
        ArrayList<Department> matches = new ArrayList<Department>();
        Iterator<Department> iterator = departments.iterator();
        while (iterator().hasNext()) {
            Department department = iterator.next();
            if (predicate.test(department) && !matches.contains(department))
                matches.add(matches.size(), department);
        }
        return matches.iterator();
    } // close filter
} // end class Departments
