package org.example;

import org.example.datamodels.Candidate;
import org.example.datamodels.CertifiedCandidate;
import org.example.datamodels.interfaces.ICandidate;
import org.example.datamodels.interfaces.Person;

import java.util.Collection;
import java.util.HashSet;

public class CandidateFactory {
    
    ICandidate createCandidate(String firstName, String lastName, int age, int yearsOfExperience, String branch){
        return new Candidate(firstName,lastName, age,yearsOfExperience,branch);

    }

    ICandidate createCertifiedCandidate(String firstName, String lastName, int age, int yearsOfExperience, String branch, Collection<String> _certificates){
        return new CertifiedCandidate(firstName,lastName,age,yearsOfExperience,branch,new HashSet<String>(_certificates));
    }

}
