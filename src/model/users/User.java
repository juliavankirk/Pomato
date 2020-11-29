package model.users;
import java.util.UUID;


public class User {

    //Attributes
    private String mUserName;
    private UUID mId;
    private String mFirstName;
    private String mLastName;
    private String mPassword;
    private String mCompanyName;
    private String mJobTitle;
    private Double mHourlyWage;

    //Constructor
    public User( String userName, String firstName, String lastName, String password, String companyName,
                Double hourlyWage, String jobTitle) {
        mUserName = userName;
        mId = UUID.randomUUID();
        mFirstName = firstName;
        mLastName = lastName;
        mPassword = password;
        mCompanyName = companyName;
        mJobTitle = jobTitle;
        mHourlyWage = hourlyWage;
    }

    //Methods


    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public UUID getId() { return mId; }

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

    public String getCompanyName() { return mCompanyName; }

    public String getJobTitle() { return mJobTitle; }

    public Double getHourlyWage() { return mHourlyWage; }

    public String toRow() {
        String retVal = ("User ID: " + getId());
        retVal += ("Employee: " + getName());
        retVal += ("Company: " + getCompanyName());
        retVal += ("Position: " + getJobTitle());
        retVal += ("Hourly Wage: " + getHourlyWage());

        return retVal;
    }

}
