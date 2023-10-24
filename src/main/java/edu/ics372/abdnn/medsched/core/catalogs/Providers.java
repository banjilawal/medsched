package edu.ics372.abdnn.medsched.core.catalogs;

import edu.ics372.abdnn.medsched.core.entities.*;

import java.util.*;
import java.util.function.*;

public enum Providers {
    INSTANCE;
    private final ArrayList<Provider> providers = new ArrayList<>();

    Iterator<Provider> iterator () {
        return providers.iterator();
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
} // end class providers
