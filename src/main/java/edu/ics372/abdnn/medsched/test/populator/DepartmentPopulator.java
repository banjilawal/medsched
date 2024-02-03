package edu.ics372.abdnn.medsched.test.populator;

import edu.ics372.abdnn.medsched.core.concretes.*;
import edu.ics372.abdnn.medsched.core.exceptions.*;
import edu.ics372.abdnn.medsched.core.global.Constant;
import edu.ics372.abdnn.medsched.core.interfaces.Populator;
import edu.ics372.abdnn.medsched.core.catalogs.Departments;
import edu.ics372.abdnn.medsched.core.visitors.*;
import edu.ics372.abdnn.medsched.facade.request.*;
import edu.ics372.abdnn.medsched.facade.response.*;

public enum DepartmentPopulator implements Populator  {
    INSTANCE;

    @Override
    public void populate () {
        for (int index = 0; index < Constant.DEPARTMENT_NAMES.length; index++) {
            String name = Constant.DEPARTMENT_NAMES[index];
            Response response = new Response();
            Department department = null;
            try {
                department = response.response(new CreateDepartmentRequest(name));
            } catch (DuplicateEntityException | RecordAdditionFailedException e) {
                throw new RuntimeException(e);
            }
            if (department == null) {
                System.out.println("Could not add " +  name + " department");
            }
        }
    }
} // end enum DepartmentPopulator
