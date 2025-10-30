package org.example.services;

import org.example.datamodels.interfaces.ICandidate;
import org.example.repository.CandidateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.Map;

public class RepositoryPrinter {

    private final static Logger log = LoggerFactory.getLogger(RepositoryPrinter.class);

    public void print(Map<Integer,ICandidate> mapToPrint){

        if(mapToPrint.isEmpty()){
            log.error("No Entries");
        }

        mapToPrint.forEach( (p,c) -> System.out.println(
                "ID:" + p + " " + c.toString()
                )
        );
        log.info(":End of list:");
    }
    public void printSorted(Map<Integer,ICandidate> mapToPrint, Comparator<ICandidate> compare){

        if(mapToPrint.isEmpty()){
            log.error("No Entries to sort");
        }

        mapToPrint.entrySet().stream().sorted(
                        (e1,e2)-> compare.compare(
                                e1.getValue(),e2.getValue()))
                .forEach(System.out::println);
        log.info(":End of list:");
    }

}
