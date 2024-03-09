package backend;

import java.util.ArrayList;
import java.util.UUID;

public class Advisor extends User {
    private ArrayList<User> students;
    private User advising;

    public Advisor(String username, String firstName, String lastName, String password, String userType, ArrayList<User> students, User advising) {
        super(username, firstName, lastName, password, userType);
        this.students = new ArrayList<>();
        this.advising = null;
    }

    public Advisor(String username, UUID userID, String firstName, String lastName, String password, String userType, ArrayList<User> students) {
        super(userID, username, firstName, lastName, password, userType);
        this.students = students;

        
    }
}