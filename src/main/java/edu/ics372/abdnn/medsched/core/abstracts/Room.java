/**
 *  @Author Banji Lawal
 *
 *  <code>Room</code> is a <code>Location</code> that has a maximum capacity of occupants.
 *
 *  Fields
 *  -------
 *  @param occupantCapacity <code>int</code> The maximum number of occupants
 *  @param occupants <code>ArrayList<Person></Person></code> the people in the room
 */

package edu.ics372.abdnn.medsched.core.abstracts;

import java.util.*;
public abstract class Room extends Location {

    private int occupantCapacity;
    private ArrayList<Person> occupants;


    public Room(int id, String name, int occupantCapacity) {
        super(id, name);
        this.occupantCapacity = occupantCapacity;
        this.occupants = new ArrayList<>();
    }

    public int getOccupantCapacity () {
        return occupantCapacity;
    }

    public ArrayList<Person> getOccupants () {
        return occupants;
    }


    public void setOccupantCapacity(int occupantCapacity) {
        this.occupantCapacity = occupantCapacity;
    }


    /**
     * Adds a new occupant from the room if the person was not already in the room. Returns false if the addition <code>false</code>
     * <code>true</code> otherwise
     * @param occupant Person
     * @return <code>boolean</code>
     */
    public boolean addOccupant (Person person) {
//        if (occupants.size() >= occupantCapacity) {
//             throw new("room " + getName() + " is at maximum capacity of " + occupantCapacity + ". Cannot add anyone");
//        }
        if (!occupants.contains(person) && occupants.size() < occupantCapacity)
            return occupants.add(person);
        else if (occupants.contains(person))
            return true;
        else
            return false;
    }



    /**
     * Removes an existing occupant from the room.  If the occupant existed and the removal fails returns <code>false</code>
     * otherwise returns <code>true</code>. If the occupant is not already present in the room return <code>true</code>
     * @param occupant Person
     * @return <code>boolean</code>
     */
    public boolean removeOccupant (Person occupant) {
        if (occupants.contains(occupant))
            return occupants.remove(occupant);
        else
            return true;
    }


    @Override
    public boolean equals (Object object) {
        if (object == this) return true;
        if (object == null) return false;
        if (object instanceof Room room) {
            return super.equals(room) && occupantCapacity == room.getOccupantCapacity();
        }
        return false;
    }


    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), occupantCapacity, occupants);
    }


    @Override
    public String toString () {
        return super.toString() + " capacity:" + occupantCapacity;
    }
} // end class Room
