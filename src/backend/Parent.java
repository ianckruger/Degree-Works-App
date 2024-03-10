package backend;

import java.util.ArrayList;
import java.util.UUID;

public class Parent extends User {
    private User child;
    private ArrayList<User> children;

    public Parent(String userName, String firstName, String lastName, String password, String userType) {
        super(userName, firstName, lastName, password, userType);
        this.child = null;
        this.children = null;
    }

    public Parent(String userName, String firstName, String lastName, String password, String userType, ArrayList<User> children, User child) {
        super(userName, firstName, lastName, password, userType);
        this.child = child;
        this.children = children;

    }

    public Parent(String username, UUID userID, String firstName, String lastName, String password, String userType, ArrayList<User> children) {
        super(userID, username, firstName, lastName, password, userType);
        this.children = children;

    }

    public User getChild() {
        return child;
    };

    public ArrayList<User> getChildren() {
        return children;
    };
    
}