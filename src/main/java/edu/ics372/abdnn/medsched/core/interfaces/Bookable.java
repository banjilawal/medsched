package edu.ics372.abdnn.medsched.core.interfaces;

import edu.ics372.abdnn.medsched.core.enums.*;

public interface Bookable {
    public BookingStatus getBookingStatus ();
    public void setBookingStatus (BookingStatus bookingStatus);
}
