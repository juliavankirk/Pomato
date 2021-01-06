package model.users;
import com.google.gson.annotations.Expose;
import model.project.Messages;
import model.project.Project;
import model.project.Task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
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
    private double mHourlyWage;

    private ArrayList<Project> mProjects;
    private ArrayList<Role> mRoles;
    private ArrayList<Task> mTasks;
    private HashMap<UUID, ArrayList<Messages>> mInbox;

    private double mTotalWage;
//    private ArrayList<UUID> mProjectsUserCanAccess;

    //Constructor
    public User(String userName, String firstName, String lastName, String password, String companyName,
                double hourlyWage, String jobTitle) {
        mUserName = userName;
        mId = UUID.randomUUID();
        mFirstName = firstName;
        mLastName = lastName;
        mPassword = password;
        mCompanyName = companyName;
        mJobTitle = jobTitle;
        mHourlyWage = hourlyWage;
        mTotalWage = 0;

        mProjects = new ArrayList<Project>();
        mRoles = new ArrayList<Role>();
        mTasks = new ArrayList<Task>();
        mInbox = new HashMap<UUID, ArrayList<Messages>>();

    }

    // Save to .csv:
//    public User(String[] savedAttributes) {
//        mId = UUID.randomUUID();
//        mFirstName= savedAttributes[1];
//        mLastName = savedAttributes[2];
//        mUserName = savedAttributes[3];
//        mPassword = savedAttributes[4];
//        mCompanyName = savedAttributes[5];
//        mHourlyWage = Double.parseDouble(savedAttributes[6]);
//        mJobTitle = savedAttributes[7];
//        mProjects = new ArrayList<Project>();
//        mRoles = new ArrayList<Role>();
//    }

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
        return mFirstName + " " + mLastName;
    }

    public String getFirstName() {
        return mFirstName;
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

    public double getHourlyWage() { return mHourlyWage; }

    public ArrayList<Project> getProjects() {
        return mProjects;
    }

    public ArrayList<Messages> getInbox(UUID Id) { return mInbox.get(mId); }

    public ArrayList<Task> getTask() { return mTasks;}

    public void addMessage (Messages message) {
        ArrayList<Messages> messages = mInbox.get(message.getSenderId());
        if ( null == messages ) {
            messages = new ArrayList<Messages>();
        }
        messages.add(message);
        mInbox.put(message.getSenderId(), messages);
    }

    public boolean removeMessage(int msgIndex, UUID senderId) {
        ArrayList<Messages> messages = mInbox.get(senderId);
        if ( null == messages ) {
            return false;
        } else if ( msgIndex < 0 || msgIndex >= messages.size() ) {
            return false;
        }
        messages.remove(msgIndex);
        if ( messages.isEmpty() ) {
            mInbox.put(senderId, null);
        }
        return true;
    }

    public Set<UUID> getInboxId() {
        return mInbox.keySet();
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

    public ArrayList<Role> getRoles() {
        return mRoles;
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

    public String toString(){
        return "First name: " + mFirstName + "\nLast name: " + mLastName + "\n";
    }
}
