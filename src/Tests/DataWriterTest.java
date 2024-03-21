package Tests;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;
import java.util.ArrayList;

import javax.xml.crypto.Data;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import backend.DataWriter;
import backend.User;
import backend.UserList;
import backend.DataLoader;
import backend.Student;
import backend.Advisor;
import backend.Parent;

 public class DataWriterTest {

    private UserList users = UserList.getInstance();
    private ArrayList<User> userList = users.getUsers();

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
    void testWritingZeroUsers() {
        userList = DataLoader.readUsers();
        assertEquals(0,userList.size());

    }

    @Test
    void testWritingStudent() {
        userList.add(new Student("john03", "John", "Le", "12345", "student"));
        DataWriter.saveUsers();
        assertEquals("john03",DataLoader.readUsers().get(0).getUserName());
    }

    @Test
    void testWritingAdvisor() {
        userList.add(new Advisor("erik09", "Erik", "Martin", "321", "advisor"));
        DataWriter.saveUsers();
        assertEquals("erik09", DataLoader.readUsers().get(0).getUserName());
    }

    @Test
    void testWritingParent() {
        userList.add(new Parent("kayden05", "Kayden", "Lee", "123", "parent"));
        DataWriter.saveUsers();
        assertEquals("kayden05", DataLoader.readUsers().get(0).getUserName());
    }

    @Test
    void testWritingThreeUsers() {
        userList.add(new Student("john03", "John", "Le", "12345", "student"));
        userList.add(new Advisor("erik09", "Erik", "Martin", "321", "advisor"));
        userList.add(new Parent("kayden05", "Kayden", "Lee", "123", "parent"));
        DataWriter.saveUsers();
        assertEquals("kayden05",DataLoader.readUsers().get(2).getUserName());
    }

    @Test
    void testWritingEmptyUser() {
        userList.add(new Student("","","","",""));
        DataWriter.saveUsers();
        assertEquals("", DataLoader.readUsers().get(0).getUserName());
    }

    @Test
    void testWritingNullUser(){
        userList.add(new Advisor(null,"","","",""));
        DataWriter.saveUsers();
        assertEquals(null, DataLoader.readUsers().get(0).getUserName());
    }



    
}
