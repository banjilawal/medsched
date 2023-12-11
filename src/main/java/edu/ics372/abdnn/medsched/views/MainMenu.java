package edu.ics372.abdnn.medsched.views;

import edu.ics372.abdnn.medsched.core.concretes.*;
import edu.ics372.abdnn.medsched.facade.request.*;
import edu.ics372.abdnn.medsched.facade.response.*;

import java.util.*;

public class MainMenu {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("firstname:");
        String firstname = scanner.nextLine();

        System.out.print("lastname:");
        String lastname = scanner.nextLine();

        System.out.print("email:");
        String email = scanner.nextLine();

        System.out.print("password:");
        String password = scanner.nextLine();

        Patient patient = new Response().response(new CreatePatientRequest(firstname, lastname, password, email));
        System.out.println(patient.toString());

        scanner.close();
    }

}
