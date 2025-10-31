package org.example.menu;

import java.util.List;

//An interface to allow for User inputs,
// Specifically it is used for menu classes which only wants the user to make a selection.
// Once more having Segregated the interfaces behind inputting new data and making selections.

public interface OptionSelectionInterface {

    void setMenuOptions(List<String> options);
    String selectMenuOption(String message, String error);
    List<String> getMenuOptions();
    void viewMenuOptions();

}
