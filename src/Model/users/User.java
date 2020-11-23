package Model.users;
import java.util.UUID;


public abstract class User {

    /**
     * Attributes
     */

    private String firstname;
    private String lastName;
    private String id = UUID.randomUUID().toString();
    private String userName;
    private String password;

    /**
     * Constructor
     */

    public User(String firstname, String lastName, String userName, String password) {
        this.firstname = firstname;
        this.lastName = lastName;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Methods
     */
    public String toString() {
        return this.firstname + " " + this.lastName;
    }
}
