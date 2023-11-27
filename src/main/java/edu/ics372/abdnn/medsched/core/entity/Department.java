package edu.ics372.abdnn.medsched.core.entity;

import edu.ics372.abdnn.medsched.core.abstracts.*;
import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.enums.*;
import edu.ics372.abdnn.medsched.core.global.*;

import java.time.*;
import java.util.*;
import java.util.function.*;

public class Department extends Organization {
    private ArrayList<Staff> members;
    private ArrayList<Timeslot> calendar;
    private Status status;

    public Department (int id, String name) {
        super(id, name);
        this.members = new ArrayList<>();
        this.calendar = new ArrayList<>();
        this.status = Status.ACTIVE;
        initializeCalendar();
    } // close constructor


    public ArrayList<Staff> getMembers () {
        return members;
    }


    public ArrayList<Timeslot> getCalendar () {
        return calendar;
    }

    public Status getStatus () {
        return status;
    }


    public void setStatus (Status status) {
        this.status = status;
    }


    public Timeslot findTimeslot (Timeslot timeSlot) {
        if (calendar.contains(timeSlot))
            return calendar.get(calendar.indexOf(timeSlot));
        return null;
    }


    public boolean isTimeslotBooked (Timeslot timeSlot) {
        int index = calendar.indexOf(timeSlot);
        if (index < 0)
            throw new IllegalArgumentException("42: Period does not exist in department calendar");
        return calendar.get(index).getStatus().equals(TimeslotStatus.OPEN);
    }





    public boolean addMember (Staff member) {
        if (status.equals(Status.DELETED))
            throw new IllegalArgumentException("Cannot add members to deleted department");
        if (!members.contains(member)) {
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
                && appointment.getTimeslot().getDate().isAfter(startDate.minusDays(1))
                && appointment.getTimeslot().getDate().isBefore(endDate.plusDays(1));
        };
        return Appointments.INSTANCE.filter(predicate);
    }


    public ArrayList<Timeslot> getOpenings (LocalDate startDate, LocalDate endDate, LocalTime timeFloor, LocalTime timeCeiling) {
        Predicate<Timeslot> predicate = timeslot -> {
            return timeslot.getStatus().equals(TimeslotStatus.OPEN)
                && Timeslot.inDateTimeRange(timeslot,startDate,endDate,timeFloor,timeCeiling);
        };
        return filterCalendar(predicate);
    }


    public Map<Timeslot, ArrayList<Provider>> openTimeslotProviderMatches (LocalDate startDate, LocalDate endDate, LocalTime timeFloor, LocalTime timeCeiling) {
        HashMap<Timeslot, ArrayList<Provider>> map = new HashMap<>();

        for (Timeslot opening : getOpenings(startDate, endDate,timeFloor, timeCeiling)) {
            map.put(opening, new ArrayList<Provider>());
            for (Staff staff : members) {
                if (staff instanceof Provider provider)
                    if (provider.getOpenings(startDate, endDate).contains(opening) && !map.get(opening).contains(provider))
                        map.get(opening).add(map.get(opening).size(), provider);
            }
        }
        return map;
    }


    public ArrayList<Timeslot> getProviderOpenings (Provider provider, LocalDate startDate, LocalDate endDate) {
        int index = members.indexOf(provider);
        if (index >= 0) return provider.getOpenings(startDate, endDate);
        return null;
    }


    private ArrayList<Timeslot> filterCalendar (Predicate predicate) {
        ArrayList<Timeslot> matches = new ArrayList<>();
        for (Timeslot timeSlot : calendar) {
            if (predicate.test(predicate) && !matches.contains(timeSlot))
                matches.add(matches.size(), timeSlot);
        }
        return matches;
    }


    private void initializeCalendar () {

        Iterator<Timeslot> iterator = Timeslot.getTimeslots(
            Constant.INITIAL_CALENDAR_DATE,
            Constant.LAST_CALENDAR_DATE,
            Constant.OPENING_TIME,
            Constant.CLOSING_TIME
        ).iterator();

        while (iterator.hasNext()) {
            Timeslot timeslot = iterator.next();
            calendar.add(calendar.size(), timeslot);
        }

//        LocalDate date = Constant.INITIAL_CALENDAR_DATE;
//        for (int dayNumber = 0; dayNumber < Constant.CALENDAR_SIZE; dayNumber++) {
//            date = date.plusDays(dayNumber);
//
//            int timeslotNumber = 0;
//            LocalTime startTime = Constant.OPENING_TIME;
//            while (timeslotNumber < Constant.TIMESLOTS_PER_DAY) {
//                LocalTime endTime = startTime.plusMinutes(Constant.TIMESLOT_MINUTES);
//                calendar.add(calendar.size(), new Timeslot(date, startTime, endTime));
//            }
//        }
    }


    public void delete () {
    }


    public String toString () {
        String string = super.toString() + "\n";
        for (Timeslot timeslot : calendar) {
            string += timeslot.toString() + " " + timeslot.getStatus() + "\n";
        }
        return string;
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

    public Timeslot randTimeslot () {
        int index = (int) (Math.random() * (calendar.size() - 1));
        return calendar.get(index);
    }

} // end class
