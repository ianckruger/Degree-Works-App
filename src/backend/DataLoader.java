package backend;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstant {

        public static ArrayList<User> readUsers() {
            UserList users = UserList.getInstance();
        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray userJSON = (JSONArray) parser.parse(reader);


            for(int i=0; i < userJSON.size(); i++) {
                JSONObject userObject = (JSONObject)userJSON.get(i);
                String userType = (String)userObject.get(USER_USER_TYPE);

                if (userType.equalsIgnoreCase("Student")) {
                    User student = createStudent(userObject, userType);
                    users.addUser(student);
                } else if (userType.equalsIgnoreCase("Advisor")){
                    User advisor = createAdvisor(userObject, userType);
                    users.addUser(advisor);
                } else if (userType.equalsIgnoreCase("Parent")) {
                    User parent = createParent(userObject, userType);
                    users.addUser(parent);
                } else {
                    System.out.println("Gyatt");
                }
            }

            for(User user : users.getUsers()) {

                if(user.getUserType().equalsIgnoreCase("Student")) {
                    Student student = (Student) user;

                    if(!student.getAdvisors().isEmpty()) {
                        for(int i=0; i < student.getAdvisors().size(); i++) {
                            String uuid = student.getAdvisors().get(i);

                            for(User user1 : users.getUsers()) {
                                if(user1.getUserUUID().toString().equals(uuid)) {
                                    Advisor advisor = (Advisor) user1;
                                    student.getAdvisor().add(advisor);
                                }
                            }
                        }
                     }

                     if(!student.getParents().isEmpty()) {
                        for(int i=0; i < student.getParents().size(); i++) {
                            String uuid = student.getParents().get(i);

                            for(User user1 : users.getUsers()) {
                                if(user1.getUserUUID().toString().equals(uuid)) {
                                    Parent parent = (Parent) user1;
                                    student.getParent().add(parent);
                                }
                            }
                        }
                     }
                }

                if(user.getUserType().equalsIgnoreCase("Advisor")) {
                    Advisor advisor = (Advisor) user;
                    
                    if(!advisor.getStudents().isEmpty()) {
                        for(int i=0; i < advisor.getStudents().size(); i++) {
                            String uuid = advisor.getStudents().get(i);

                            for(User user1 : users.getUsers()) {
                                if(user1.getUserUUID().toString().equals(uuid)) {
                                    Student student = (Student) user1;
                                    advisor.getStudent().add(student);
                                }
                            }
                        }
                     }

                }

                if(user.getUserType().equalsIgnoreCase("Parent")) {
                    Parent parent = (Parent) user;
                    
                    if(!parent.getChildren().isEmpty()) {
                        for(int i=0; i < parent.getChildren().size(); i++) {
                            String uuid = parent.getChildren().get(i);

                            for(User user1 : users.getUsers()) {
                                if(user1.getUserUUID().toString().equals(uuid)) {
                                    Student student = (Student) user1;
                                    parent.getChilds().add(student);
                                }
                            }
                        }
                     }

                }

            }

            

            return users.getUsers();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User createStudent(JSONObject userObject,String userType) {
        String userName = (String)userObject.get(USER_USERNAME);
        String firstName = (String)userObject.get(USER_FIRST_NAME);
        String lastName = (String)userObject.get(USER_LAST_NAME);
        String password = (String)userObject.get(USER_PASSWORD);
        String tempuserID = (String)userObject.get(USER_USER_ID);
        UUID userID = UUID.fromString(tempuserID);
        double gpa = (double)userObject.get(USER_GPA);
        String year = (String)userObject.get(USER_YEAR);
        String currentMajor = (String)userObject.get(USER_CURRENT_MAJOR);
        int earnedCreditHours = ((Number)userObject.get(USER_EARNED_CREDIT_HOURS)).intValue();
        int totalCurrentCredits = ((Number)userObject.get(USER_TOTAL_CURRENT_CREDITS)).intValue();
        int degreeCredits = ((Number)userObject.get(USER_DEGREE_CREDITS)).intValue();
        JSONArray Jparents = (JSONArray)userObject.get(USER_PARENTS); // might need to modify this
        JSONArray Jadvisors = (JSONArray)userObject.get(USER_ADVISORS);

        ArrayList<String> parents = new ArrayList<>();
        for (int i = 0; i < Jparents.size(); i++) {
            String addThis = (String)Jparents.get(i);
            parents.add(addThis);
        }
        ArrayList<String> advisors = new ArrayList<>();
        for (int i = 0; i < Jadvisors.size(); i++) {
            String addThis = (String)Jadvisors.get(i);
            advisors.add(addThis);
        }
        // the JSONArray objects currently store String IDS for each user
        // To properly add arrays of users we would need to search each user for their ID, and see if they match.
        // We are passing in empty arrays right now to ensure we can create a scenario


        User user = new Student(userName, userID, firstName, lastName, password, userType, gpa, year, currentMajor, earnedCreditHours, totalCurrentCredits, degreeCredits, parents, advisors);
        return user;
    }

    public static User createAdvisor(JSONObject userObject, String userType) {
        String userName = (String)userObject.get(USER_USERNAME);
        String firstName = (String)userObject.get(USER_FIRST_NAME);
        String lastName = (String)userObject.get(USER_LAST_NAME);
        String password = (String)userObject.get(USER_PASSWORD);
        String tempuserID = (String)userObject.get(USER_USER_ID);
        UUID userID = UUID.fromString(tempuserID);
        JSONArray jstudents = (JSONArray)userObject.get(USER_STUDENTS);
        // User advising = (User)userObject.get(USER_ADVISING);

        ArrayList<String> students = new ArrayList<>();
        for (int i = 0; i < jstudents.size(); i++) {
            String addThis = (String)jstudents.get(i);
            students.add(addThis);
        }

        // for (Object student: jstudents ) {
        //     students.add((User) student);
        // }


        
        User user = new Advisor(userName, firstName, lastName, password, userType);
        return user;
    }

    public static User createParent(JSONObject userObject, String userType) {
        String userName = (String)userObject.get(USER_USERNAME);
        String firstName = (String)userObject.get(USER_FIRST_NAME);
        String lastName = (String)userObject.get(USER_LAST_NAME);
        String password = (String)userObject.get(USER_PASSWORD);
        String tempuserID = (String)userObject.get(USER_USER_ID);
        UUID userID = UUID.fromString(tempuserID);
        JSONArray jchildren = (JSONArray)userObject.get(USER_CHILDREN);

        ArrayList<String> children = new ArrayList<>();
        for (int i = 0; i < jchildren.size(); i++) {
            String addThis = (String)jchildren.get(i);
            children.add(addThis);
        }

        // for (Object childs: jchildren ) {
        //     children.add((User) childs);
        // }

        User user = new Parent(userName, firstName, lastName, password, userType);
        return user;
    }
}

/* 
    // Roadmap parsing logic same as user parsing

    // THIS IS ALL GOING TO BE RECONSTRUCTED LATER PROBABLY
    public static ArrayList<RoadmapList> readRoadmaps() {
        RoadmapList roadmaps = RoadmapList.getInstance();

        try {
            FileReader reader = new FileReader(ROADMAP_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray roadmapJSON = (JSONArray) parser.parse(reader);

            for(int i=0; i < roadmapJSON.size(); i++) {
                JSONObject roadmapObject = (JSONObject)roadmapJSON.get(i);
                String major = (String)roadmapObject.get(ROADMAP_MAJOR);

                if(major == "CSCE") {
                    Roadmap csceRoadmap = createCSCERoadmap(roadmapObject, major);
                    roadmaps.addRoadmap(csceRoadmap);
                } else if(major == "CE") {
                    Roadmap ceRoadmap = createCERoadmap(roadmapObject, major);
                    roadmaps.addRoadmap(ceRoadmap);
                } else if(major == "CIS") {
                    Roadmap cisRoadmap = createCISRoadmap(roadmapObject, major);
                    roadmaps.addRoadmap(cisRoadmap);
                }
                else {
                    System.out.println("Unknown major");
                }
                
            }
            return roadmaps.getRoadmaps();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    //Roadmap creation methods
    public static Roadmap createCSCERoadmap(JSONObject roadmapObject, String major) {
        UUID roadmapID = (UUID)roadmapObject.get(ROADMAP_ID);
        String majorName = (String)roadmapObject.get(ROADMAP_MAJOR);
        ArrayList<Roadmap> majorClasses = (ArrayList<Roadmap>)roadmapObject.get(ROADMAP_MAJOR_CLASSES);
        ArrayList<Roadmap> carolinaCore = (ArrayList<Roadmap>)roadmapObject.get(ROADMAP_CAROLINA_CORE);
        Object programRequirements = roadmapObject.get(ROADMAP_PROGRAM_REQUIREMENTS); // I think this is right? Fix in future.
        ArrayList<Roadmap> electives = (ArrayList<Roadmap>)roadmapObject.get(ROADMAP_ELECTIVES);

        Roadmap roadmap = new Roadmap(roadmapID, majorName, majorClasses, carolinaCore, programRequirements, electives);
        return roadmap;
    }

    public static Roadmap createCERoadmap(JSONObject roadmapObject, String major) {
        UUID roadmapID = (UUID)roadmapObject.get(ROADMAP_ID);
        String majorName = (String)roadmapObject.get(ROADMAP_MAJOR);
        ArrayList<Roadmap> majorClasses = (ArrayList<Roadmap>)roadmapObject.get(ROADMAP_MAJOR_CLASSES);
        ArrayList<Roadmap> carolinaCore = (ArrayList<Roadmap>)roadmapObject.get(ROADMAP_CAROLINA_CORE);
        Object programRequirements = roadmapObject.get(ROADMAP_PROGRAM_REQUIREMENTS); // I think this is right? Fix in future.
        ArrayList<Roadmap> electives = (ArrayList<Roadmap>)roadmapObject.get(ROADMAP_ELECTIVES);

        Roadmap roadmap = new Roadmap(roadmapID, majorName, majorClasses, carolinaCore, programRequirements, electives);
        return roadmap;
    }

    public static Roadmap createCISRoadmap(JSONObject roadmapObject, String major) {
        UUID roadmapID = (UUID)roadmapObject.get(ROADMAP_ID);
        String majorName = (String)roadmapObject.get(ROADMAP_MAJOR);
        ArrayList<Roadmap> majorClasses = (ArrayList<Roadmap>)roadmapObject.get(ROADMAP_MAJOR_CLASSES);
        ArrayList<Roadmap> carolinaCore = (ArrayList<Roadmap>)roadmapObject.get(ROADMAP_CAROLINA_CORE);
        Object programRequirements = roadmapObject.get(ROADMAP_PROGRAM_REQUIREMENTS); // I think this is right? Fix in future.
        ArrayList<Roadmap> electives = (ArrayList<Roadmap>)roadmapObject.get(ROADMAP_ELECTIVES);

        Roadmap roadmap = new Roadmap(roadmapID, majorName, majorClasses, carolinaCore, programRequirements, electives);
        return roadmap;
    }

}

*/