import java.io.FileReader;
import java.util.ArrayList;
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
                    users.load(student);
                } else if (userType == "advisor"){
                    User advisor = createAdvisor(userObject, userType);
                    users.load(advisor);
                } else if (userType == "parent") {
                    User parent = createParent(userObject, userType);
                    users.load(parent);
                } else {
                    System.out.println("Gyatt");
                }
            }

            

            return users;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User createStudent(JSONObject userObject,String userType) {
        String firstName = (String)userObject.get(USER_FIRST_NAME);
        String lastName = (String)userObject.get(USER_LAST_NAME);
        String password = (String)userObject.get(USER_PASSWORD);
        String userID = (String)userObject.get(USER_USER_ID);
        String gpa = (String)userObject.get(USER_GPA);
        String year = (String)userObject.get(USER_YEAR);
        String currentMajor = (String)userObject.get(USER_CURRENT_MAJOR);
        String earnedCreditHours = (String)userObject.get(USER_EARNED_CREDIT_HOURS);
        String totalCurrentCredits = (String)userObject.get(USER_TOTAL_CURRENT_CREDITS);
        String degreeCredits = (String)userObject.get(USER_DEGREE_CREDITS);
        String parents = (String)userObject.get(USER_PARENTS);
        String advisors = (String)userObject.get(USER_ADVISORS);

        User user = new Student(firstName, lastName, password, userType, userID, gpa, year, currentMajor, earnedCreditHours, totalCurrentCredits, degreeCredits, parents, advisors);
        return user;
    }

    public static User createAdvisor(JSONObject userObject, String userType) {
        String firstName = (String)userObject.get(USER_FIRST_NAME);
        String lastName = (String)userObject.get(USER_LAST_NAME);
        String password = (String)userObject.get(USER_PASSWORD);
        String userID = (String)userObject.get(USER_USER_ID);
        String students = (String)userObject.get(USER_STUDENTS);
        String advising = (String)userObject.get(USER_ADVISING);
        
        User user = new Advisor(firstName, lastName, password, userType, userID, students, advising);
        return user;
    }

    public static User createParent(JSONObject userObject, String userType) {
        String firstName = (String)userObject.get(USER_FIRST_NAME);
        String lastName = (String)userObject.get(USER_LAST_NAME);
        String password = (String)userObject.get(USER_PASSWORD);
        String userID = (String)userObject.get(USER_USER_ID);
        String children = (String)userObject.get(USER_CHILDREN);
        String child = (String)userObject.get(USER_CHILD);

        User user = new Parent(firstName, lastName, password, userType, userID, children, child);
        return user;
    }



}