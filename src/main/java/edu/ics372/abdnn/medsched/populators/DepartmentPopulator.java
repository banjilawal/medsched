package edu.ics372.abdnn.medsched.populators;

import edu.ics372.abdnn.medsched.entities.Department;
import edu.ics372.abdnn.medsched.global.Constant;
import edu.ics372.abdnn.medsched.interfaces.Populator;
import edu.ics372.abdnn.medsched.catalogs.Departments;
import edu.ics372.abdnn.medsched.visitors.SerialNumberGenerator;

public enum DepartmentPopulator implements Populator  {
    INSTANCE;

    @Override
    public void populate () {
        for (int index = 0; index < Constant.DEPARTMENT_NAMES.length; index++) {
            Departments.INSTANCE.add(
                new Department(
                    SerialNumberGenerator.INSTANCE.assignNumber(this),
                    Constant.DEPARTMENT_NAMES[index])
            );
        }
    }
} // end enum DepartmentPopulator
