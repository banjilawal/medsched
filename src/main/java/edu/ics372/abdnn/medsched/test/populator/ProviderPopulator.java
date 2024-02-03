package edu.ics372.abdnn.medsched.test.populator;

import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.concretes.*;
import edu.ics372.abdnn.medsched.core.exceptions.*;
import edu.ics372.abdnn.medsched.core.global.*;
import edu.ics372.abdnn.medsched.core.interfaces.*;
import edu.ics372.abdnn.medsched.core.visitors.*;
import edu.ics372.abdnn.medsched.facade.request.*;
import edu.ics372.abdnn.medsched.facade.response.*;

public enum ProviderPopulator implements Populator  {
    INSTANCE;

    @Override
    public void populate () {
        for (int index = 0; index < Constant.MINIMUM_PROVIDER_COUNT; index++) {
            Department department = Departments.INSTANCE.rand();
            String firstname = Constant.randomFirstname();
            String lastname = Constant.randomLastname();
            String username = firstname.toLowerCase() + "." + lastname.toLowerCase();
            String password = Constant.LETTERS[0];
            Response response = new Response();
            Provider provider = null;
            try {
                provider = response.response(
                    new CreateProviderRequest(
                        department.getName(),
                        firstname,
                        lastname,
                        username,
                        password
                    )
                );
            } catch (UserCreationFailureException | RecordAdditionFailedException e) {
                throw new RuntimeException(e);
            }
//            if (provider == null) {
//               System.out.println("provider " + username + " not created");
//           }
        }
    }
} // end enum ProviderPopulator
