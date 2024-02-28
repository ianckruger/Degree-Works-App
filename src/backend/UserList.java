import java.util.ArrayList;


public class UserList {

    private static UserList users;
    private ArrayList<User> userList;

    private UserList() {
        // use json dataloader here
        userList = DataLoader.readUsers();
    }

    public static UserList getUserList() {
        if (users==null) {
            users = new UserList();
        }

        return users;
    }

    public static UserList getInstance() {
        if(users == null) {
            users = new UserList();
            users.userList = DataLoader.readUsers();
        };
        return users;
    }
    
    public ArrayList<User> getUsers() {
        return userList;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public boolean login(String userID, String password) {
        for(User user : userList) {
            if(user.getUserUUID().equals(userID) && user.getPassword().equals(password)) 
                return true;
                }
    return false;
    }



}