package org.example;

import org.example.datamodels.interfaces.ICandidate;
import org.example.menu.TerminalMenu;
import org.example.repository.Repository;

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

        Repository<ICandidate> repository = new Repository<>();
        CandidateFactory factory = new CandidateFactory();
        TerminalMenu menu = new TerminalMenu(menuOptions,System.in);
        System.out.println(menu.getMenuOptions());

        repository.add(factory.createCandidate("Norr","Smith",32,10,"Network"));
        repository.add(factory.createCertifiedCandidate("Norr","svensson",50,10,"Network", List.of("Cisco")));
        repository.add(factory.createCertifiedCandidate("Janet","Abelsson",25,10,"IT", List.of("Cisco")));


        CandidateManagementApp app = new CandidateManagementApp(repository,menu,menu);
        app.run();



    }
}