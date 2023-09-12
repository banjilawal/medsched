package edu.ics372.abdnn.medsched.global;

import javafx.util.converter.LocalDateStringConverter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public final class Constant {
    public static int EXAM_ROOM_CAPACITY = 3;
    public static int MINIMUM_ENTITY_ID = 1;
    public static int TOTAL_TIMESLOTS = 9;
    public static int TIMESLOT_MINUTES = 50;
    public static int APPOINTMENT_SWITCH_OVER_TIME = 10;
    public static int CALENDAR_SIZE =50;
    public static LocalTime OPENING_TIME = LocalTime.of(8, 0, 0);
    public static LocalDate INITIAL_CALENDAR_DATE = LocalDate.of(2023, 12, 31);
} // end class Constant
