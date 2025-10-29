package org.example.datamodels;

import org.example.datamodels.interfaces.Certified;

import java.util.Set;


/* A certified candidate is an extention of the Candidate Class, It merely is an extention
that provides a new method and field while remaining an instance of Candidate.

This form of usage is promoted by the Liskov Substitution Principle

*/
public class CertifiedCandidate extends Candidate implements Certified {
    Set<String> certificates;

    public CertifiedCandidate(String firstName, String lastName, int age, int yearsOfExperience, String branch,Set<String> certificates) {
        super(firstName, lastName, age, yearsOfExperience, branch);
        this.certificates = certificates;
    }

    public Set<String> certificates() {
        return certificates;
    }
}
