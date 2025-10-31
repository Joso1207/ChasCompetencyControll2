package org.example;

import org.example.datamodels.filters.*;
import org.example.datamodels.interfaces.ICandidate;
import org.example.datamodels.sorters.NameSorter;
import org.example.menu.*;
import org.example.repository.Repository;
import org.example.services.RepositoryPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CandidateManagementApp {

    private Repository<ICandidate> repository;
    private OptionSelectionInterface menu;
    private UserInputInterface input;
    private CandidateFactory factory = new CandidateFactory();
    private RepositoryPrinter<ICandidate> printer = new RepositoryPrinter<>();
    private final static Logger log = LoggerFactory.getLogger(CandidateManagementApp.class);

    CandidateManagementApp(Repository<ICandidate> repository, OptionSelectionInterface optionSel, UserInputInterface uin){
        this.repository = repository;
        this.menu = optionSel;
        this.input = uin;
    }


    public void run(){

        boolean running = true;
        while(running){
            menu.viewMenuOptions();
            switch(menu.selectMenuOption("Select a command","No Such command")){
                case "add" -> repository.add(factory.gatherCandidateInformation());
                case "remove" -> {try{
                        repository.remove(input.readNumberInput("Candidate ID?","Not a number"));
                    } catch (Exception e) {
                        log.error(e.getMessage());
                    }
                }
                case "printAll" -> repository.printAll();
                case "filterByBranch" -> repository.printFiltered(
                        BranchFilter.branchMatchesPredicate(
                            input.readTextInput("Name of branch","not a number")
                ));
                case "filterByExperience" -> repository.printFiltered(
                        ExperienceFilter.minimumYears(
                                input.readNumberInput("Minimum amount of years?","Not a number")
                        )
                );
                case "filterByCertificate" -> repository.printFiltered(CertificationFilter.hasCertificate(
                        input.readTextInput("Which certification?","")
                ));
                case "sortByName" -> repository.printSorted(NameSorter::alphabetical);

                case "quit" -> {return;}


            }

            input.readAny("Press Enter to Continue");

        }

    }





}
