package org.example.datamodels.filters;

import org.example.datamodels.interfaces.ICandidate;
import org.example.datamodels.interfaces.Person;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public class ExperienceFilter {

    @Contract(pure = true)
    public static @NotNull Predicate<ICandidate> minimumYears(int years){
        return candidate -> candidate.getYearsOfExperience() >= years;
    }

    @Contract(pure = true)
    public static @NotNull Predicate<ICandidate> maximumYears(int years){
        return candidate -> candidate.getYearsOfExperience() <= years;
    }




}
