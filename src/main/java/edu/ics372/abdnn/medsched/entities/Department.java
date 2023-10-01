package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.*;
import edu.ics372.abdnn.medsched.catalogs.*;
import edu.ics372.abdnn.medsched.catalogs.Calendar;
import edu.ics372.abdnn.medsched.enums.*;
import edu.ics372.abdnn.medsched.global.*;
import edu.ics372.abdnn.medsched.visitors.*;

import java.lang.reflect.*;
import java.time.*;
import java.util.*;
import java.util.function.*;

public class Department extends Organization {
    private ArrayList<Staff> members;
    private ArrayList<Period> calendar;
    private Status status;

    public Department (int id, String name) {
        super(id, name);
        this.members = new ArrayList<>();
        this.calendar = new ArrayList<>();
        this.status = Status.ACTIVE;
        initializeCalendar();
    } // close constructor


    public ArrayList<Period> getCalendar () {
        return calendar;
    }


    public Period findPeriod (Period period) {
        if (calendar.contains(period))
            return calendar.get(calendar.indexOf(period));
        return null;
    }


    public boolean periodBooked (Period period) {
        return calendar.contains(period)
            && calendar.get(calendar.indexOf(period)).getStatus().equals(BookingStatus.OPEN);
    }

    public Status getStatus () { return status; }


    public boolean addMember (Staff member) {
        if (!members.contains(staff)) {
            return members.add(member);
        }
        return true;
    }


    public boolean removeMember (Staff member) {
        if (members.contains(member)) {
            return members.remove(member);
        }
        return true;
    }


    public boolean isMember (Staff employee) {
        return members.contains(employee);
    }


    public ArrayList<Appointment> getAppointments () { return appointments; }


    public ArrayList<Period> getOpenings (Provider provider) {
        ArrayList<Period> matches = new ArrayList<>();
        if
        for (Appointment appointment : appointments) {
            if (!provider.equals(appointment.getProvider()) && !matches.contains(appointment.getPeriod()))
                matches.add(matches.size(), period);
        }
        return matches;
    }


    public ArrayList<Period> getOpenings (LocalDate startDate, LocalDate endDate, LocalTime beginning, LocalTime end) {
        LocalDate a = startDate.minusDays(1);
        LocalDate b = endDate.plusDays(1);

        LocalTime t0 = beginning.minusHours(1);
        LocalTime tN = end.plusHours(1);
        Predicate<Period> predicate = period -> {
            return period.getStatus().equals(BookingStatus.OPEN) && period.withinRange(a, b, t0, tN);
        };
        return filterCalendar(predicate);
    }


    public ArrayList<Period> getBookings (LocalDate startDate, LocalDate endDate, LocalTime beginning, LocalTime end) {
        LocalDate a = startDate.minusDays(1);
        LocalDate b = endDate.plusDays(1);

        LocalTime t0 = beginning.minusHours(1);
        LocalTime tN = end.plusHours(1);
        Predicate<Period> predicate = period -> {
            return period.getStatus().equals(BookingStatus.BOOKED) && period.withinRange(a, b, t0, tN);
        };
        return filterCalendar(predicate);
    }


    private ArrayList<Period> filterCalendar (Predicate predicate) {
        ArrayList<Period> matches = new ArrayList<>();
        for (Period period : calendar) {
            if (predicate.test(predicate) && !matches.contains(period))
                matches.add(matches.size(), period);
        }
        return matches;
    }


    private void initializeCalendar () {
        LocalDate date = Constant.INITIAL_CALENDAR_DATE;
        for (int dayNumber = 0; dayNumber < Constant.CALENDAR_SIZE; dayNumber++) {
            date = date.plusDays(dayNumber);

            int timeslotNumber = 0;
            LocalTime startTime = Constant.OPENING_TIME;
            while (timeslotNumber < Constant.TIMESLOTS_PER_DAY) {
                LocalTime endTime = startTime.plusMinutes(Constant.TIMESLOT_MINUTES);
                calendar.add(calendar.size(), new Period(date, startTime, endTime));
            }
        }
    }


    public void delete () {
        if (appointments.isEmpty() && members.isEmpty()) {
            status = Status.DELETED;
        }
    }


//    public Iterator<Staff> getMembers () {
//        ArrayList<Provider> matches = new ArrayList<>();
//        for (Integer memberId : getMemberIds()) {
//            Provider member = Providers.INSTANCE.search(memberId);
//            if (!matches.contains(member)) {
//                matches.add(matches.size(), member);
//            }
//        }
//        return matches.iterator();
//    }
//
//
//    public Provider getMember (int providerId) {
//        if (getMemberIds().contains(providerId))
//            return Providers.INSTANCE.search(providerId);
//        return null;
//    }




//    public Iterator<Provider> getAvailableProviders () {
//        Predicate<Provider> predicate = provider -> provider.getAvailabilty().equals(State.OPEN);
//        return filterProviders(predicate);
//    } // close getAvailableProviders

//    public Iterator<Provider> filterProviders (Predicate<Provider> predicate) {
//        ArrayList<Provider> matches = new ArrayList<Provider>();
//        for (Person person : getMembers().getPeople()) {
//            Provider provider = (Provider) person;
//            if (predicate.test(provider) && !matches.contains(provider))
//                matches.add(matches.size(), provider);
//        }
//        return matches.iterator();
//    } // close filterProviders




//    @Override
//    public boolean equals (Object object) {
//        if (this == object) return true;
//        if (object == null) return false;
//        if (object instanceof Department department) return super.equals(department);
//        return false;
//    } // close equals
} // end class
