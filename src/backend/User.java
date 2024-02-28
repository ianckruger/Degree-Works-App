import java.util.UUID;

public abstract class User {
<<<<<<< HEAD
    private String firstName;
    private String lastName;
    private UUID userID;
    private String password;
    private String userType;
    private String userName;
=======
    protected String firstName;
    protected String lastName;
    protected UUID userID;
    protected String password;
    protected String userType;
>>>>>>> d8ef128f7bb1036266fcb6bc1293ab628fe54771

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

    public boolean login(String userName, String password) {
        

    }

    public boolean signUp(String firstName, String lastName, String userName, String password, String userType) {

    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UUID getUserUUID() {
        return userID;
    }

    public void setUserUUID(UUID userID) {
        this.userID = userID;
    }

    
}