package org.example;

import org.example.datamodels.filters.*;
import org.example.datamodels.interfaces.ICandidate;
import org.example.datamodels.sorters.NameSorter;
import org.example.menu.*;
import org.example.repository.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*This class is the actual "application" end with the business logic.
It's merely the "switch" or "state" of the program and has a responsibility to move the user from one part of the logic to the other.

Following the SRP, The only reason we would ever want to change this would be to change the logic, It does not however completely follow OCP.
As we would need to add the functionality into the switch case and also add the option as a valid menu option.
We could make it follow OCP by storing




 */
public class CandidateManagementApp {

    private Repository<ICandidate> repository;
    private OptionSelectionInterface menu;
    private UserInputInterface input;
    private CandidateFactory factory = new CandidateFactory();
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
