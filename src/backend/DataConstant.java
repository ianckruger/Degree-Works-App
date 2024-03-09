package backend;
import java.lang.reflect.Array;
import java.util.UUID;

public abstract class DataConstant {

    // USERS JSON FILE
    protected static final String USER_FILE_NAME = "json/users.json";
    protected static final String USERS = "users";

    // USERS JSON KEYS students
    protected static final String USER_FIRST_NAME = "firstName";
    protected static final String USER_LAST_NAME = "lastName";
    protected static final String USER_PASSWORD = "password";
    protected static final String USER_USER_TYPE = "userType";
    protected static final String USER_USER_ID = "userID";
    protected static final String USER_GPA = "gpa";
    protected static final String USER_YEAR = "year";
    protected static final String USER_CURRENT_MAJOR = "currentMajor";
    protected static final String USER_EARNED_CREDIT_HOURS = "earnedCreditHours";
    protected static final String USER_TOTAL_CURRENT_CREDITS = "totalCurrentCredits";
    protected static final String USER_DEGREE_CREDITS = "degreeCredits";
    protected static final String USER_PARENTS = "parents";
    protected static final String USER_ADVISORS = "advisors";
    // PARENT USERS JSON KEYS
    protected static final String USER_CHILDREN = "children";
    protected static final String USER_CHILD = "child";
    // ADVISOR USERS JSON KEYS
    protected static final String USER_STUDENTS = "students";
    protected static final String USER_ADVISING = "advising";
    // ROADMAP JSON FILE
    protected static final String ROADMAP_FILE_NAME = "json/roadmap.json";
    protected static final String ROADMAPS = "roadmap";

    // ROADMAP JSON KEYS
    protected static final String ROADMAP_ID = "roadmapID";
    protected static final String ROADMAP_MAJOR = "major";
    protected static final String ROADMAP_MAJOR_CLASSES = "majorsClasses";
    protected static final String ROADMAP_CAROLINA_CORE = "carolinaCore";
    protected static final String ROADMAP_PROGRAM_REQUIREMENTS = "programRequirements";
    protected static final String ROADMAP_ELECTIVES = "electives";

}
