package edu.ics372.abdnn.medsched.abstracts;

import edu.ics372.abdnn.medsched.entities.*;

import java.net.*;
import java.util.*;
public abstract class Room extends Location {

    private int occupantCapacity;
    private ArrayList<Person> occupants;

    public Room(int id, String name, int occupantCapacity) {
        super(id, name);
        this.occupantCapacity = occupantCapacity;
        this.occupants = new ArrayList<>();
    } // close constructor

    public int getOccupantCapacity () {
        return occupantCapacity;
    }

    public ArrayList<Person> getOccupants () {
        return occupants;
    }


    public void setOccupantCapacity(int occupantCapacity) {
        this.occupantCapacity = occupantCapacity;
    }


    public boolean addOccupant (Person person) {
        if (!occupants.contains(person) && occupants.size() < occupantCapacity)
            return occupants.add(person);
        else if (occupants.contains(person))
            return true;
        else
            return false;
    }


    public boolean removeOccupant (Person occupant) {
        if (occupants.contains(person))
            return occupants.remove(person);
        else if (!occupants.contains(person))
            return true;
        else
            return false;
    }

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
