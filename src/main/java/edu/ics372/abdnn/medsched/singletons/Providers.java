package edu.ics372.abdnn.medsched.singletons;

import edu.ics372.abdnn.medsched.abstracts.Person;
import edu.ics372.abdnn.medsched.containers.Bag;
import edu.ics372.abdnn.medsched.entities.Period;
import edu.ics372.abdnn.medsched.entities.Provider;
import edu.ics372.abdnn.medsched.entities.Provider;
import edu.ics372.abdnn.medsched.interfaces.BagWrapper;

import java.util.Iterator;
import java.util.function.Predicate;

public enum Providers implements BagWrapper<Provider> {
    INSTANCE;
    private final Bag<Provider> providers = new Bag<Provider>();

    public boolean isOpen (Period period, Provider provider) { return true; }

    public Provider search (String name) { return providers.search(name); }
    public Provider search (int id) { return providers.search(id); }

    public Provider peek (String name) { return providers.peek(search(name)); }
    public Provider peek (int id) { return providers.peek(search(id)); }

    public Provider pop (String name) { return providers.pop(providers.search(name)); }
    public Provider pop (int id) { return providers.pop(providers.search(id)); }

    public void remove (String name) { remove(providers.search(name)); }
    public void remove (int id) { remove(providers.search(id)); }

    public void remove (Provider Provider) {
        providers.remove(providers.indexOf(Provider));
    }

    @Override
    public int size () { return providers.size(); }

    @Override
    public Bag<Provider> getBag () { return providers; }


    @Override
    public void add (Provider Provider) { providers.add(Provider);}


    @Override
    public Iterator<Provider> iterator () { return providers.iterator(); }

    @Override
    public Iterator<Provider> filter (Predicate<Provider> predicate) { return providers.filter(predicate); }
} // end class providers
