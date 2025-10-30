package org.example;

import org.example.datamodels.filters.BranchFilter;
import org.example.datamodels.filters.CertificationFilter;
import org.example.menu.TerminalMenu;
import org.example.repository.CandidateRepository;
import org.example.services.RepositoryPrinter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<String> menuOptions = new ArrayList<>(Arrays.asList(
                "add","remove","all","printAll","filterByBranch","filterByExperience",
                "filterByCertificate","sortByName","quit"
        ));

        CandidateRepository repository = new CandidateRepository();
        CandidateFactory factory = new CandidateFactory();
        TerminalMenu menu = new TerminalMenu(menuOptions,System.in);
        System.out.println(menu.getMenuOptions());

        repository.addCandidate(factory.createCandidate("Norr","Smith",32,10,"Network"));
        repository.addCandidate(factory.createCertifiedCandidate("Norr","svensson",50,10,"Network", List.of("Cisco")));
        repository.addCandidate(factory.createCertifiedCandidate("Janet","Abelsson",25,10,"IT", List.of("Cisco")));


        CandidateManagementApp app = new CandidateManagementApp(repository,menu,menu);
        app.run();



    }
}