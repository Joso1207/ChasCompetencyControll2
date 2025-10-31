package org.example.menu;

import org.example.exceptions.ElementIsEmptyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;

//Our menu input/output class,  Its only purpose is to act as the bridge between user and program.
//Showcasing the implementation of our two relevant interfaces even if we could refactor this class into two separate ones,
//In my eyes, This implementation still only has a single purpose and follows SRP, So I will not do that
//However,  if we at a point wanted to implement a feature or class which only requires the functionality behind one interface we can obviously have a more limited class made for that purpose.

public class TerminalMenu implements OptionSelectionInterface,UserInputInterface {

    private final static Logger log = LoggerFactory.getLogger(TerminalMenu.class);

    private Set<String> menuOptions;
    private BufferedReader reader;

    public TerminalMenu(Set<String> menuOptions,InputStream in){
        reader = new BufferedReader(new InputStreamReader(in));
        this.menuOptions = menuOptions;
    }

    public TerminalMenu(InputStream in){
        reader = new BufferedReader(new InputStreamReader(in));
        this.menuOptions = null;
    }

    public String selectMenuOption(String message, String error) throws ElementIsEmptyException {
        if(menuOptions == null|| menuOptions.isEmpty()){
           log.error("No options included");
            throw new ElementIsEmptyException("Menu instance contains no viable options");
        }

        if(!message.isBlank()){
            System.out.println(message);
        }
        boolean validOption = false;
        String selectedOption = "";
        while(!validOption){
            try {
                String line = reader.readLine();
                if (menuOptions.contains(line)) {
                    selectedOption = line;
                    validOption = true;
                }else{
                    System.err.println("Not valid option");
                }
            }catch(IOException e){

                log.error(error);
                throw new RuntimeException();
            }
        }

        return selectedOption;
    }

    @Override
    public Set<String> getMenuOptions() {
        return menuOptions;
    }

    @Override
    public void viewMenuOptions() {
        menuOptions.forEach(System.out::println);
    }

    //Lets the user input text not defined in menuoptions.
    public String readTextInput(String message, String error){
        if(!message.isBlank()){
            System.out.println(message);
        }

        String input = "";
        while(input.isBlank()){
            try{input = reader.readLine();}
            catch(IOException e){
                log.error(error);
                throw new RuntimeException();
            }

        }

        return input;


    }

    //Same as previous,  But for numbers specifically.
    public int readNumberInput(String message, String error) {
        if (!message.isBlank()) {
            System.out.println(message);
        }

        int inputNumber = 0;
        String line;
        boolean validInput = false;
        while (!validInput) {
            try {
                line = reader.readLine();
                if (line.matches("[0-9]+")) {
                    inputNumber = Integer.parseInt(line);
                    validInput = true;
                }
            } catch (Exception e) {
                log.error(error);
                throw new RuntimeException();
            }

        }

        return inputNumber;

    }


    @Override
    public String readAny(String message){

        if (!message.isBlank()) {
            System.out.println(message);
        }

        String s = "";
        try{
            s = reader.readLine();
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return s;
    }

    public void setMenuOptions(Set<String> options) {
        this.menuOptions = options;
    }



}
