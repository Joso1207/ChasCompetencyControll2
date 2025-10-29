package org.example;

import org.example.datamodels.Candidate;
import org.example.datamodels.CertifiedCandidate;
import org.example.datamodels.interfaces.ICandidate;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CandidateFactory {
    
    ICandidate createCandidate(String firstName,String lastName, int yearsOfExperience,String branch){
        return new Candidate(firstName,lastName,yearsOfExperience,branch);

    }

    ICandidate createCertifiedCandidate(String firstName,String lastName, int yearsOfExperience, String branch, Collection<String> _certificates){
        return new CertifiedCandidate(firstName,lastName,yearsOfExperience,branch,new HashSet<String>(_certificates));
    }

}
