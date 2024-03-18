package frontend;

import java.util.ArrayList;

import backend.User;
import backend.UserList;
import backend.Advisor;
import backend.CeState;
import backend.CisState;
import backend.CourseList;
import backend.CsceState;
import backend.DataLoader;
import backend.DataWriter;
import backend.Parent;
import backend.Roadmap;
import backend.RoadmapList;
import backend.Student;

public class RoadmapApplication {

    private UserList userlist;
    private Roadmap roadmap;
    private User user;
    private CourseList courseList;


    public RoadmapApplication() {
        this.userlist = UserList.getInstance();
        
    }


    public boolean login(String userName, String password) {
            UserList users = UserList.getInstance();
            ArrayList<User> userList = users.getUsers();
             for(User user : userList) {
                if(user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                    // add a check 

                    // if (student)
                    users.setActiveUser(user);
                    this.courseList = CourseList.getInstance();
                    this.roadmap = Roadmap.getInstance();
                    return true;

                    // else aka if an advisor
                    // "What student would you like to see" 
                    // user enters: student id
                    // search through user list for student id
                    // set that as active user
                    // print out advisor options
                    // add note function should add a string into roadmap arraylist of string "notes"
                }
         } 
        return false;

     }

     


 
 
    public boolean register(String userName, String firstName, String lastName, String password, String userType) {
         if ( userType.equalsIgnoreCase("student")) {
            Student student = new Student(userName, firstName, lastName, password, userType);
            userlist.addUser(student);
            DataWriter.saveUsers();
            return true;
        } else if(userType.equalsIgnoreCase("parent")) {
            Parent parent = new Parent(userName, firstName, lastName, password, userType);
            userlist.addUser(parent);
            DataWriter.saveUsers();
            return true;
        } else if(userType.equalsIgnoreCase("advisor")) {
            Advisor advisor = new Advisor(userName, firstName, lastName, password, userType);
            userlist.addUser(advisor);
            DataWriter.saveUsers();
            return true;
        }

 
        return false;

    }

    public boolean isUsernameTaken(String userName) {
        UserList users = UserList.getInstance();
        ArrayList<User> userList = users.getUsers();
        for (User user : userList) {
            if(user.getUserName().equals(userName)) {
                return true;
            }

        }
        return false;

    }

    public boolean logout() {
        if (user == null) {
            return false;
        }
        DataWriter.saveUsers();
        user = null;
        return true;

    }

    boolean  printStudentProgress() {
        Student student = (Student) user;
        String major = student.getCurrentMajor();
        if (major != null) {
                switch (major.toLowerCase()) {
                    case "csce":
                        CsceState csceState = new CsceState(roadmap);
                        System.out.println(csceState.toString());
                        break;
                    case "cis":
                        CisState cisState = new CisState(roadmap);
                        System.out.println(cisState.toString());
                        break;
                    case "ce":
                        CeState ceState = new CeState(roadmap);
                        System.out.println(ceState.toString());
                        break;
                    
                }
                return true;
            } else {
                System.out.println("Student's major type not found.");
                return false;
            }
    }

   
    public void viewTranscript() {

    }
    
    public void switchState(String state) {

    }
    public void addFavoriteClass(Class course) {

    }

    public void inputNotesForStudent(String notes) {

    }

    public void whatIf(String major) {

    }







}