package org.example.datamodels.sorters;

import org.example.datamodels.interfaces.Person;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class NameSorter {

    @Contract(pure = true)
    public static int alphabetical(@NotNull Person a, Person b){
        return a.getFirstName().compareTo(b.getFirstName());
    }

    @Contract(pure = true)
    public static int reverseAlphabetical(@NotNull Person a, @NotNull Person b){
        return b.getFirstName().compareTo(a.getFirstName());
    }




}
