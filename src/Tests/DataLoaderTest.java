package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.reporting.shadow.org.opentest4j.reporting.events.core.Data;

import backend.CourseList;
import backend.DataLoader;
import backend.DataWriter;
import backend.Roadmap;
import backend.Student;
import backend.User;
import backend.UserList;
import backend.Class;

public class DataLoaderTest {
    private UserList users = UserList.getInstance();
    private ArrayList<User> userList = users.getUsers();    
    private CourseList courses = CourseList.getInstance();
    private ArrayList<Class> classList = courses.getCourses();
    private Roadmap roadmap = Roadmap.getInstance();


    @BeforeEach
    public void setUp() {
        userList.clear();
		userList.add(new Student("asmith", "Amy", "Smith", "19", "Student"));
		userList.add(new Student("bwhite", "Bob", "White", "23", "Student"));
		DataWriter.saveUsers();

    }

    @AfterEach
    public void tearDown() {
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers();
    }

    @Test
    void testGetUserSize() {
        userList = DataLoader.readUsers();
        assertEquals(2, userList.size());
    }


    @Test
    void testLoadingZeroUsers() {
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers();
        assertEquals(0,userList.size());
    }

    @Test
    void testGetUserFirstUserName() {
        userList = DataLoader.readUsers();
        assertEquals("ikruger", userList.get(0).getUserName());
    }

}
