package edu.ics372.abdnn.medsched.test.populator;

import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.concretes.*;
import edu.ics372.abdnn.medsched.core.exceptions.*;
import edu.ics372.abdnn.medsched.core.global.*;
import edu.ics372.abdnn.medsched.core.interfaces.*;
import edu.ics372.abdnn.medsched.core.visitors.*;
import edu.ics372.abdnn.medsched.facade.request.*;
import edu.ics372.abdnn.medsched.facade.response.*;

public enum PatientPopulator implements Populator  {
    INSTANCE;

    @Override
    public void populate () {
        for (int index = 0; index < Constant.MINIMUM_PATIENT_COUNT; index++) {
            String firstname = Constant.randomFirstname();
            String lastname = Constant.randomLastname();
            String password = Constant.LETTERS[0];
            String email = Constant.randomEmail(firstname, lastname);
            Response response = new Response();
            Patient patient = null;
            try {
                patient = response.response(new CreatePatientRequest(firstname, lastname, password, email));
            } catch (UserCreationFailureException | RecordAdditionFailedException e) {
                throw new RuntimeException(e);
            }
//            if (patient == null) {
//                System.out.print("Could not add patient " + patient.getEmail());
//            }
        }
    }
} // end enum PatientPopulator
