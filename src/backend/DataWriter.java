package backend;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstant {

    public static void saveUsers() {
<<<<<<< HEAD
=======
        UserList userList = UserList.getInstance();
        ArrayList<User> users = userList.getUsers();
>>>>>>> 388ccb3f4327ad10e7486ccf75d0472023a34d9d
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

    
        public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_USER_ID, user.getUserUUID().toString());
<<<<<<< HEAD
		userDetails.put(USER_FIRST_NAME, user.getFirstName());
		userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_PASSWORD,user.getPassword());
=======
        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_PASSWORD, user.getPassword());
>>>>>>> 388ccb3f4327ad10e7486ccf75d0472023a34d9d
        userDetails.put(USER_USER_TYPE, user.getUserType());

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