import java.util.ArrayList;
public class RoadmapApplication {

    private static RoadmapApplication facade;
    private UserList userList = UserList.getInstance() ;
    private RoadMapList roadmapList = roadmapList.getInstance();
    private User user;


    public RoadmapApplication() {
        

    }


    public boolean login(String userName, String password) {
        return userList.login(userName, password);
    }

    public boolean register(String firstName, String lastName,String userName, String password, String userType) {
        if(userList.findUser(userName, password) == null) {
            User newUser = new User(firstName, lastName, password, userType);
            userList.addUser(newUser);
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