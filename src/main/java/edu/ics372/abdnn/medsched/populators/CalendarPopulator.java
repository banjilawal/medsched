package edu.ics372.abdnn.medsched.populators;

import edu.ics372.abdnn.medsched.entities.Day;
import edu.ics372.abdnn.medsched.global.Constant;
import edu.ics372.abdnn.medsched.interfaces.Populator;
import edu.ics372.abdnn.medsched.singletons.Calendar;
import edu.ics372.abdnn.medsched.visitors.SerialNumberGenerator;

import java.time.LocalDate;
import java.util.ConcurrentModificationException;

public enum CalendarPopulator  implements Populator  {
    INSTANCE;
    @Override
    public void populate () {
        LocalDate date = Constant.INITIAL_CALENDAR_DATE;
        for (int index = 0; index < Constant.CALENDAR_SIZE; index++) {
            Day day = new Day(SerialNumberGenerator.INSTANCE.assignNumber(this), date.plusDays(index));
            Calendar.INSTANCE.add(day);
            System.out.println(day.toString());
        }
    }
} // end enum CalendarPopulator
