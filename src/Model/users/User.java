package Model.users;
import java.util.UUID;


public class User {

    /**
     * Attributes
     */

    private String id = UUID.randomUUID().toString();
    private String userName;
    private String password;

    /**
     * Constructor
     */

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    /**
     * Getters and Setters
     */

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Methods
     */
    public String toString() {
        return "Your username is:\n" + this.userName + "\nYour password is:\n" + this.password + "\nDon't forget these "
                + "information or you will be cursed to not be able to use this app forever";
    }
}
// hiiiii