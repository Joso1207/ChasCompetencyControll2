package org.example.repository;

import com.sun.jdi.Value;
import org.example.datamodels.filters.FilterPolicy;
import org.example.datamodels.interfaces.ICandidate;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class CandidateRepository {

    Map<String,ICandidate> repository = new HashMap<>();

    public void addCandidate(ICandidate candidate){
        repository.put(candidate.name(),candidate);
    }

    public ICandidate getCanditate(String name){
        return repository.get(name);
    }

    public void removeCandiate(String name){
        repository.remove(name);
    }

    public Map<String,ICandidate> getRepository(){
        return repository;
    }

    public List<ICandidate> getAllToList(){
        return new ArrayList<>(repository.values());
    }


    /*

    The Following method and its implements has partially been shaped using LLMs
    to find better implementation.

    The final prompt was
    "I am programming in java and want to filter a repository with a filter class which needs to be defined when calling the method.
    Currently I have this public List<ICandidate> getFilteredToList(FilterPolicy<Type> filter,Type value){ return repository.values().stream().filter(c->filter.policy(c, value)).toList(); } What are the issues that can occur?"

    upon which it reccomended me to;
    *Define the generic as part of the method
    *Ensure non-null params
    *Possible exceptions that can occur (even outside Non-null params)
    *Backwards compability issues as toList() is not available in earlier versions (Used to be Collectors::toList())
    *Concurrency issues,  Not relevant due to the lack of multiple threads

    The type generic implementation means a developer cannot enter a type value that doesn't match the filterpolicy.

     */

    public <T> List<ICandidate> getFilteredToList(FilterPolicy<T> filter, T value){

        return repository.values().stream().filter(p-> filter.policy(p,value)).toList();

    }


}
