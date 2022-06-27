package fact.it.supermarket.model;

import org.apache.catalina.valves.rewrite.InternalRewriteMap;

public class Person {

    //Raf Engelen
    //r0901812
    //1ITF02

    private String firstName;
    private String surName;


    public Person() {
    }

    public Person(String firstName, String surName) {
        this.firstName = firstName;
        this.surName = surName;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }


    public String toString(){
        return surName.toUpperCase() + ' ' + firstName;
    }
}
