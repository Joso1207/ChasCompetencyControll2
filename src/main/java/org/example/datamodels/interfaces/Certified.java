package org.example.datamodels.interfaces;


import java.util.Set;

//Another case of Interface segrataion, we only add this to classes with the certifications set,
//This is going to be candidates but might be expanded to include classes who use the person interface but not the ICandidate

public interface Certified extends Person {
    Set<String> certificates();
}
