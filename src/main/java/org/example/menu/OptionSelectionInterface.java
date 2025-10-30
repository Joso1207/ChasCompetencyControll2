package org.example.menu;

import java.util.List;

public interface OptionSelectionInterface {

    void setMenuOptions(List<String> options);
    String selectMenuOption(String message, String error);
    List<String> getMenuOptions();
    void viewMenuOptions();

}
