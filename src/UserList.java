import java.util.ArrayList;



public class UserList {

    private static UserList users;
    private ArrayList<User> userList;

    private UserList() {
        // use json dataloader here
        userList = DataLoader.getUsers();
    }

    public static UserList getUserList() {
        if (users==null) {
            users = new UserList();
        }

        return users;
    }
}