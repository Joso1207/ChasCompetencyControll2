package org.example.datamodels;

import org.example.datamodels.interfaces.ICandidate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandidateTest {




    @Test
    void getFirstName() {
        ICandidate candidate = new Candidate("john","smith",20,20,"IT");
        assertEquals("john",candidate.getFirstName());
    }

    @Test
    void getLastName() {
        ICandidate candidate = new Candidate("john","smith",20,20,"IT");
        assertEquals("smith",candidate.getLastName());
    }

    @Test
    void getAge() {
        ICandidate candidate = new Candidate("john","smith",20,20,"IT");
        assertEquals(20,candidate.getAge());
    }

    @Test
    void getYearsOfExperience() {
        ICandidate candidate = new Candidate("john","smith",20,20,"IT");
        assertEquals(20,candidate.getYearsOfExperience());
    }

    @Test
    void getBranch() {
        ICandidate candidate = new Candidate("john","smith",20,20,"IT");
        assertEquals("IT",candidate.getBranch());
    }

    @Test
    void testToString() {
        ICandidate candidate = new Candidate("john","smith",20,20,"IT");
        assertEquals("firstName='" + "john" + '\'' +
                ", lastName='" + "smith" + '\'' +
                ", age=" + 20 +
                ", yearsOfExperience=" + 20 +
                ", branch='" + "IT" + '\'',candidate.toString());
    }
}