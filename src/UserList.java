import java.util.ArrayList;



public class UserList {

    private static UserList users;
    private ArrayList<User> userList;

    private UserList() {
        // use json dataloader here
    }

    public static UserList getUserList() {
        if (users==null) {
            users = new UserList();
        }

        return users;
    }
}