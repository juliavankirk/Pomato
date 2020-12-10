package model.users;
import model.project.Project;
import model.project.Task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;


public class User implements Serializable {

    //Attributes
    private String mUserName;
    private UUID mId;
    private String mFirstName;
    private String mLastName;
    private String mPassword;
    private String mCompanyName;
    private String mJobTitle;
    private Double mHourlyWage;
    private ArrayList<Project> mProjects;
    private ArrayList<Role> mRoles;
    private HashMap<UUID, ArrayList<Task>> mTasks;

//    private ArrayList<UUID> mProjectsUserCanAccess;

    //Constructor
    public User(String userName, String firstName, String lastName, String password, String companyName,
                Double hourlyWage, String jobTitle) {
        mUserName = userName;
        mId = UUID.randomUUID();
        mFirstName = firstName;
        mLastName = lastName;
        mPassword = password;
        mCompanyName = companyName;
        mJobTitle = jobTitle;
        mHourlyWage = hourlyWage;
        mProjects = new ArrayList<Project>();
        mRoles = new ArrayList<Role>();
        mTasks = new HashMap<UUID, ArrayList<Task>>();

//        mProjectsUserCanAccess = new ArrayList<>();
    }

    //Methods


    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }


//    public ArrayList<UUID> getmProjectsUserCanAccess() {
//        return mProjectsUserCanAccess;
//    }

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

    public ArrayList<Project> getProjects() {
        return mProjects;
    }

    public String getRole(String projectId) {
        String role = "";
        for (Role mRole : mRoles) {
            if (projectId.equals(mRole.getProjectId())) {
                role = mRole.getMemberRole();
            }
        }
        return role;
    }

    public void addRole(String projectId) {
        mRoles.add(new Role(projectId));
    }

    public void changeRole(String projectId) {
        for (Role mRole : mRoles) {
            if (projectId.equals(mRole.getProjectId())) {
                mRole.changeRole();
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
