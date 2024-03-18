package frontend;

import java.util.ArrayList;

import backend.User;
import backend.UserList;
import backend.Advisor;
import backend.CourseList;
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
                    users.setActiveUser(user);
                    this.courseList = CourseList.getInstance();
                    this.roadmap = Roadmap.getInstance();
                    return true;
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