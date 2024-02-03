package edu.ics372.abdnn.medsched.views;

import edu.ics372.abdnn.medsched.core.concretes.*;
import edu.ics372.abdnn.medsched.core.exceptions.*;
import edu.ics372.abdnn.medsched.facade.request.*;
import edu.ics372.abdnn.medsched.facade.response.*;
import edu.ics372.abdnn.medsched.views.enums.*;

import java.util.*;

public class MainMenu {

    public static Provider createProvider () {
        Scanner scanner = new Scanner(System.in);
        Provider provider = null;

        System.out.print("select your department: ");
        String departmentName  = scanner.nextLine();

        System.out.print("firstname: ");
        String firstname = scanner.nextLine();

        System.out.print("lastname: ");
        String lastname = scanner.nextLine();

        System.out.print("password: ");
        String password = scanner.nextLine();
        String username = firstname.toLowerCase() + "." + lastname.toLowerCase();
        try {
            provider = new Response().response(new CreateProviderRequest(departmentName, firstname, lastname, username, password));
        } catch (UserCreationFailureException | RecordAdditionFailedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(provider.toString());
        scanner.close();
        return provider;
    }


    public static Provider loginProvider () {
        Scanner scanner = new Scanner(System.in);
        Provider provider = null;

        System.out.print("username: ");
        String username = scanner.nextLine();

        System.out.print("password :");
        String password = scanner.nextLine();
        try {
            provider = new Response().response(new ProviderLoginRequest(username,  password));
        } catch (AuthenticationFailureException e) {
            throw new RuntimeException(e);
        }
        System.out.println(provider.toString());
        scanner.close();
        return provider;
    }


    public static Patient createPatient () {
        Scanner scanner = new Scanner(System.in);
        Patient patient = null;
        System.out.print("firstname:");
        String firstname = scanner.nextLine();

        System.out.print("lastname:");
        String lastname = scanner.nextLine();

        System.out.print("email:");
        String email = scanner.nextLine();

        System.out.print("password:");
        String password = scanner.nextLine();
        try {
            patient = new Response().response(new CreatePatientRequest(firstname, lastname, password, email));
        } catch (UserCreationFailureException | RecordAdditionFailedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(patient.toString());
//        scanner.close();
        return patient;
    }


    public static Patient loginPatient () {
        Scanner scanner = new Scanner(System.in);
        Patient patient = null;
        System.out.print("email:");
        String email = scanner.nextLine();

        System.out.print("password:");
        String password = scanner.nextLine();
        try {
            patient = new Response().response(new PatientLoginRequest(email,password));
        } catch (AuthenticationFailureException e) {
            throw new RuntimeException(e);
        }
        System.out.println(patient.toString());
//        scanner.close();
        return patient;
    }


    public static Provider staffLoginMenu () {
        Scanner scanner = new Scanner(System.in);
        for (ProviderLoginOption option: ProviderLoginOption.values()) {
            System.out.println(option.ordinal() + 1 + ". " + option);
        }
        System.out.print("select your login option: ");
        int choice = scanner.nextInt();
        ProviderLoginOption option = ProviderLoginOption.values()[choice - 1];
        scanner.close();
        switch (option) {
            case LOGIN_PROVIDER -> {
                return loginProvider();
            }
            case CREATE_PROVIDER -> {
                return createProvider();
            }
        }
        return null;
    }


    public static Patient patientLoginMenu () {
        Scanner scanner = new Scanner(System.in);
        for (PatientLoginOption option: PatientLoginOption.values()) {
            System.out.println(option.ordinal() + 1 + ". " + option);
        }
        System.out.print("select your login option: ");
        int choice = scanner.nextInt();
        PatientLoginOption option = PatientLoginOption.values()[choice - 1];
        scanner.close();
        switch (option) {
            case LOGIN_PATIENT -> {
                return loginPatient();
            }
            case CREATE_PATIENT -> {
                return createPatient();
            }
        }
        return null;
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        Patient patient = null;
        Provider provider = null;

//        switch (UserCategory)

//        UserCategory userCategory = U;
//        userCategory.displayMenu();;

//        for (UserCategory userCategory: UserCategory.values()) {
//            System.out.println(userCategory.ordinal() + 1 + ". " + userCategory);
//        }
//        System.out.print("Please select if you are a patient or staff: ");
//        int userCategory = scanner.nextInt();
//        UserCategory selectedCategory = UserCategory.values()[userCategory - 1];
//        System.out.println("You selected: " + selectedCategory);
//        scanner.close();
//
//        switch (selectedCategory) {
//            case STAFF -> provider = staffLoginMenu();
//            case PATIENT -> patient = patientLoginMenu();
//        }
//
//        if (provider != null)
//            System.out.println(provider.toString());
//
//        if (patient != null)
//            System.out.println(patient.toString());
    }

}
