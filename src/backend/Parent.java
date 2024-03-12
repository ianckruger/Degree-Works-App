package backend;

import java.util.ArrayList;
import java.util.UUID;

public class Parent extends User {
    private User child;
    private ArrayList<String> children;

<<<<<<< HEAD
<<<<<<< HEAD
    public Parent(String firstName, String lastName, String password, String userType) {
        super(firstName, lastName, password, userType);
=======
    public Parent(String userName, String firstName, String lastName, String password, String userType) {
        super(userName, firstName, lastName, password, userType);
>>>>>>> 6ea9f5a5041d5cdaf5023fbbae4df94fe285d0da
        this.child = null;
        this.children = new ArrayList<String>();
    }

    public Parent(String userName, String firstName, String lastName, String password, String userType, ArrayList<String> children, User child) {
        super(userName, firstName, lastName, password, userType);
        this.child = child;
        this.children = children;
<<<<<<< HEAD
=======
    public Parent(String username, String firstName, String lastName, String password, String userType, ArrayList<User> children, User child) {
        super(username, firstName, lastName, password, userType);
        this.child = null;
        this.children = new ArrayList<>();
>>>>>>> e10518673a06fbdab532e2212605ddfcb8f0888e
=======
>>>>>>> 6ea9f5a5041d5cdaf5023fbbae4df94fe285d0da

    }

    public Parent(String username, UUID userID, String firstName, String lastName, String password, String userType, ArrayList<String> children) {
        super(userID, username, firstName, lastName, password, userType);
        this.children = children;

    }

    public User getChild() {
        return child;
    };

    public ArrayList<String> getChildren() {
        return children;
    };
    
}