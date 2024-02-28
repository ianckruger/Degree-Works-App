package backend;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstant {

        public static ArrayList<User> readUsers() {
            UserList users = UserList.getUserList();
        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray userJSON = (JSONArray) parser.parse(reader);


            for(int i=0; i < userJSON.size(); i++) {
                JSONObject userObject = (JSONObject)userJSON.get(i);
                String userType = (String)userObject.get(USER_USER_TYPE);

                if (userType == "student") {
                    User student = createStudent(userObject, userType);
                    users.addUser(student);
                } else if (userType == "advisor"){
                    User advisor = createAdvisor(userObject, userType);
                    users.addUser(advisor);
                } else if (userType == "parent") {
                    User parent = createParent(userObject, userType);
                    users.addUser(parent);
                } else {
                    System.out.println("Gyatt");
                }
            }

            

            return users.getUsers();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User createStudent(JSONObject userObject,String userType) {
        String firstName = (String)userObject.get(USER_FIRST_NAME);
        String lastName = (String)userObject.get(USER_LAST_NAME);
        String password = (String)userObject.get(USER_PASSWORD);
        UUID userID = (UUID)userObject.get(USER_USER_ID);
        double gpa = (double)userObject.get(USER_GPA);
        String year = (String)userObject.get(USER_YEAR);
        String currentMajor = (String)userObject.get(USER_CURRENT_MAJOR);
        int earnedCreditHours = (int)userObject.get(USER_EARNED_CREDIT_HOURS);
        int totalCurrentCredits = (int)userObject.get(USER_TOTAL_CURRENT_CREDITS);
        int degreeCredits = (int)userObject.get(USER_DEGREE_CREDITS);
        ArrayList<User> parents = (ArrayList<User>)userObject.get(USER_PARENTS); // might need to modify this
        ArrayList<User> advisors = (ArrayList<User>)userObject.get(USER_ADVISORS);

        User user = new Student(userID, firstName, lastName, password, userType, gpa, year, currentMajor, earnedCreditHours, totalCurrentCredits, degreeCredits, parents, advisors);
        return user;
    }

    public static User createAdvisor(JSONObject userObject, String userType) {
        String firstName = (String)userObject.get(USER_FIRST_NAME);
        String lastName = (String)userObject.get(USER_LAST_NAME);
        String password = (String)userObject.get(USER_PASSWORD);
        UUID userID = (UUID)userObject.get(USER_USER_ID);
        ArrayList<User> students = (ArrayList<User>)userObject.get(USER_STUDENTS);
        User advising = (User)userObject.get(USER_ADVISING);
        
        User user = new Advisor(userID, firstName, lastName, password, userType, students, advising);
        return user;
    }

    public static User createParent(JSONObject userObject, String userType) {
        String firstName = (String)userObject.get(USER_FIRST_NAME);
        String lastName = (String)userObject.get(USER_LAST_NAME);
        String password = (String)userObject.get(USER_PASSWORD);
        UUID userID = (UUID)userObject.get(USER_USER_ID);
        ArrayList<User> children = (ArrayList<User>)userObject.get(USER_CHILDREN);
        User child = (User)userObject.get(USER_CHILD);

        User user = new Parent(userID, firstName, lastName, password, userType, children, child);
        return user;
    }



}