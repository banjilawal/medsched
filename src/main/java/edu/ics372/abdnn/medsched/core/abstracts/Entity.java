/**
 * Extends <code>AEntity</code>.
 *
 * @param id int an immutable id for assuring objects have a unique identifier.
 */

package edu.ics372.abdnn.medsched.core.abstracts;

import edu.ics372.abdnn.medsched.core.abstracts.*;

import java.util.Objects;

public abstract class Entity extends AnonymousEntity {
    private final int id;

    public Entity (int id) {
        this.id = id;
    }

    public int getId () {
        return id;
    }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Entity entity) return id == entity.getId();
        return false;
    } // close equals;

    @Override
    public int hashCode () {
        return Objects.hash(id);
    }

    @Override
    public String toString () {
        return getClass().getSimpleName() + " id:" + id;
    }
} // end class Entity
