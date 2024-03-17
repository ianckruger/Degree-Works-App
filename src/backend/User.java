package backend;

import java.util.UUID;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public abstract class User {
    protected String firstName;
    protected String lastName;
    protected UUID userID;
    protected String password;
    protected String userType;
    protected String userName;

    // new account
    public User(String username, String firstName, String lastName, String password, String userType) {
        this.userID = UUID.randomUUID();
        this.userName = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userType = userType;

    }

    //existing account
    public User(UUID userID, String userName, String firstName, String lastName, String password, String userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userID = userID;
        this.password = password;
        this.userType = userType;
        this.userName = userName;

    }

    /* 
    public boolean login(String userName, String password) {
        

    }

    public boolean signUp(String firstName, String lastName, String userName, String password, String userType) {

    }
    */

    @Override
    public String toString() {
        JSONObject courseData = readCourseDataFromFile();
        if (courseData != null) {
            String courseSubjectCode = (String) courseData.get("courseSubjectCode");
            String courseNumber = (String) courseData.get("courseNumber");
            String courseTitle = (String) courseData.get("courseTitle");
            long credits = (long) courseData.get("credits");
            return "Course: " + courseSubjectCode + courseNumber + " - " + courseTitle + " (Credits: " + credits + ")";
        } else {
            return "Error: Unable to retrieve course data";
        }
    }

    private JSONObject readCourseDataFromFile() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("class.json"));
            JSONObject jsonObject = (JSONObject) obj;
            return jsonObject;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UUID getUserUUID() {
        return userID;
    }

    public void setUserUUID(UUID userID) {
        this.userID = userID;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    

    
}