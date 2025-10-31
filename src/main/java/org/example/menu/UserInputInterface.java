package org.example.menu;


//An interface meant to allow for UserInput, But specifically to take the input stream and format it into usable data.
//Like mentioned in OptionSelectionInterface, We have segregated the behaviors in the two interfaces, allowing us to rely on DIP
//When we want to read user input we can use any implementation of this interface,
// and if we want the user to make selections we can use any implementation of OptionSelectionInterface
// We can have IO classes which use one but not the other,  or classes which implement both depending on our needs.

public interface UserInputInterface {

    String readTextInput(String message,String err);
    int readNumberInput(String message,String err);
    String readAny(String message);

}
