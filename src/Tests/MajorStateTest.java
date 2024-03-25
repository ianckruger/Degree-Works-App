package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import backend.Class;
import backend.MajorState;
import backend.Roadmap;
import backend.CsceState; // Import the concrete subclass you want to use

public class MajorStateTest {

    private MajorState majorState;

    @BeforeEach
    public void setUp() {
        Roadmap roadmap = new Roadmap("Computer Science"); // Pass major as a parameter
        majorState = new CsceState(roadmap); // Instantiate CsceState or another concrete subclass
    }

    @AfterEach
    public void tearDown() {
        majorState = null;
    }

    @Test
    void testMajorStateClear() {
        // Use an existing constructor and provide appropriate arguments
        majorState.getMajorClasses().add(new Class("CSCI101", "Introduction to Computer Science", "Course Title", UUID.randomUUID(), 3, "Application Area", new ArrayList<>(), "Course Description"));
        majorState.getCarolinaCore().add(new Class("ENGL101", "English Composition", "Course Title", UUID.randomUUID(), 3, "Application Area", new ArrayList<>(), "Course Description"));
        majorState.getElectives().add(new Class("ARTS101", "Introduction to Arts", "Course Title", UUID.randomUUID(), 3, "Application Area", new ArrayList<>(), "Course Description"));
        majorState.clear();
        assertTrue(majorState.getMajorClasses().isEmpty());
        assertTrue(majorState.getCarolinaCore().isEmpty());
        assertTrue(majorState.getElectives().isEmpty());
    }

    @Test
    void testMajorStateToString() {
        ArrayList<Class> majorClasses = new ArrayList<>();
        // Use an existing constructor and provide appropriate arguments
        majorClasses.add(new Class("CSCI101", "Introduction to Computer Science", "Course Title", UUID.randomUUID(), 3, "Application Area", new ArrayList<>(), "Course Description"));
        majorState.setMajorClasses(majorClasses);
        String expected = "\nMajor Classes: \n";
        expected += "CSCI101 - Introduction to Computer Science\n";

        assertEquals(expected, majorState.toString());
    }
}
