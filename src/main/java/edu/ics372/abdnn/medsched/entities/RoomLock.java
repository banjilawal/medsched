package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.LockEntity;
import edu.ics372.abdnn.medsched.abstracts.OwnerLock;
import edu.ics372.abdnn.medsched.abstracts.Room;

public class RoomLock extends LockEntity {
    PeriodLock periodLock;
    Room room;
    OwnerLock lockOwner;

   public RoomLock (PeriodLock periodLock, Room room) {
       this.lockOwner = periodLock.getLockOwner();
       this.room = room;
   }

   public PeriodLock getPeriodLock () { return periodLock; }
   public Room getRoom () { return room;}
} // end class RoomLock
