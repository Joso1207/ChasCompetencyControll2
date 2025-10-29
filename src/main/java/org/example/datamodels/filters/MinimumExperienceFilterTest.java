package org.example.datamodels.filters;

import org.example.datamodels.interfaces.ICandidate;

public class MinimumExperienceFilterTest implements FilterPolicy<Integer>{


    public boolean policy(ICandidate a, Integer filter) {
        return filter < a.yearsOfExperience();
    }
}
