package org.example.datamodels.interfaces;


// base interface from ICandidate, Refactored to allow for extention to the behavior to include others.
// Example; letting the system compare and match Candidates and Employees whom are both Persons incase the system
// is ever to match candidates with mentors or similar.
public interface Person {

    String getFirstName();
    String getLastName();
    int getAge();


}
