package org.example.datamodels;

import org.example.datamodels.interfaces.ICandidate;

public record Candidate(String firstName,String lastName,int age,int yearsOfExperience,String branch)
        implements ICandidate { }
