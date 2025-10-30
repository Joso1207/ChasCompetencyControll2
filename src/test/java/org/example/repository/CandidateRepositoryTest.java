package org.example.repository;

import org.example.CandidateFactory;
import org.example.datamodels.filters.ExperienceFilter;
import org.example.datamodels.interfaces.ICandidate;
import org.example.datamodels.sorters.NameSorter;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CandidateRepositoryTest {








    @Test
    void filterToMap() {
        CandidateRepository repository = new CandidateRepository();
        CandidateFactory factory = new CandidateFactory();



        repository.addCandidate(factory.createCandidate("Norr","Smith",32,5,"Network"));
        repository.addCandidate(factory.createCertifiedCandidate("Knorr","svensson",50,10,"Network", List.of("Cisco")));
        repository.addCandidate(factory.createCertifiedCandidate("Janet","Abelsson",25,16,"IT", List.of("Cisco")));

        Map<Integer, ICandidate> newmap = repository.filterToMap(ExperienceFilter.minimumYears(15));
        assertEquals(1,newmap.size());



    }

    @Test
    void sortToList() {

        CandidateRepository repository = new CandidateRepository();
        CandidateFactory factory = new CandidateFactory();


        repository.addCandidate(factory.createCandidate("Norr","Smith",32,5,"Network"));
        repository.addCandidate(factory.createCertifiedCandidate("Abel","svensson",50,10,"Network", List.of("Cisco")));
        repository.addCandidate(factory.createCertifiedCandidate("Janet","Abelsson",25,16,"IT", List.of("Cisco")));

        assertEquals("Abel",repository.sortToList(NameSorter::alphabetical).getFirst().getValue().getFirstName());


    }
}