package edu.ics372.abdnn.medsched.core.populators;

import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.entities.*;
import edu.ics372.abdnn.medsched.core.global.*;
import edu.ics372.abdnn.medsched.core.interfaces.*;
import edu.ics372.abdnn.medsched.core.visitors.*;

public enum ProviderPopulator implements Populator  {
    INSTANCE;

    @Override
    public void populate () {
        for (int index = 0; index < Constant.MINIMUM_PROVIDER_COUNT; index++) {
            String firstname = Constant.randomFirstname();
            String lastname = Constant.randomLastname();
            Provider provider = new Provider(
                SerialNumberGenerator.INSTANCE.providerId(),
                firstname,
                lastname
            );
            Department department = Departments.INSTANCE.rand();
            if (provider.addDepartment(department)) {
                if (Providers.INSTANCE.add(provider))
                    System.out.println(provider.toString());
                   for (Department d : provider.getDepartments()) {
                       System.out.print(department.getName() + " ");
                   }
            }
            System.out.println(provider);

        }
    }
} // end enum ProviderPopulator
