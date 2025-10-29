package org.example.datamodels.sorters;

import org.example.datamodels.interfaces.ICandidate;
import org.example.datamodels.interfaces.Person;

import java.util.Comparator;

public class ExperienceSorter {

    public static Comparator<ICandidate> mostExperience() {

        return Comparator.comparing(ICandidate::getYearsOfExperience);

    }



}
