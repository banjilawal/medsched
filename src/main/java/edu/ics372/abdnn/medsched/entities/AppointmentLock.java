package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.LockEntity;
import edu.ics372.abdnn.medsched.abstracts.OwnerLock;
import edu.ics372.abdnn.medsched.abstracts.Room;

public class AppointmentLock extends LockEntity {
    Period period;
    Room room;
    Provider provider;
    Patient patient;

   public AppointmentLock (Period period, Provider provider, Patient patient, Room room) {
       this.period = period;
       this.provider = provider;
       this.patient = patient;
       this.room = room;
   }

} // end class RoomLock
