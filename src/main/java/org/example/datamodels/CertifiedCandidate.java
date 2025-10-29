package org.example.datamodels;

import org.example.datamodels.interfaces.ICandidate;

import java.util.Set;

public record
CertifiedCandidate(String firstName,String lastName,int age, int yearsOfExperience, String branch, Set<String> certificates)
        implements ICandidate { }
