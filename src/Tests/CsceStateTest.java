package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import backend.Class;
import backend.CsceState;
import backend.Roadmap;

public class CsceStateTest {

    private CsceState csceState;

    @BeforeEach
    public void setUp() {
        Roadmap roadmap = new Roadmap("Computer Science"); // Create a Roadmap object with a major
        csceState = new CsceState(roadmap); // Instantiate CsceState with the Roadmap object
    }

    @AfterEach
    public void tearDown() {
        csceState = null;
    }

    @Test
    void testCsceStateLabScienceElective() {
        ArrayList<Class> labScienceElective = new ArrayList<>();
        labScienceElective.add(new Class("PHYS", "101", "Physics", null, 0, "", new ArrayList<>(), "Course Description", "")); // Use appropriate constructor
        labScienceElective.add(new Class("CHEM", "101", "Chemistry", null, 0, "", new ArrayList<>(), "Course Description", "")); // Use appropriate constructor
        csceState.setLabScienceElective(labScienceElective); // Set lab science electives
        assertEquals(2, csceState.getLabScienceElective().size()); // Check if the size matches
    }

    @Test
    void testCsceStateToString() {
        ArrayList<Class> labScienceElective = new ArrayList<>();
        labScienceElective.add(new Class("PHYS", "101", "Physics", null, 0, "", new ArrayList<>(), "Course Description", "")); // Use appropriate constructor
        csceState.setLabScienceElective(labScienceElective); // Set lab science electives
        String expected = "\nLab Science Electives: \n";
        expected += "PHYS101 - Physics\n"; // Expected string representation
        assertEquals(expected, csceState.toString()); // Check if the generated string matches the expected value
    }
}
