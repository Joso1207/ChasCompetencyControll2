package org.example;

import org.example.datamodels.Candidate;
import org.example.datamodels.CertifiedCandidate;
import org.example.datamodels.interfaces.ICandidate;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CandidateFactory {
    
    ICandidate createCandidate(String name, int yearsOfExperience,String branch){
        return new Candidate(name,yearsOfExperience,branch);

    }

    ICandidate createCertifiedCandidate(String name, int yearsOfExperience, String branch, Collection<String> _certificates){
        return new CertifiedCandidate(name,yearsOfExperience,branch,new HashSet<String>(_certificates));
    }

}
