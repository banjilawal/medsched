package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.LockEntity;
import edu.ics372.abdnn.medsched.abstracts.OwnerLock;
import edu.ics372.abdnn.medsched.abstracts.Room;

public class AppointmentLock extends LockEntity {
    PeriodLock periodLock;
    RoomLock roomLock;
    OwnerLock lockOwner;
    PatientLock patientLock;

   public AppointmentLock (RoomLock roomLock, PatientLock patientLock) {
       this.roomLock = roomLock;
       this.patientLock = patientLock;
   }

   public RoomLock getRoomLock () { return roomLock; }
    public PatientLock getPatientLock() { return patientLock();}
} // end class RoomLock
