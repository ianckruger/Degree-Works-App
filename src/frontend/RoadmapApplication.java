package frontend;

import java.util.ArrayList;

import backend.User;
import backend.UserList;
import backend.Advisor;
import backend.DataWriter;
import backend.Parent;
import backend.Roadmap;
import backend.RoadmapList;
import backend.Student;

public class RoadmapApplication {

    private UserList userlist;
    private RoadmapList roadmapList;
    private User user;


    public RoadmapApplication() {
        this.userlist = UserList.getInstance();
        this.roadmapList = RoadmapList.getInstance();
    }


    public boolean login(String userName, String password) {
        return userlist.login(userName, password);
    }


<<<<<<< HEAD
<<<<<<< HEAD
    public boolean register(String firstName, String lastName, String password, String userType) {
         if ( userType.equals("student")) {
            Student student = new Student(firstName, lastName, password, userType);
            userlist.addUser(student);;
=======
 
    public boolean register(String userName, String firstName, String lastName, String password, String userType) {
         if ( userType.equals("Student")) {
            Student student = new Student(userName, firstName, lastName, password, userType);
            userlist.addUser(student);
>>>>>>> 6ea9f5a5041d5cdaf5023fbbae4df94fe285d0da
            DataWriter.saveUsers();
            return true;
        } else if(userType.equals("Parent")) {
            Parent parent = new Parent(userName, firstName, lastName, password, userType);
            userlist.addUser(parent);
            DataWriter.saveUsers();
            return true;
        } else if(userType.equals("Advisor")) {
            Advisor advisor = new Advisor(userName, firstName, lastName, password, userType);
            userlist.addUser(advisor);
            DataWriter.saveUsers();
            return true;

<<<<<<< HEAD
=======
<<<<<<< HEAD
    public boolean register(String firstName, String lastName, String userName, String password, String userType, double gpa, String year, String currentMajor, int earnedCreditHours, int totalCurrentCredits, int degreeCredits, ArrayList<User> parents, ArrayList<User> advisors, ArrayList<User> children, User child, ArrayList<User> students, User advising) {
        if(userType.equalsIgnoreCase("student")) {
            return userlist.registerStudent(firstName, lastName, password, userType, gpa, year, currentMajor, earnedCreditHours, totalCurrentCredits, degreeCredits, parents, advisors);
>>>>>>> e10518673a06fbdab532e2212605ddfcb8f0888e
=======
>>>>>>> 6ea9f5a5041d5cdaf5023fbbae4df94fe285d0da
        }
        return false;

    }
 
     


    public ArrayList<Roadmap> getRoadmapList() {
        return roadmapList.getRoadmaps();

    }
    public void viewTranscript() {

    }
    
    public void switchState(String state) {

    }
/* 
    public ArrayList<Class> findClass() {

    }

    public ArrayList<Class> findClass(String courseTile, String courseNumber) {

    }

    public ArrayList<Class> getFavoriteClasses() {

    }
*/
    public void addFavoriteClass(Class course) {

    }

    public void inputNotesForStudent(String notes) {

    }

    public void whatIf(String major) {

    }







}