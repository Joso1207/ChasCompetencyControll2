package org.example.datamodels.filters;

import org.example.datamodels.interfaces.ICandidate;

public class BranchFilter implements FilterPolicy<String>{


    public boolean policy(ICandidate candidate,String nameOfBranch){
        return candidate.name().matches(nameOfBranch);
    }
}
