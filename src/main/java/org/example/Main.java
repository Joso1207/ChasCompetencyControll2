package org.example;

import org.example.datamodels.filters.BranchFilter;
import org.example.repository.CandidateRepository;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        CandidateRepository repository = new CandidateRepository();
        CandidateFactory factory = new CandidateFactory();
        repository.addCandidate(factory.createCandidate("Norr",10,"IT"));

        //BranchEqualsPredicate predicate = new BranchEqualsPredicate()
        System.out.println(repository.getFilteredToList(BranchFilter.,"K"));



    }
}