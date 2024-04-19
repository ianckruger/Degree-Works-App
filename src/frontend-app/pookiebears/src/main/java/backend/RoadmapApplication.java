package backend;

import java.util.ArrayList;
import java.util.Scanner;

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
import java.util.ArrayList;

public class RoadmapApplication {

    private UserList userlist;
    private Roadmap roadmap;
    private User user;
    // private Scanner scanner;
    private CourseList courseList;
    private static  RoadmapApplication application;

    


    public RoadmapApplication() {
        this.userlist = UserList.getInstance();
    }

    public static RoadmapApplication  getInstance(){
        if( application == null){
            application = new  RoadmapApplication();
        }
        
        return application;
    }

    public boolean register(String userName, String firstName, String lastName, String password, String userType) {
        if(userlist.register(userName, firstName, lastName, password, userType)) {
           return true;
        } else
        return false;

   }

   public boolean login(String userName, String password) {
    UserList users = UserList.getInstance();
    ArrayList<User> userList = users.getUsers();
    try (Scanner scanner = new Scanner(System.in)) {
        if (userList != null) {
            for (User user : userList) {
                if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                    // If user is a student
                    if (user.getUserType().equalsIgnoreCase("student")) {
                        Student student = (Student) user;
                        users.setActiveUser(student);
                        CourseList courseList = CourseList.getInstance();
                        Roadmap roadmap = Roadmap.getInstance();
                        setRoadmap(roadmap);
                        roadmap.setMajorState(student.getCurrentMajor());
                        return true;
                    } else if (user.getUserType().equalsIgnoreCase("advisor")) {
                        users.setAdvisor(user);
                        return true;
                    }
                    
                }
            }
        }
    } 
    return false; // Return false if no user is found or incorrect credentials
}


    public void setRoadmap(Roadmap roadmap) {
        this.roadmap = roadmap;
    }



    public boolean isUsernameTaken(String userName) {
        UserList users = UserList.getInstance();
        ArrayList<User> userList = users.getUsers();
        for (User user : userList) {
            if(user.getUserName().equals(userName) && user.getUserName() != null) {
                return true;
            }

        }
        return false;

    }

    public boolean logout() {
        if(userlist.logout()) {
            return true;
        }
        return false;

    }

    public boolean printStudentProgress() {
        Student student = (Student)userlist.getActive();
 
        if(student != null) {
            String major = student.getCurrentMajor();
            System.out.println(major);
            if (major != null ) {
                Roadmap roadmap = Roadmap.getInstance();
               System.out.println(roadmap.displayClasses());
                return true;
            } else {
                System.out.println("Student's major type not found.");
                 return false;
            }
        } else {
            System.out.println("Student is null");
            return false;
        } 
         
    }

    public boolean printEightSemesterPlan() {
        Student student = (Student)userlist.getActive();
        if(student != null) {
            String major = student.getCurrentMajor();
            if(major != null) {
                Roadmap roadmap = Roadmap.getInstance();
                System.out.println(roadmap.EightSemesterPlan());
                return true;

            } else {
                System.out.println("Student's major type not found.");
                return false;

            }

        } else {
            System.out.println("Student is null");
            return false;
        }

    }

    public boolean addNoteToStudent(String note) {
        if (note != null) {
            System.out.println(note);
            return true;
        }
        return false;

    }

    
    public ArrayList<Class> getClasses() {
        Student student = (Student)userlist.getActive();
        if(student != null) {
            String major = student.getCurrentMajor();
            if(major != null) {
                return roadmap.getClasses();
            } 
        }   
        return null;
    }

    public ArrayList<Class> getCompletedClasses() {
        Student student = (Student)userlist.getActive();
        if(student != null) {
            String major = student.getCurrentMajor();
            if(major!= null) {
                return roadmap.getCompletedClasses();
            }
        }
        return null;
    }

    public ArrayList<Class> getIncompletedClasses() {
        Student student = (Student)userlist.getActive();
        if(student != null) {
            String major = student.getCurrentMajor();
            if(major!= null) {
                return roadmap.getIncompletedClasses();
            }
        }
        return null;
    }

    public String getUserType() {
        UserList users = UserList.getInstance();
        return users.getActive().getUserType();

     }

    public void setUserType(String userType) {
        userlist.getActive().setUserType(userType);
     }

     public String getAdvisorType() {
        UserList users = UserList.getInstance();
        return users.getAdvisor().getUserType();
     }

     public User getActiveUser() {
        return userlist.getActive();
        
     }

     







   
}