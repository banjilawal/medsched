/**
 *  @Author Banji Lawal
 *
 *  <code>Location</code> is the parent of all physical locations
 */

package edu.ics372.abdnn.medsched.core.abstracts;

public abstract class Location extends NamedEntity {

    public Location(int id, String name) {
        super(id, name);
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Location location)
            return super.equals(location);
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return super.hashCode();
    }
} // end class Location
