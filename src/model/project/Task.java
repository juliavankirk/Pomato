package model.project;

import view.VMenu;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class Task implements Serializable {
    private UUID   mId;
    private String mTitle;
    private String mDescription;
    private int mPriority;
    private LocalDate mDateCreated;
    private LocalDate mDueDate;
    private String mStatus;
    private Boolean mCompletion;

    //Do we have to initialize startDate in constructor? Its already set?
    public Task(String title, String description, LocalDate dueDate, int priority) {
        mId = UUID.randomUUID();
        mTitle = title;
        mDescription = description;
        mPriority = priority;
        mDateCreated = LocalDate.now();
        mDueDate = dueDate;
        mStatus = "TODO";
        mCompletion = false; //initialized as false as task is incomplete
    }

    public UUID getId() { return mId; }

    public String getTitle(){ return mTitle; }

    public String getDescription(){ return mDescription; }

    public LocalDate getDueDate(){ return mDueDate; }

    public double getPriority(){ return mPriority; }

    public LocalDate getDateCreated(){ return mDateCreated; }

    public String getStatus(){ return mStatus; }

    public void startTask() { mCompletion = false; }

    public void endTask() { mCompletion = true; }

    public void setTitle(String Title) { mTitle = Title; }

    public void setDescription(String Description) { mDescription = Description; }

    public void setDueDate(LocalDate DueDate){ mDueDate = DueDate; }

    public void setPriority (int taskPriority) { mPriority = taskPriority; }

    public void setStatus (String taskStatus){ mStatus = taskStatus; }

    public String toString() {
        String retVal = "";
        retVal += ("Title: " +getTitle());
        retVal += ("\nDescription: " +getDescription());
        retVal += ("\nDate Created: " + getDateCreated());
        retVal += ("\nDue Date: " + getDueDate());
        retVal += ("\nPriority: " + getPriority() + "/5");
        retVal += ("\nID: " + getId() + "\n");
        return retVal;
    }

}
