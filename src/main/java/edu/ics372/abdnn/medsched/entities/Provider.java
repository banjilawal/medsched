package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.Person;
import edu.ics372.abdnn.medsched.enums.Availabilty;

import java.util.ArrayList;

public class Provider extends Person  {
    private final ArrayList<String> departmentNames;
    private Availabilty availabilty;
    private DurationLock lock;

    public Provider (int id, String firstname, String lastname) {
        super(id, firstname, lastname);
        this.departmentNames = new ArrayList<String>();
        this.availabilty = Availabilty.OPEN;
        this.lock = null;
    } // close constructor

    public ArrayList<String> getDepartmentNames () {
        return departmentNames;
    }

    public Availabilty getAvailabilty (ScheduleDate scheduleDate) {
        if (lock == null && availabilty.equals(Availabilty.OPEN)) return Availabilty.OPEN;
        if (lock != null && lock.getDuration().equals(scheduleDate)) return Availabilty.CLOSED;
    }


    public void setAvailabilty (ScheduleDate scheduleDate) {
        if (availabilty.equals(Availabilty.OPEN) && !lock.getDuration().equals(scheduleDate)) {
            lock = null;
            this.availabilty = Availabilty.OPEN;
        }
        else {
            lock = new DurationLock(scheduleDate);
            this.availabilty = Availabilty.CLOSED;
        }
    }

    public void addDepartments (ArrayList<Department> departments) {
        for (Department department : departments) { addDepartment(department); }
    } // close addDepartments

    public void addDepartment (Department department) {
        department.addMember(this);
        if (!departmentNames.contains(department.getName()))
            departmentNames.add(departmentNames.size(), department.getName());
    } // close addDepartment

    public void removeDepartments (ArrayList<Department> departments) {
        for (Department department : departments) { removeDepartment(department); }
    } // close removeDepartments


    public void removeDepartment (Department department) {
        department.removeMember(this);
        int arrayIndex = departmentNames.indexOf(department.getName());
        if (arrayIndex >= 0) departmentNames.remove(arrayIndex);
    } // close removeDepartment

    public String printDepartmentNames () {
        StringBuilder stringBuilder = new StringBuilder();
        for (String departmentName: departmentNames) {
            stringBuilder.append(departmentName).append(", ");
        }
        return stringBuilder.delete((stringBuilder.length() - 1), stringBuilder.length()).toString();
    } // close printDepartmentNames
} // end class
