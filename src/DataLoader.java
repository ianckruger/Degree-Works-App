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

                String firstName = (String)userObject.get(USER_FIRST_NAME);
                String lastName = (String)userObject.get(USER_LAST_NAME);
                String password = (String)userObject.get(USER_PASSWORD);
                String userType = (String)userObject.get(USER_USER_TYPE);
                String userID = (String)userObject.get(USER_USER_ID);
                String gpa = (String)userObject.get(USER_GPA);
                String year = (String)userObject.get(USER_YEAR);
                String currentMajor = (String)userObject.get(USER_CURRENT_MAJOR);
                String earnedCreditHours = (String)userObject.get(USER_EARNED_CREDIT_HOURS);
                String totalCurrentCredits = (String)userObject.get(USER_TOTAL_CURRENT_CREDITS);
                String degreeCredits = (String)userObject.get(USER_DEGREE_CREDITS);
                String parents = (String)userObject.get(USER_PARENTS);
                String advisors = (String)userObject.get(USER_ADVISORS);

                String children = (String)userObject.get(USER_CHILDREN);
                String child = (String)userObject.get(USER_CHILD);
                
                String students = (String)userObject.get(USER_STUDENTS);
                String advising = (String)userObject.get(USER_ADVISING);

                users.add(new User(firstName, lastName, userID, password, userType));
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}