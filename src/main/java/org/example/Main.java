package org.example;

import org.example.datamodels.filters.BranchFilter;
import org.example.datamodels.filters.CertificationFilter;
import org.example.repository.CandidateRepository;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        CandidateRepository repository = new CandidateRepository();
        CandidateFactory factory = new CandidateFactory();
        repository.addCandidate(factory.createCandidate("Norr","Smith",32,10,"Network"));
        repository.addCandidate(factory.createCertifiedCandidate("Norr","svensson",50,10,"Network", List.of("Cisco")));
        repository.addCandidate(factory.createCertifiedCandidate("Janet","Abelsson",25,10,"IT", List.of("Cisco")));

        //BranchEqualsPredicate predicate = new BranchEqualsPredicate()
        System.out.println(repository.getFilteredToList(BranchFilter.branchMatchesPredicate("IT")));
        System.out.println(repository.getFilteredToList(CertificationFilter.isCertified()));
        System.out.println(repository.getFilteredToList(CertificationFilter.minimumCertifications(1)));



    }
}