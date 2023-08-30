package edu.ics372.abdnn.medsched.interfaces;

import java.time.LocalTime;
import java.util.Date;
import java.util.zip.DataFormatException;

public interface Scheduleable {
    public Date getDate ();
    public LocalTime getStartTime ();
    public LocalTime getEndTime ();

    public void setDate (Date date);
    public void setStartTime (LocalTime localTime);
    public void setEndTime (LocalTime localTime);
}
