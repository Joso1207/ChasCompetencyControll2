package org.example.datamodels;

import org.example.datamodels.interfaces.Certified;

import java.util.Set;


/* A certified candidate is an extension of the Candidate Class, It merely is an extension
that provides a new method and field while remaining an instance of Candidate.

This form of usage is promoted by the Liskov Substitution Principle,
And it being an extension means we have followed the Open Closed Principle.

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



    /*
    Despite overriding the parent-class's function we follow Liskov since we arent changing the rules or "strictness" of the input/output with the overridden method.
    One of the 4 core rules behind Liskov Substitution Principle
     */
    @Override
    public String toString() {
        return super.toString() +
                " certificates=" + certificates;

    }
}
