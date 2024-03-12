package backend;

import java.util.ArrayList;
import java.util.UUID;

public class Advisor extends User {
    private ArrayList<String> students;
    private User advising;

<<<<<<< HEAD
<<<<<<< HEAD
    public Advisor(String firstName, String lastName, String password, String userType) {
        super(firstName, lastName, password, userType);
        this.students = null;
=======
    public Advisor(String userName, String firstName, String lastName, String password, String userType) {
        super(userName, firstName, lastName, password, userType);
        this.students = new ArrayList<String>();
>>>>>>> 6ea9f5a5041d5cdaf5023fbbae4df94fe285d0da
        this.advising = null;

    }
    public Advisor(String userName, String firstName, String lastName, String password, String userType, ArrayList<String> students, User advising) {
        super(userName,firstName, lastName, password, userType);
        this.advising = advising;
        this.students = students;

<<<<<<< HEAD
        
=======
    public Advisor(String username, String firstName, String lastName, String password, String userType, ArrayList<User> students, User advising) {
        super(username, firstName, lastName, password, userType);
        this.students = new ArrayList<>();
        this.advising = null;
>>>>>>> e10518673a06fbdab532e2212605ddfcb8f0888e
=======
>>>>>>> 6ea9f5a5041d5cdaf5023fbbae4df94fe285d0da
    }

    public Advisor(String username, UUID userID, String firstName, String lastName, String password, String userType, ArrayList<String> students) {
        super(userID, username, firstName, lastName, password, userType);
        this.students = students;

    }

    public User getAdvising() {
        return advising;
    };

    public ArrayList<String> getStudents() {
        return students;
    };
}