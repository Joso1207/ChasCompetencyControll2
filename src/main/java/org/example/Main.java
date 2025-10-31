package org.example;

import org.example.datamodels.interfaces.ICandidate;
import org.example.menu.TerminalMenu;
import org.example.repository.Repository;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Set<String> menuOptions = new HashSet<>(Set.of(
                "add","remove","all","printAll","filterByBranch","filterByExperience",
                "filterByCertificate","sortByName","quit"
        ));

        Repository<ICandidate> repository = new Repository<>();
        CandidateFactory factory = new CandidateFactory();
        TerminalMenu menu = new TerminalMenu(menuOptions,System.in);
        System.out.println(menu.getMenuOptions());

        repository.add(factory.createCandidate("John","Smith",32,10,"Network"));
        repository.add(factory.createCertifiedCandidate("Norr","svensson",50,10,"Network", List.of("Cisco")));
        repository.add(factory.createCertifiedCandidate("Janet","Abelsson",25,10,"IT", List.of("Cisco")));
        repository.add(factory.createCandidate("Light","Frennec",28,2,"Network"));
        repository.add(factory.createCandidate("Karen","Smith",62,20,"HR"));
        repository.add(factory.createCandidate("Tyler","Otherton",26,4,"Social service"));

        CandidateManagementApp app = new CandidateManagementApp(repository,menu,menu);
        app.run();



    }
}