package Tests;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import backend.DataWriter;
import backend.Roadmap;
import backend.User;
import backend.UserList;
import backend.Student;
import backend.Advisor;
import backend.Parent;
import frontend.RoadmapApplication;


public class RoadmapApplicationTest {
    private UserList users = UserList.getInstance();
    private ArrayList<User> userList = users.getUsers();
    private RoadmapApplication app = new RoadmapApplication();
    private Roadmap roadmap = Roadmap.getInstance();

   @BeforeEach
   public void setup() {
     UserList.getInstance().getUsers().clear();
     DataWriter.saveUsers();
   }

   @AfterEach
   public void tearDown() {
    UserList.getInstance().getUsers().clear();
    DataWriter.saveUsers();
   }

   @Test

   public void testRegisterStudent() {
        app.register("student1", "John", "Doe", "123", "student");
        app.login("student1", "123");
        assertEquals("student1", users.getActive().getUserName());
        assertTrue(users.getActive() instanceof Student);


   }

   @Test
   public void testRegisterAdvisor() {
    app.register("user2", "Kayden", "Le", "123", "adivsor");
    app.login("user2", "123");
    assertEquals(1, users.getUsers().size());
    assertTrue(users.getUsers().get(0) instanceof Advisor);
    
   }

   @Test
   public void testRegisterParent() {
    app.register("user3", "Ryan", "Le", "123", "parent");
    app.login("user3", "123");
    assertEquals(1,users.getUsers().size());
    assertTrue(users.getUsers().get(0) instanceof Parent);
    
    
   }

   @Test
   void testIsUserNameTaken() {
    app.register("user1", "John", "Do", "123", "student");
    assertTrue(app.isUsernameTaken("user1"));

   }

   @Test
   void testNameTakenCaseSensitive() {
    app.register("user1", "John", "Do", "123", "student");
    assertFalse(app.isUsernameTaken("UsEr1"));
   }

   @Test
   void testNameTakennull() {
    app.register(null, "", "", "", "");
    assertFalse(app.isUsernameTaken(null));
   }

   @Test
   void testLoginStudent() {
    app.register("user1", "John", "Do", "123", "student");
    assertTrue(app.login("user1", "123"));
    Student activeUser = (Student) users.getActive();
    assertEquals("user1", activeUser.getUserName());
   }

   @Test
   void testLoginAdvisor() {
    app.register("user1", "John", "Do", "123", "advisor");
    assertTrue(app.login("user1", "123"));
    Advisor activeUser = (Advisor) users.getAdvisor();
    assertEquals("user1", activeUser.getUserName());
   }

   @Test
   void testLoginParent() {
    app.register("user1", "John", "Do", "123", "parent");
    assertTrue(app.login("user1", "123"));
    Parent activeUser = (Parent) users.getActive();
    assertEquals("user1", activeUser.getUserName());
   }

   @Test
   void testUserNameNull() {
    app.register(null,"",""," ","");
    assertFalse(app.login(null, ""));
    }

   @Test
   void testAddAdvisee() {
    app.register("advisor1", "John", "Doe", "password", "advisor");
    app.register("student1", "Jane", "Smith", "password", "student");
    assertTrue(app.addAdvisee("advisor1", "student1"));

   }







    
}
