import java.util.UUID;

public abstract class User {
    private String firstName;
    private String lastName;
    private UUID userID;
    private String password;
    private String userType;


    // new account
    public User(String firstName, String lastName, String password, String userType) {
        this.userID = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userType = userType;

    }

    //existing account
    public User(UUID userID, String firstName, String lastName, String password, String userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userID = userID;
        this.password = password;
        this.userType = userType;

    }
}