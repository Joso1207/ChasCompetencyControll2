package org.example.datamodels.filters;

import org.example.datamodels.interfaces.ICandidate;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public class NameFilter {

    @Contract(pure = true)
    public static @NotNull Predicate<ICandidate> firstNameContains(String seq){
        return c-> c.firstName().contains(seq);
    }

}
