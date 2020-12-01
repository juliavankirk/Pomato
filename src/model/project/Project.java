package model.project;

import model.users.User;
import utilities.InvalidDataInput;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.UUID;

public class Project {

    //Attributes
    private UUID mId;
    private String mProjectTitle;
    private String mProjectDescription;
    private ArrayList<User> mProjectMembers;
    private LocalDate mStartDate;
    private LocalDate mDueDate;
    private ArrayList<String> mTasks;

    //Constructor
    public Project(String projectTitle, String projectDescription, ArrayList<User> projectMembers, LocalDate startDate, LocalDate dueDate) {
        mId = UUID.randomUUID();
        mProjectTitle = projectTitle;
        mProjectDescription = projectDescription;
        mProjectMembers = projectMembers;
        mStartDate = startDate;
        mDueDate = dueDate;
//        mTasks = new ArrayList<String>();

        if (mDueDate.isEqual(mStartDate) || mDueDate.isBefore(mStartDate)){
            throw new InvalidDataInput("Invalid input. Duration of the project must be positive");
        }
    }

    //Getters and Setters
    public UUID getId() { return mId; }

    public String getProjectTitle() {
        return mProjectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        mProjectTitle = projectTitle;
    }

    public String getProjectDescription() {
        return mProjectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        mProjectDescription = projectDescription;
    }

    public ArrayList<User> getProjectMembers() {
        return mProjectMembers;
    }

    public void setProjectMembers(ArrayList<User> projectMembers) {
        mProjectMembers = projectMembers;
    }

    public LocalDate getStartDate() {
        return mStartDate;
    }

    public void setStartDate(LocalDate startDate) {
        mStartDate = startDate;
    }

    public LocalDate getDueDate() {
        return mDueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        mDueDate = dueDate;
    }

    public ArrayList<String> getTasks() {
        return mTasks;
    }

    public void setTasks(ArrayList<String> tasks) {
        mTasks = tasks;
    }

    //Methods
    public long projectDuration () {
        return ChronoUnit.DAYS.between(mStartDate, mDueDate);
    }

    public String toString() {
        String retVal = (getProjectTitle() + " : ");
        retVal += (getProjectDescription() + " ");
        retVal += ("\nProjectMembers" + getProjectMembers());

        return retVal;
    }
}
