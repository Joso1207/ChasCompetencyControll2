package org.example;

import org.example.datamodels.Candidate;
import org.example.datamodels.CertifiedCandidate;
import org.example.datamodels.interfaces.ICandidate;
import org.example.menu.TerminalMenu;
import org.example.menu.UserInputInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CandidateFactory {

    private final static Logger log = LoggerFactory.getLogger(CandidateFactory.class);
    
    public ICandidate createCandidate(String firstName, String lastName, int age, int yearsOfExperience, String branch){
        return new Candidate(firstName,lastName, age,yearsOfExperience,branch);

    }

    public ICandidate createCertifiedCandidate(String firstName, String lastName, int age, int yearsOfExperience, String branch, Collection<String> _certificates){
        return new CertifiedCandidate(firstName,lastName,age,yearsOfExperience,branch,new HashSet<>(_certificates));
    }

    public ICandidate gatherCandidateInformation(){
        CandidateFactory factory = new CandidateFactory();
        UserInputInterface IOReader = new TerminalMenu(System.in);

        String firstName = IOReader.readTextInput("First Name?","");
        String lastName = IOReader.readTextInput("Last Name?","");
        int age = IOReader.readNumberInput("Age of candidate","Please Enter a number");
        String branch = IOReader.readTextInput("What branch does the candidate work in","");
        int yearsInBranch = IOReader.readNumberInput("How long has candidate worked in the branch?","Not a number");

        Set<String> certifications = new HashSet<>();

        boolean moreCerts = true;
        while(moreCerts){

            String input = IOReader.readTextInput("Enter a certification, enter stop to break","");

            if(input.equals("stop")){
                moreCerts = false;
            } else{
                certifications.add(input);
            }
        }

        if(certifications.isEmpty()){
            return createCandidate(
                    firstName,lastName,age,yearsInBranch,branch
            );
        } else {
            return createCertifiedCandidate(
                    firstName,lastName,age,yearsInBranch,branch,certifications
            );
        }



    }


}
