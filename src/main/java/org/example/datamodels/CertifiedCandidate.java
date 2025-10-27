package org.example.datamodels;

import org.example.datamodels.interfaces.ICandidate;

import java.util.Set;

public record
CertifiedCandidate(String name, int yearsOfExperience, String branch, Set<String> certificates)
        implements ICandidate { }
