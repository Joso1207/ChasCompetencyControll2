package org.example.repository;

import org.example.datamodels.interfaces.ICandidate;
import org.example.datamodels.interfaces.Person;
import org.example.services.RepositoryPrinter;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
Note the change from CandidateRepository to a type-generic repository in the commits, which can take any type or interface

While the use of interfaces are important to OCP and DIP, being able to have a repository utilising any interface means its open to extention and reuse in other environments.
If we later end up wanting the Repository to perform candidate specific operations and methods we can extend through the means available to us.
Be it inheritance or composition

 */
public class Repository<T> {

    private final static Logger log = LoggerFactory.getLogger(Repository.class);
    Integer nextID = 0;
    Map<Integer, T> repository = new HashMap<>();
    RepositoryPrinter<T> printer = new RepositoryPrinter<T>();

    public void add(T entry){


        repository.put(nextID,entry);
        nextID++;
        log.info("{} was added to repository", entry.toString());

    }

    public T get(Integer key){
        return repository.get(key);
    }

    public void remove(Integer key){
        log.info("Removed: {}", repository.remove(key));
    }

    public Map<Integer, T> getRepository(){
        return repository;
    }

    public List<T> getAllToList(){
        return new ArrayList<>(repository.values());
    }

    public void printAll(){
        printer.print(repository);
    }

    public void printFiltered(Predicate<T> predicate){
        printer.print(filterToMap(predicate));
    }
    public void printSorted(Comparator<T> compare){
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

    I tried a few more times with different prompts such as how one could improve this code, or presenting it similar to the first but with the context of predicates.
    It refused to bring another solution other than those which would not work, such as hardcoding predicates into the function, or separate helper functions to an absurd degree.
    Where both Filter and Collect became class methods.

     */

    public Map<Integer, T> filterToMap(Predicate<T> predicate){

        log.info("returned a filtered map with predicate {}",predicate.getClass());
        return repository.entrySet().stream()
                .filter(c-> predicate.test(c.getValue())).collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue
                ));
    }

    public List<Map.Entry<Integer,T>> sortToList(Comparator<T> compare) {
        log.info("returned a filtered map with comparator {}",compare.getClass());
        return repository.entrySet().stream().sorted(
                (e1,e2)-> compare.compare(
                        e1.getValue(),e2.getValue()))
                .toList();
    }


}
