package org.example.datamodels.interfaces;


//Builds onto person, Simply adding Experience and branch, Still capable of being sorted and handled like a person
//Ensuring Liskov is being followed,   Separating the three current interfaces also means we follow the Interface Segregation Principle

public interface ICandidate extends Person {
    int getYearsOfExperience();

    String getBranch();
}
