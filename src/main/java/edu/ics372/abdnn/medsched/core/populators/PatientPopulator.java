package edu.ics372.abdnn.medsched.core.populators;

import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.entities.*;
import edu.ics372.abdnn.medsched.core.global.*;
import edu.ics372.abdnn.medsched.core.interfaces.*;
import edu.ics372.abdnn.medsched.core.visitors.*;

public enum PatientPopulator implements Populator  {
    INSTANCE;

    @Override
    public void populate () {
        for (int index = 0; index < Constant.MINIMUM_PATIENT_COUNT; index++) {
            String firstname = Constant.randomFirstname();
            String lastname = Constant.randomLastname();
            String email = Constant.randomEmail(firstname, lastname);
            Patient patient = new Patient(
                SerialNumberGenerator.INSTANCE.patientId(),
                firstname,
                lastname,
                email
            );
            if (Patients.INSTANCE.add(patient)) {
                System.out.println(patient.toString());
            } else {
                System.out.print("Could not add patient " + patient);

            }
        }
    }
} // end enum PatientPopulator
