package model.project;

import view.VMenu;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class Task implements Serializable {
    private UUID   mId;
    private String mTitle;
    private String mDescription;
    private double mEstimatedTime;
    private int mPriority;
    private LocalDate mDateCreated;
    private LocalDate mDueDate;
    private String mStatus;

    //Do we have to initialize startDate in constructor? Its already set?
    public Task(String Title, String Description, LocalDate DueDate, LocalDate taskStartDate, double EstimatedTime, int Priority) {
        mId = UUID.randomUUID();
        mTitle = Title;
        mDescription = Description;
        mEstimatedTime = EstimatedTime;
        mPriority = Priority;
        mDateCreated = LocalDate.now();
        mDueDate = DueDate;
        mStatus = "TODO";
    }
    public UUID getId() { return mId; }
    public String getTitle(){ return mTitle; }
    public String getDescription(){ return mDescription; }

    public LocalDate getDueDate(){ return mDueDate; }

    public double getEstimatedTime(){ return mEstimatedTime; }

    public double getPriority(){ return mPriority; }

    public LocalDate getDateCreated(){ return mDateCreated; }

    public String getStatus(){ return mStatus; }

    public void setTitle(String Title) { mTitle = Title; }

    public void setDescription(String Description) { mDescription = Description;}

    public void setDueDate(LocalDate DueDate){ mDueDate = DueDate;}

    public void setEstimatedTime(double EstimatedTime){ mEstimatedTime = EstimatedTime;}

    public void setPriority (int taskPriority) { mPriority = taskPriority;}

    public void setStatus (String taskStatus){ mStatus = taskStatus;}




    public String toString() {
        String retVal = "";
        retVal += ("Title: " +getTitle());
        retVal += ("\nDescription: " +getDescription());
        retVal += ("\nDate Created: " + getDateCreated());
        retVal += ("\nDue Date: " + getDueDate());
        retVal += ("\nEstimated Time: " + getEstimatedTime() + " hours");
        retVal += ("\nPriority: " + getPriority() + "/5");
        retVal += ("\nID: " + getId() + "\n");
        return retVal;
    }

}
