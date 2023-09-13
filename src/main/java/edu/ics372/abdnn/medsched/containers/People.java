package edu.ics372.abdnn.medsched.containers;

import edu.ics372.abdnn.medsched.interfaces.BagWrapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public class People<Person> implements BagWrapper<Person> {
    private final Bag<Person> bag;

    public People () {
        this.bag = new Bag<>();
    } // close constructor;

    @Override
    public int size () { return bag.size(); }

    @Override
    public Bag<Person> getBag () { return bag; }

    @Override
    public void add (Person person) { bag.add(person); }



    @Override
    public Person pop (int id) { return bag.pop(bag.search(id)); }

    @Override
    public Person pop (String firstname) { return bag.pop(bag.search(firstname)); }

    @Override
    public Person peek (int id) { return bag.peek(bag.search(id)); }

    @Override
    public Person peek (String name)  { return bag.peek(bag.search(name)); }

    @Override
    public void remove (int id) { bag.getContents().remove(bag.search(id)); }

    @Override
    public void remove (String name) { bag.remove(bag.search(name)); }

    @Override
    public void remove (Person person) { bag.remove(person); }


    @Override
    public Iterator<Person> iterator () { return bag.iterator(); }

//    public ArrayList<Person> getPeople () { return bag.getContents(); }

//    public Person find (String firstname, String lastname, int id) {
//        ArrayList<Person> people = bag.getContents();
//        for (Person person : people) {
//            if (match(person, firstname, lastname, id)) return person;
//        }
//        return null;
//    } // close find

//    public Iterator<Person> search (int id) {
//        Predicate<Person> predicate = person -> person.getId() == id;
//        return filter(predicate);
//    } //
//
//    public Iterator<Person> searchByNames (String firstname, String lastname) {
//        Predicate<Person> predicate = person -> namesMatch(person, firstname, lastname);
//        return filter(predicate);
//    } // close searchByNames

    @Override
    public Iterator<Person> filter (Predicate<Person> predicate) { return bag.filter(predicate); }

//    public Iterator<Person> searchById (int id) {
//        ArrayList<Person> people = new ArrayList<Person>();
//        for (Person person : bag.getContents()) {
//            if (id == person.getId() && !people.contains(person))
//                people.add(people.size(), person);
//        }
//        return people.iterator();
//    } // close searchById

//    public Iterator<Person> searchByNames (String firstname, String lastname) {
//        ArrayList<Person> people = new ArrayList<Person>();
//        for (Person person : bag.getContents()) {
//            if (namesMatch(person, firstname, lastname) && !people.contains(person))
//                people.add(people.size(), person);
//        }
//        return people.iterator();
//    } // close searchByNames

    public void addPeople (ArrayList<Person> people) {
        for (Person person : people) add(person);
    } // close addPeople


    @Override
    public String toString () {
        StringBuilder stringBuilder = new StringBuilder();
        for (Person person : bag.getContents()) {
            stringBuilder.append(person.toString()).append("\n");
        }
        return stringBuilder.toString();
    } // close toString
} // end class People
