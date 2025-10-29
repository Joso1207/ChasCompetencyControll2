package org.example.datamodels;

import org.example.datamodels.interfaces.ICandidate;
import org.example.datamodels.interfaces.Person;

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
}
