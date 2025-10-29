package org.example.datamodels.filters;

import org.example.datamodels.interfaces.ICandidate;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public class BranchFilter {

    @Contract(pure = true)
    public static @NotNull Predicate<ICandidate> branchMatchesPredicate(String nameOfBranch){

        return candidate->candidate.branch().matches(nameOfBranch) ;

    }

    @Contract(pure = true)
    public static @NotNull Predicate<ICandidate> branchNameContainsStringPredicate(CharSequence seq){

        return candidate -> candidate.branch().contains(seq);

    }


}
