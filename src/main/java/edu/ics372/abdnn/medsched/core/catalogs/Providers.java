/**
 *  @Author Banji Lawal
 *
 *  Providers stores all the providers. Like the other catalogs.
 *
 *  CRUD OPERATIONS
 *  ------------------------
 *  Adding and updating a provider's record is straightforward. Deleting a provider could create a cascade fo broken
 *  dependencies with previous appointments so instead of being removed from the collection the a provider is marked
 *
 *  Overloads
 *  ----------
 *  <code>Appointments</code> methods fall into three categories, Two ot them are overloads. Overloads are:
 *      1. search -> returns a single instance <code><Appointment</code> instance if it exists for a <code>NamedEntity</code>
 *          during a <code>Period</code>
 *      2. getBookings -> returns  <code>ArrayList<Appointment></code>  of appointments booked with a <code>NamedEntity</code>
 *          The <code>getBookings</code>
 *
 *  Fields
 *  -------
 * @param providers ArrayList should only be accessed with methods that either return an <code>ArrayList</code> or
 *      <code>Iterator</code>
 */

package edu.ics372.abdnn.medsched.core.catalogs;

import edu.ics372.abdnn.medsched.core.entity.*;

import java.util.*;
import java.util.function.*;

public enum Providers {
    INSTANCE;
    private final ArrayList<Provider> providers = new ArrayList<>();

    Iterator<Provider> iterator () {
        return providers.iterator();
    }

    public boolean add (Provider provider) {
        if (!providers.contains(provider)) {
            return providers.add(provider);
        }
        return false;
    }

    public boolean add (int id, String firstname, String lastname) {
        if (search(id) == null) {
            return providers.add(new Provider(id, firstname, lastname));
        }
        return false;
    }


    public Iterator<Provider> search(String firstname, String lastname) {
        Predicate<Provider> predicate = provider -> {
            return provider.getFirstname().equalsIgnoreCase(firstname)
                && provider.getLastname().equalsIgnoreCase(lastname);
        };
        return filter(predicate);
    }


    public Provider search (int id) {
        for (Provider provider : providers) {
            if (provider.getId() == id)
                return provider;
        }
        return null;
    }


    public Iterator<Provider> filter (Predicate<Provider> predicate) {
        ArrayList<Provider> matches = new ArrayList<>();
        for (Provider provider : providers) {
            if (predicate.test(provider) && !matches.contains(provider))
                matches.add(matches.size(), provider);
        }
        return matches.iterator();
    }


    public Provider rand () {
        int index = (int) (Math.random() * (providers.size() - 1));
        return providers.get(index);
    }
} // end class providers
