package org.example.repository;

import org.example.datamodels.Candidate;
import org.example.datamodels.interfaces.ICandidate;
import org.example.datamodels.interfaces.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CandidateRepository {

    Integer nextID = 0;
    Map<Integer, ICandidate> repository = new HashMap<>();

    public void addCandidate(ICandidate candidate){


        repository.put(nextID,candidate);
        nextID++;

    }

    public Person getCanditate(Integer key){
        return repository.get(key);
    }

    public void removeCandiate(Integer key){
        repository.remove(key);
    }

    public Map<Integer, ICandidate> getRepository(){
        return repository;
    }

    public List<Person> getAllToList(){
        return new ArrayList<>(repository.values());
    }


    /*

    The Following method and its implements has partially been shaped using LLMs
    to find better implementation.

    The final prompt was
    "I am programming in java and want to filter a repository with a filter class which needs to be defined when calling the method.
    It should return a list of filtered ICandidate from a repository and take the filter as a parameter.

    It gave me something like this
    "Currently I have this "public List<ICandidate> getFilteredToList(FilterPolicy<Type> filter,Type value){
    return repository.values().stream().filter(c->filter.policy(c, value)).toList(); }"

    And when adressed further on the issues that can occur it reccomended me to;
    *Define the generic as part of the method
    *Ensure non-null params
    *Possible exceptions that can occur (even outside Non-null params)
    *Backwards compability issues as toList() is not available in earlier versions (Used to be Collectors::toList())
    *Concurrency issues,  Not relevant due to the lack of multiple threads

    The type generic implementation means a developer cannot enter a type value that doesn't match the filterpolicy.

    I find it weird that it did not suggest predicates as an alternative but when pushed on it gave me a non-functional solution that used both filter interface and a predicate.
    After more pushing it finally came to the solution seen below.

    Furthermore, By keeping with the functional interfaces we can ensure that anyone use existant functionality when filtering.
    Either by doing as we are in this project, using static methods since we never really create these predicate returning objects.
    These methods are by definition "pure functions" that only returns something while not changing anything else.


     */

    public Map<Integer, ICandidate> getFilteredToList(Predicate<ICandidate> predicate){

        return repository.entrySet().stream()
                .filter(c-> predicate.test(c.getValue())).collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue
                ));


    }


}
