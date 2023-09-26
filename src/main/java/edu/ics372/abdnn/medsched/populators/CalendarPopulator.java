package edu.ics372.abdnn.medsched.populators;

import edu.ics372.abdnn.medsched.catalogs.*;
import edu.ics372.abdnn.medsched.entities.Period;
import edu.ics372.abdnn.medsched.entities.*;
import edu.ics372.abdnn.medsched.global.*;
import edu.ics372.abdnn.medsched.interfaces.*;
import edu.ics372.abdnn.medsched.visitors.*;

import java.time.*;

public enum CalendarPopulator  implements Populator  {
    INSTANCE;

    @Override
    public void populate () {
        for (Department department : Departments.INSTANCE.getBag().getContents()) {
            addPeriods(department);
        }
    } //


    public void addPeriods (Department department) {
        LocalDate date = Constant.INITIAL_CALENDAR_DATE;
        for (int dayNumber = 0; dayNumber < Constant.CALENDAR_SIZE; dayNumber++) {
            date = date.plusDays(dayNumber);

            int timeslotNumber = 0;
            LocalTime startTime = Constant.OPENING_TIME;
            while (timeslotNumber < Constant.TIMESLOTS_PER_DAY) {
                int timeslotId = timeslotNumber +  1;
                String timeslotName = "T-" + 1;
                LocalTime endTime = startTime.plusMinutes(Constant.TIMESLOT_MINUTES);
                Calendar.INSTANCE.add(
                    new Period(
                        SerialNumberGenerator.INSTANCE.assignNumber(this),
                        timeslotId,
                        timeslotName,
                        department,
                        date,
                        startTime,
                        endTime)
                );
            }
        }
    }
} // end enum CalendarPopulator
