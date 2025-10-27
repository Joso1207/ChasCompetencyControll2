package org.example.datamodels;

import org.example.datamodels.interfaces.ICandidate;

public record Candidate(String name,int yearsOfExperience,String branch)
        implements ICandidate { }
