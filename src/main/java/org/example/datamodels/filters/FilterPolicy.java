package org.example.datamodels.filters;


import org.example.datamodels.interfaces.ICandidate;

public interface FilterPolicy<T> {
    boolean policy(ICandidate a,T filter);
}
