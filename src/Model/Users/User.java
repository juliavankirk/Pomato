package Model.Users;
import java.util.UUID;


public abstract class User {

    //Attributes
    private UUID mId;
    private String mFirstName;
    private String mLastName;
    private String mUserName;
    private String mPassword;

    //Constructor
    public User(String firstName, String lastName, String userName, String password) {
        mId = UUID.randomUUID();
        mFirstName = firstName;
        mLastName = lastName;
        mUserName = userName;
        mPassword = password;
    }

    //Methods
    public UUID getId() { return mId; }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) { mUserName = userName; }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public String getName() {
        return mFirstName + mLastName;
    }

    public void setFirstname(String firstName) {
        mFirstName = firstName ;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }
    abstract String toRow();
}
