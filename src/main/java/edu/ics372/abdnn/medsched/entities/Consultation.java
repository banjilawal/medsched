package edu.ics372.abdnn.medsched.entities;

import java.time.LocalTime;

public class Consultation extends Appointment {
    public LocalTime checkInTime;
    public LocalTime checkOutTime;

    public Consultation (
            int id,
            String name,
            Department department,
            Provider provider,
            ExamRoom examRoom,
            Period period,
            Patient patient
        ) {
        super(id, name, provider, examRoom, period, department, patient);
        this.checkInTime = LocalTime.now();
        this.checkOutTime = LocalTime.now();;
    }

    public LocalTime getCheckInTime () { return checkInTime; }
    public LocalTime getCheckOutTime () { return checkOutTime; }



    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Consultation consultation) {
            return super.equals(consultation)
                && checkInTime.equals(consultation.getCheckInTime())
                && checkOutTime.equals(consultation.getCheckOutTime());
        }
        return false;
    }

    @Override
    public String toString () {
        return super.toString()
            + " check-in:" + checkInTime.toString()
            + " check-out:" + checkOutTime.toString();
    }
} // end class Consultation
