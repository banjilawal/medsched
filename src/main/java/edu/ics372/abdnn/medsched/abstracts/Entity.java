package edu.ics372.abdnn.medsched.abstracts;

import java.util.Objects;

public abstract class Entity extends AnonymousEntity {
    private int id;

    public Entity (int id) {
        this.id = id;
    }

    public int getId () { return id; }

    public void setId (int id) { this.id = id; }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Entity entity) return id == entity.getId();
        return false;
    } // close equals;

    @Override
    public int hashCode () { return Objects.hash(id);}

    @Override
    public String toString () {
            return getClass().getSimpleName() + " id:" + id;
    } // close toString
} // end class Entity
