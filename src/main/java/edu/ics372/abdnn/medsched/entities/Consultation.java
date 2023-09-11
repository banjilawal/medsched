package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.Meeting;

import java.time.LocalTime;
import java.util.Objects;

public class Consultation extends Appointment {
    public LocalTime actualStart;
    public LocalTime actualEnd;

    public Consultation (
            int id,
            String name,
            Department department,
            Provider provider,
            ExamRoom examRoom,
            ScheduleDate appointmentDate,
            Timeslot timeslot,
            Patient patient,
            LocalTime actualStart,
            LocalTime actualEnd
        ) {
        super(id, name, department, provider, examRoom, appointmentDate, timeslot, patient);
        this.actualStart = actualStart;
        this.actualEnd = actualEnd;
    }

    public LocalTime getActualStart () { return actualStart; }
    public LocalTime getActualEnd () { return actualEnd; }

    public void setActualStart (LocalTime actualStart) { this.actualStart = actualStart; }
    public void setActualEnd (LocalTime actualEnd) { this.actualEnd = actualEnd; }
} // end class Consultation
