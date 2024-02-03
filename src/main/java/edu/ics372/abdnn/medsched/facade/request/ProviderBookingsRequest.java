package edu.ics372.abdnn.medsched.facade.request;

import java.time.*;


public class ProviderBookingsRequest {
    private String username;

    private LocalDate startDate;
    private LocalDate endDate;

    public ProviderBookingsRequest (String username, LocalDate startDate, LocalDate endDate) {
        this.username = username;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getUsername () {
        return username;
    }

    public LocalDate getStartDate () {
        return startDate;
    }


    public LocalDate getEndDate () {
        return endDate;
    }
} // end class CancelAppointmentRequest
