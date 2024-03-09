package backend;

import java.util.ArrayList;
import java.util.UUID;

public class Parent extends User {
    private User child;
    private ArrayList<User> children;

    public Parent(String username, String firstName, String lastName, String password, String userType, ArrayList<User> children, User child) {
        super(username, firstName, lastName, password, userType);
        this.child = child;
        this.children = children;

        
    }

    public Parent(String username, UUID userID, String firstName, String lastName, String password, String userType, ArrayList<User> children) {
        super(userID, username, firstName, lastName, password, userType);
        this.children = children;

        
    }
    
}