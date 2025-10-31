package org.example.datamodels;

import org.example.datamodels.interfaces.ICandidate;



//This class specifically isn't a record class as records cannot be extended, and we want inheritance in this scenario.
//Otherwise, this is just a datamodel,  it doesn't transform,change or do anything other than store the data relevant to its own instance.

//This means that for SRP its only purpose is to store its own data,  And thus the only reason to ever change it is if a change to the core datamodel occurs.
//For OCP we can always extend this class through composition or inheritance  Such as the CertifiedCandidate Class

public class Candidate implements ICandidate {
    protected String firstName;
    protected String lastName;
    protected int age;
    protected int yearsOfExperience;
    protected String branch;


    public Candidate(String firstName, String lastName, int age, int yearsOfExperience, String branch) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.yearsOfExperience = yearsOfExperience;
        this.branch = branch;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String getBranch() {
        return branch;
    }

    @Override
    public String toString() {
        return "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", yearsOfExperience=" + yearsOfExperience +
                ", branch='" + branch + '\'';
    }



}
