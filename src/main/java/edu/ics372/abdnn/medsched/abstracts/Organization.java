package edu.ics372.abdnn.medsched.abstracts;

import edu.ics372.abdnn.medsched.containers.People;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

public abstract class Organization extends NamedEntity {
    private final People<Person> members;

    public Organization (int id, String name) {
        super(id, name);
        this.members = new People<Person>();
    } // close constructor

    public Iterator<Person> iterator () { return members.iterator(); }

    public People<Person> getMembers () { return members; }

    public void addMember (Person member) {
        members.add(member);
    } //

    public void removeMember (Person person) { members.remove(person); } //


    public Iterator<Person> filter (Predicate<Person> predicate) { return members.filter(predicate); }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Organization org) {
            return super.equals(org);
        }
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), members);
    }

    @Override
    public String toString () {
        return super.toString() + " Members:\n" + members.toString();
    }

//    public boolean sameMembers (Organization organization) {
//        if (this == organization) return false;
//        if (organization == null) return false;
//        if (members.getPeople().size() != organization.getMembers().getPeople().size()) return false;
//        for (Person person : members.getPeople()) {
//            for (Person otherPerson : organization.getMembers().getPeople()) {
//                if (!person.equals(otherPerson)) return false;
//            }
//        }
//        return false;
//    } // close sameMembers
} // end class Organization
