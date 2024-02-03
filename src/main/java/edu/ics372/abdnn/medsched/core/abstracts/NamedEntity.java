/**
 * extends <code>Entity</code>
 */
package edu.ics372.abdnn.medsched.core.abstracts;

import edu.ics372.abdnn.medsched.core.abstracts.*;

import java.util.Objects;

public class NamedEntity extends Entity {
    private String name;

    public NamedEntity(int id, String name) {
        super(id);
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public void setName (String name) {
        this.name = name;
    }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof NamedEntity namedEntity) {
            return super.equals(namedEntity) && name.equalsIgnoreCase(namedEntity.getName());
        }
        return false;
    } // close equals


    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), name);
    }


    @Override
    public String toString () {
        return super.toString() + " name:" + name;
    }
} // end class
