/**
 *  @Author Banji Lawal
 *
 *  <code>Staff</code> is an abstract child of  <code>Person</code>. Instances of <code>Staff</code> represent people
 *  who are employees.
 *
 */

package edu.ics372.abdnn.medsched.core.abstracts;

public abstract class Staff extends Person {
    public Staff (int id, String firstname, String lastname) {
        super(id, firstname, lastname);
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Staff staff) {
            return super.equals(staff);
        }
        return false;
    }
} // end class Staff
