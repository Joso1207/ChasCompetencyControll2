package org.example.services;

import org.example.datamodels.interfaces.ICandidate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.Map;

public class RepositoryPrinter<T> {

    private final static Logger log = LoggerFactory.getLogger(RepositoryPrinter.class);

    public void print(Map<Integer,T> mapToPrint){

        if(mapToPrint.isEmpty()){
            log.error("No Entries");
        }

        mapToPrint.forEach( (p,c) -> System.out.println(
                "ID:" + p + " " + c.toString()
                )
        );
        log.info(":End of list:");
    }
    public void printSorted(Map<Integer,T> mapToPrint, Comparator<T> compare){

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
