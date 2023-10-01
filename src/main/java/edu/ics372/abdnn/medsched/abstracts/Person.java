package edu.ics372.abdnn.medsched.abstracts;

import edu.ics372.abdnn.medsched.enums.*;

import java.util.Objects;

public abstract class Person extends NamedEntity {
    private String lastname;
    private Status status;

    public Person(int id, String firstname, String lastname) {
        super(id, firstname);
        this.lastname = lastname;
        this.status = Status.ACTIVE;
    } //

    public String getFirstname () {
        return getName();
    }

    public String getLastname () {
        return lastname;
    }


    public Status getStatus () {
        return status;
    }


    public void setFirstname (String firstname) { super.setName(firstname); }

    public void setLastname (String lastname) { this.lastname = lastname; }

    public void setStatus (Status status) { this.status = status; }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Person person) {
            return super.equals(person) && lastname.equalsIgnoreCase(person.getLastname());
        }
        return false;
    } // close equals


    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), lastname);
    }


    @Override
    public String toString () {
        return super.toString() + " lastname:" + lastname;
    }
} // end class Person