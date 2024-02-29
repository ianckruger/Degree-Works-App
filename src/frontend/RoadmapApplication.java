package frontend;

import java.util.ArrayList;

import backend.User;
import backend.UserList;

public class RoadmapApplication {

    private UserList userlist;
    private RoadMapList roadmapList;
    private User user;


    public RoadmapApplication() {
        this.userlist = UserList.getInstance();
        this.roadmapList = RoadMapList.getInstance();
    }


    public boolean login(String userName, String password) {
        return userlist.login(userName, password);
    }

    public boolean signUp(String firstName, String lastName, String userName, String password, String userType) {
        
    }

    public boolean register(String firstName, String lastName,String userName, String password, String userType) {
        if(userlist.findUser(userName) == null) {
            User newUser = new User(firstName, lastName, password, userType);
            userlist.addUser(newUser);
            return true;

        }
        return false;
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