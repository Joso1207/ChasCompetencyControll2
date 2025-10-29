package org.example.datamodels.interfaces;


import java.util.Set;

public interface Certified extends Person {
    Set<String> certificates();
}
