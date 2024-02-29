package backend;

import java.util.ArrayList;


public class UserList {

    private static UserList users;
    private ArrayList<User> userList;
    private User ActiveUser;

    private UserList() {
        this.ActiveUser = null;
        userList = DataLoader.readUsers();
    }

    public static UserList getInstance() {
        if(users == null) {
            users = new UserList();
            users.userList = DataLoader.readUsers();
        }
        return users;
    }
    
    public ArrayList<User> getUsers() {
        return userList;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public boolean login(String username, String password) {
        for(User user : userList) {
            if(user.getUserName().equals(username) && user.getPassword().equals(password)) {
                this.ActiveUser = user;
                return true;
            }
                }
    return false;
    }



}