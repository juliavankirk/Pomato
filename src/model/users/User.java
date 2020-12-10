package model.users;
import model.project.Project;

import java.util.ArrayList;
import java.util.UUID;


public class User {

    //Attributes
//    private String mUserName;
    private String mId;
    private String mFirstName;
    private String mLastName;
    private String mPassword;
    private String mCompanyName;
    private String mJobTitle;
    private Double mHourlyWage;
    private ArrayList<Project> mProjects;
    private ArrayList<Role> mRoles;
    private double mTotalWage;
//    private ArrayList<UUID> mProjectsUserCanAccess;

    //Constructor
    public User(String firstName, String lastName, String password, String companyName,
                Double hourlyWage, String jobTitle) {
//        mUserName = userName;
        mId = UUID.randomUUID().toString();
        mFirstName = firstName;
        mLastName = lastName;
        mPassword = password;
        mCompanyName = companyName;
        mJobTitle = jobTitle;
        mHourlyWage = hourlyWage;
        mProjects = new ArrayList<Project>();
        mRoles = new ArrayList<Role>();
        mTotalWage = 0;

//        mProjectsUserCanAccess = new ArrayList<>();
    }

    //Methods


//    public String getUserName() {
//        return mUserName;
//    }
//
//    public void setUserName(String mUserName) {
//        this.mUserName = mUserName;
//    }


//    public ArrayList<UUID> getmProjectsUserCanAccess() {
//        return mProjectsUserCanAccess;
//    }

    public String getId() { return mId; }

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

    public void setTotalWage(double totalWage) { mTotalWage = totalWage; }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getCompanyName() { return mCompanyName; }

    public String getJobTitle() { return mJobTitle; }

    public Double getHourlyWage() { return mHourlyWage; }

    public ArrayList<Project> getProjects() {
        return mProjects;
    }

    public String getRole(String projectId) {
        String role = "";
        for(int i = 0; i < mRoles.size(); i++){
            if (projectId.equals(mRoles.get(i).getProjectId())) {
                role = mRoles.get(i).getMemberRole();
            }
        }
        return role;
    }

    public void addRole(String projectId) {
        mRoles.add(new Role(projectId));
    }

    public void changeRole(String projectId) {
        for(int i = 0; i < mRoles.size(); i++){
            if (projectId.equals(mRoles.get(i).getProjectId())) {
                mRoles.get(i).changeRole();
            }
        }
    }

    public String toRow() {
        String retVal = ("User ID: " + getId());
        retVal += ("Employee: " + getName());
        retVal += ("Company: " + getCompanyName());
        retVal += ("Position: " + getJobTitle());
        retVal += ("Hourly Wage: " + getHourlyWage());

        return retVal;
    }

}
