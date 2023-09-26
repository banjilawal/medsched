package edu.ics372.abdnn.medsched.services;

import edu.ics372.abdnn.medsched.entities.*;
import edu.ics372.abdnn.medsched.reservations.*;

import java.util.function.*;

public class Response {
    private Request request;

    public Response (Request request) {
        this.request = request;
    }


    private boolean isProviderAvailable () {
        Predicate<Provider> predicate = provider -> {
            return request.getDepartmentMember()
        };
    }
} // end class Response
