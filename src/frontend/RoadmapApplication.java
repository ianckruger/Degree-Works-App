package frontend;

import java.util.ArrayList;

import backend.User;
import backend.UserList;
public class RoadmapApplication {

    private static RoadmapApplication facade;
    private RoadMapList roadmapList = RoadMapList.getInstance();
    private User user;


    public RoadmapApplication() {
        

    }


    public boolean login(String userName, String password) {
        UserList userlist = UserList.getInstance();
        return userlist.login(userName, password);
        
    }

    

    public boolean register(String firstName, String lastName,String userName, String password, String userType) {
        
    }



    public Roadmap getRoadmap() {
        return roadmapList.getRoadmap;

    }
    public void viewTranscript() {

    }
    
    public void switchState(String state) {

    }

    public ArrayList<Class> findClass() {

    }

    public ArrayList<Class> findClass(String courseTile, String courseNumber) {

    }

    public ArrayList<Class> getFavoriteClasses() {

    }

    public void addFavoriteClass(Class class) {

    }

    public void inputNotesForStudent(String notes) {

    }

    public void whatIf(String major) {

    }







}