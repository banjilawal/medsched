package edu.ics372.abdnn.medsched.entities;

import edu.ics372.abdnn.medsched.abstracts.Organization;

public class Department extends Organization  {
    public Department (int id, String name) {
        super(id, name);
    }

    public void addMember (Provider provider) {
        super.addMember(provider);
    }

    public void removeMember (int id) {
        super.removeMember(id);
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Department department) return super.equals(department);
        return false;
    }

    @Override
    public int hashCode () {
        return super.hashCode();
    }
} // end class
