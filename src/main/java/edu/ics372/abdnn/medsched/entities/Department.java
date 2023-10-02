package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.*;
import edu.ics372.abdnn.medsched.catalogs.*;
import edu.ics372.abdnn.medsched.enums.*;
import edu.ics372.abdnn.medsched.global.*;

import java.nio.*;
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


    public boolean isPeriodBooked (Period period) {
        return calendar.contains(period)
            && calendar.get(calendar.indexOf(period)).getStatus().equals(BookingStatus.OPEN);
    }


    public Status getStatus () { return status; }


    public boolean addMember (Staff member) {
        if (status.equals(Status.DELETED))
            throw new IllegalArgumentException("Cannot add members to deleted department");
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


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Department department) return super.equals(department);
        return false;
    } // close equals


    public ArrayList<Appointment> getAppointments (LocalDate startDate, LocalDate endDate) {
        Predicate<Appointment> predicate = appointment -> {
            return appointment.getDepartment().equals(this)
                && appointment.getPeriod().getDate().isAfter(startDate.minusDays(1))
                && appointment.getPeriod().getDate().isBefore(endDate.plusDays(1));
        };
        return Appointments.INSTANCE.search(predicate);
    }


    public ArrayList<Period> getOpenings (LocalDate startDate, LocalDate endDate, LocalTime timeFloor, LocalTime timeCeiling) {
        Predicate<Period> predicate = period -> {
            return period.getStatus().equals(BookingStatus.OPEN)
                && period.inDateTimeRange(startDate, endDate, timeFloor, timeCeiling);
        };
        return filterCalendar(predicate);
    }


    public Map<Period, ArrayList<Provider>> openTimeslotProviderMatches (LocalDate startDate, LocalDate endDate, LocalTime timeFloor, LocalTime timeCeiling) {
        HashMap<Period, ArrayList<Provider>> map = new HashMap<>();

        for (Period opening : getOpenings(startDate, endDate,timeFloor, timeCeiling)) {
            map.put(opening, new ArrayList<Provider>());
            for (Staff staff : members) {
                if (staff instanceof Provider provider)
                    if (provider.getOpenings(startDate, endDate).contains(opening) && !map.get(opening).contains(provider))
                        map.get(opening).add(map.get(opening).size(), provider);
            }
        }
        return map;
    }


    public ArrayList<Period> getProviderOpenings (Provider provider, LocalDate startDate, LocalDate endDate) {
        if (isMember(provider)) {
            return provider.getOpenings(startDate, endDate);
        }
        return null;
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





} // end class
