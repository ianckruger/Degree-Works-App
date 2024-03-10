package backend;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstant {

    public static void saveUsers() {
        UserList userList = UserList.getInstance();
        ArrayList<User> users = userList.getUsers();
        JSONArray jsonUsers = new JSONArray();

        for (int i = 0; i < users.size(); i++) {
            jsonUsers.add(getUserJSON(users.get(i)));
        }

        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
        // Need to add other things like null objects so json works
        // Need to differentiate     
    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_USERNAME, user.getUserName());
        userDetails.put(USER_USER_ID, user.getUserUUID().toString());
        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_PASSWORD, user.getPassword());
        userDetails.put(USER_USER_TYPE, user.getUserType());

        if(user.getUserType().equalsIgnoreCase("Student")) {
            
        }

        return userDetails;
    }

    public static JSONObject completeStudent(Student user, JSONObject userDetails) {
        userDetails.put(USER_GPA, user.getGPA());
        userDetails.put(USER_DEGREE_CREDITS, user.getDegreeCredits());
        userDetails.put(USER_YEAR, user.getYear());
        userDetails.put(USER_CURRENT_MAJOR, user.getCurrentMajor());
        return userDetails;
    }


    public static void saveRoadMaps (ArrayList<Roadmap> roadmaps) {
        JSONArray jsonRoadmaps = new JSONArray();

        for (int i = 0; i < roadmaps.size(); i++) {
            jsonRoadmaps.add(getRoadmapJSON(roadmaps.get(i)));
        }

        try (FileWriter file = new FileWriter(ROADMAP_FILE_NAME)) {
            file.write(jsonRoadmaps.toJSONString());
            file.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getRoadmapJSON(Roadmap roadmap) {
        JSONObject roadmapDetails = new JSONObject();

        roadmapDetails.put(ROADMAP_ID, roadmap.getRoadmapID().toString());
        roadmapDetails.put(ROADMAP_MAJOR, roadmap.getMajor());

        return roadmapDetails;
        
    }


}