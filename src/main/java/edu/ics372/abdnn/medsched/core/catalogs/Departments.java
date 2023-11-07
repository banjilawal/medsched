/**
 *  @Author Banji Lawal
 *
 *  <code>Departments</code> is responsible for storing all <code>Department</code> instances. All departments in the collection have
 *  unique names and ids. To maintain ACID <code>Departments</code> is a singleton
 *
 *  Operations
 *  -----------
 *      1. Deletion:
 *          To avoid side-effects deletion is not supported in the collection. Items in the collection have their status changed from 
 *          <code>Status.ACTIVE</code> to <code>Status.DELETED</code>
 *      2. Addition:
 *          A <code>Department</code> can be added to the collection if the name and id is not shared with an existing member
 *      3. Search:
 *          No direct access is provided to the catalog. Search methods return:
 *               * A single <code>Department</code> instance.
 *               * An subset of the collection as an ArrayList
 *               * An iterator which returns departments which match a search condition.
 *          The search methods are overloaded          
 *       
 *  Overloads
 *  ----------
 *  <code>department</code> methods fall into three categories, Two ot them are overloads. Overloads are:
 *      1. search -> returns a single instance <code><Appointment</code> instance if it exists for a <code>NamedEntity</code>
 *          during a <code>Period</code>
 *      2. getBookings -> returns  <code>ArrayList<Appointment></code>  of department booked with a <code>NamedEntity</code>
 *          The <code>getBookings</code>
 *
 *  Fields
 *  -------
 * @param  departments ArrayList should only be accessed with methods that either return an <code>ArrayList</code> or
 *      <code>Iterator</code>. No direct access is given
 *
 * TODO
 * -----
 * A method which prevents adding staff or appointments after a cutoff period. After the cutoff staff are removed and
 * the department's status is changed to <code>Status.DELETED</code>
 */
package edu.ics372.abdnn.medsched.core.catalogs;

import edu.ics372.abdnn.medsched.core.entities.*;
import edu.ics372.abdnn.medsched.core.enums.*;

import java.util.*;
import java.util.function.*;

public enum Departments  {
    INSTANCE;
    private final ArrayList<Department> departments = new ArrayList<>();


    /**
     * If a <code>Department</code> with <code>name</code> exists return it, otherwise return null.
     * @param name String
     * @return Department
     */
    public Department search (String name) {
        for (Department department : departments) {
            if (department.getName().equalsIgnoreCase(name))
                return department;
        }
        return null;
    }


    /**
     * If a <code>Department</code> with <code>id</code> exists return it, otherwise return null.
     * @param id int
     * @return Department
     */
    public Department search (int id) {
        for (Department department : departments) {
            if (department.getId() == id)
                return department;
        }
        return null;
    }


    /**
     * Add a department to the collection if there isn't one with the same name or id already
     * @param department
     * @return boolean
     */
    public boolean add (Department department) {
        if (!departments.contains(department))
            return departments.add(department);
        return false;
    }


    /**
     * Add a department to the collection if there isn't one with the same name or id already
     * @param department
     * @return void
     */
    public void delete (Department department) {
        int index = departments.indexOf(department);
        if (index >= 0) {
            departments.get(index).setStatus(Status.DELETED);
        }
    } //


    /**
     * If we need to filter departments by some predicate we can use this class.
     * @param predicate Predicate<Department>
     * @return Iterator<Department>
     */
    public Iterator<Department> filter (Predicate predicate) {
        ArrayList<Department> matches = new ArrayList<>();
        for (Department department: departments) {
            if (predicate.test(department) && !matches.contains(department))
                matches.add(matches.size(), department);
        }
        return matches.iterator();
    }
} // end class Departments
