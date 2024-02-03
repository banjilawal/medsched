package edu.ics372.abdnn.medsched.views.enums;

import java.nio.channels.*;

public enum UserCategory {
    PATIENT,
    STAFF;


    public String description () {
        switch (this) {
            case PATIENT:
                return "Patient";
            case STAFF:
                return "Staff";
        }
        return null;
    }

    public void displayMenu () {
        for (UserCategory userCategory: UserCategory.values()) {
            System.out.println(userCategory.ordinal() + 1 + ". " + userCategory.description());
        }
        System.out.print("Please select if you are a patient or staff: ");
    }
} // end enum UserCategory
