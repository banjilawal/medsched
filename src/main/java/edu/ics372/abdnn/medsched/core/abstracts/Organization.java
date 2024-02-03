package edu.ics372.abdnn.medsched.core.abstracts;

public abstract class Organization extends NamedEntity {

    public Organization (int id, String name) {
        super(id, name);
    }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Organization organization) {
            return super.equals(organization);
        }
        return false;
    }


    @Override
    public String toString () {
        return super.toString();
    }
}