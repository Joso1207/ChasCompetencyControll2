package org.example.repository;

import org.example.Main;
import org.example.datamodels.Candidate;
import org.example.datamodels.interfaces.ICandidate;
import org.example.datamodels.interfaces.Person;
import org.example.services.RepositoryPrinter;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CandidateRepository {

    private final static Logger log = LoggerFactory.getLogger(CandidateRepository.class);
    Integer nextID = 0;
    Map<Integer, ICandidate> repository = new HashMap<>();
    RepositoryPrinter printer = new RepositoryPrinter();

    public void addCandidate(ICandidate candidate){


        repository.put(nextID,candidate);
        nextID++;
        log.info("{} was added to repository", candidate.toString());

    }

    public Person getCanditate(Integer key){
        return repository.get(key);
    }

    public void removeCandiate(Integer key){
        log.info("Removed: {}", repository.remove(key));
    }

    public Map<Integer, ICandidate> getRepository(){
        return repository;
    }

    public List<Person> getAllToList(){
        return new ArrayList<>(repository.values());
    }

    public void printAll(){
        printer.print(repository);
    }

    public void printFiltered(Predicate<ICandidate> predicate){
        printer.print(filterToMap(predicate));
    }
    public void printSorted(Comparator<ICandidate> compare){
        printer.printSorted(repository,compare);
    }



    /*

    The Following method and its implements has partially been shaped using LLMs
    to find better implementation.

    The final prompt was
    "I am programming in java and want to filter a repository with a filter class which needs to be defined when calling the method.
    It should return a list of filtered ICandidate from a repository and take the filter as a parameter.

    it gave me this solution.
    "public List<ICandidate> getFilteredToList(FilterPolicy<Type> filter,Type value){
    return repository.values().stream().filter(c->filter.policy(c, value)).toList(); }"

    And when adressed further on the issues that can occur it reccomended me to;
    *Define the generic as part of the method
    *Ensure non-null params
    *Possible exceptions that can occur (even outside Non-null params)
    *Backwards compability issues as toList() is not available in earlier versions (Used to be Collectors::toList())
    *Concurrency issues,  Not relevant due to the lack of multiple threads

    At one point it suggested a type generic implementation with the reasoning that the type generic implementation means a developer cannot enter a type value that doesn't match the filterpolicy.
    But may use several types of filterpolicies targeting different types.


    I find it weird that it did not suggest predicates as an alternative but when pushed on it gave me a non-functional solution that used both filter interface and a predicate.
    After more pushing it finally came to the solution similar as the one seen below which i rewrote to fit the program. It dropped all mentions type generic
    which I agree as this is a repository specifically meant to handle objects of the ICandidate Interface.

    Furthermore, By keeping with the functional interfaces of Predicates we can ensure that anyone use existant functionality when filtering.
    Either by doing as we are in this project, using static methods since we never really create these predicate returning objects.
    These methods are by definition "pure functions" that only returns something while not changing anything else.


    After having cleared the window and begun a new instance I instead repeated from the start but made sure to bring up predicates and the context we have arrived at,
    it came back to this solution once more but both suggested and advised against extracting helpermethods. Specifically the predicate.test()

     */

    public Map<Integer, ICandidate> filterToMap(Predicate<ICandidate> predicate){

        log.info("returned a filtered map with predicate {}",predicate.getClass());
        return repository.entrySet().stream()
                .filter(c-> predicate.test(c.getValue())).collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue
                ));




    }

    public List<Map.Entry<Integer,ICandidate>> sortToList(Comparator<ICandidate> compare) {
        log.info("returned a filtered map with comparator {}",compare.getClass());
        return repository.entrySet().stream().sorted(
                (e1,e2)-> compare.compare(
                        e1.getValue(),e2.getValue()))
                .toList();
    }


}
