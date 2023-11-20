
/**
 *  @Author Banji Lawal
 *  @Class AnonymousEntity
 *  Most objects in the application have <code>AnonymousEntity</code> as their parent.
*/
package edu.ics372.abdnn.medsched.core.abstracts;

public abstract class AnonymousEntity {
    @Override
    public String toString () {
        return getClass().getSimpleName();
    }
} // end class AnonymousEntity
