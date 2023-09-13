package edu.ics372.abdnn.medsched.populators;

import edu.ics372.abdnn.medsched.entities.Day;
import edu.ics372.abdnn.medsched.global.Constant;

import java.time.LocalDate;
import java.util.ConcurrentModificationException;

public class CalendarPopulator  {
    public static void main (String[] args) {
        LocalDate date = Constant.INITIAL_CALENDAR_DATE;
        for (int index = 0; index < Constant.CALENDAR_SIZE; index++) {
            Day day = new Day((index +1), date.plusDays(index));
            System.out.println(day.toString());
        }
    }
} // end clas CalendarPopulator
