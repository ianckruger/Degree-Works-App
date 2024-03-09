package frontend;

import java.util.ArrayList;

import backend.User;
import backend.UserList;
import backend.Roadmap;
import backend.RoadmapList;

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

    

    public boolean register(String firstName, String lastName, String userName, String password, String userType, double gpa, String year, String currentMajor, int earnedCreditHours, int totalCurrentCredits, int degreeCredits, ArrayList<User> parents, ArrayList<User> advisors, ArrayList<User> children, User child, ArrayList<User> students, User advising) {
        if(userType.equalsIgnoreCase("student")) {
            return userlist.registerStudent(firstName, lastName, password, userType, gpa, year, currentMajor, earnedCreditHours, totalCurrentCredits, degreeCredits, parents, advisors);
        }
        else if(userType.equalsIgnoreCase("parent")) {
            return userlist.registerParent(firstName, lastName, password, userType, children, child);
        }
        else if(userType.equalsIgnoreCase("advisor")) {
            return userlist.registerAdvisor(firstName, lastName, password, userType, students, advising);
        } else {
            return false;
        }
        
       
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