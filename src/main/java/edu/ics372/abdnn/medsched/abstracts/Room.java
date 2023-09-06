package edu.ics372.abdnn.medsched.abstracts;

import edu.ics372.abdnn.medsched.containers.People;

import java.util.*;
public abstract class Room extends Location {
    private int occupantCapacity;
    private final People<Person> occupants;

    public Room(int id, String name, int occupantCapacity) {
        super(id, name);
        this.occupantCapacity = occupantCapacity;
        this.occupants = new People<Person>();
    } // close constructor

    public int getOccupantCapacity () {
        return occupantCapacity;
    }

//    public ArrayList<Person> getOccupants () {
//        return occupants.getPeople();
//    }

    public Iterator<Person> getOccupants () { return occupants.iterator(); }

    public void setOccupantCapacity(int occupantCapacity) {
        this.occupantCapacity = occupantCapacity;
    }

    public void addOccupants (ArrayList<Person> people) {
        for (Person person : people) { addOccupant(person); }
    } // close

    public void addOccupant (Person person) { occupants.add(person); }

    public void removeOccupants (ArrayList<Person> occupants) {
        for (Person occupant : occupants) { removeOccupant(occupant); }
    } // close

    public void removeOccupant (Person occupant) { occupants.remove(occupant); }

    @Override
    public boolean equals (Object object) {
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
        return super.toString()
            + " capacity:" + occupantCapacity + "\n" + occupants.toString();
    }
} // end class Room
