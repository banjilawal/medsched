package edu.ics372.abdnn.medsched.core.populators;

import edu.ics372.abdnn.medsched.core.entities.Department;
import edu.ics372.abdnn.medsched.core.global.Constant;
import edu.ics372.abdnn.medsched.core.interfaces.Populator;
import edu.ics372.abdnn.medsched.core.catalogs.Departments;
import edu.ics372.abdnn.medsched.core.visitors.SerialNumberGenerator;

public enum DepartmentPopulator implements Populator  {
    INSTANCE;

    @Override
    public void populate () {
        for (int index = 0; index < Constant.DEPARTMENT_NAMES.length; index++) {
            Department department = new Department(
                SerialNumberGenerator.INSTANCE.departmentId(),
                Constant.DEPARTMENT_NAMES[index]);
//            System.out.println(department.toString());
            if (Departments.INSTANCE.add(department)) {
                System.out.println(department.toString());
            } else {
                System.out.println("Could not add department " + department.getName());
            }
        }
    }
} // end enum DepartmentPopulator
