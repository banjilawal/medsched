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
            Departments.INSTANCE.add(
                new Department(
                    SerialNumberGenerator.INSTANCE.assignNumber(this),
                    Constant.DEPARTMENT_NAMES[index])
            );
        }
    }
} // end enum DepartmentPopulator
