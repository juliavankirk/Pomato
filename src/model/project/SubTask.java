package model.project;

import view.VMenu;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class SubTask implements Serializable {
    private UUID   mId;
    private String mTitle;
    private String mDescription;
    private double mEstimatedTime;
    private int mPriority;
    private LocalDate mDateCreated;
    private LocalDate mDueDate;
    private LocalDate mStartDate;
    private LocalDate mEndDate;
    private String mStatus;

    //Do we have to initialize startDate in constructor? Its already set?
    public SubTask(String title, String description, LocalDate dueDate, LocalDate startDate,
                double estimatedTime, int priority) {
        mId = UUID.randomUUID();
        mTitle = title;
        mDescription = description;
        mStartDate = startDate;
        mEndDate = null;
        mEstimatedTime = estimatedTime;
        mPriority = priority;
        mDateCreated = LocalDate.now();
        mDueDate = dueDate;
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

    public void setDescription(String Description) { mDescription = Description; }

    public void setDueDate(LocalDate DueDate){ mDueDate = DueDate; }

    public void setEstimatedTime(double EstimatedTime){ mEstimatedTime = EstimatedTime; }

    public void setPriority (int taskPriority) { mPriority = taskPriority; }

    public void setStatus (String taskStatus){ mStatus = taskStatus; }

    //assigns value to end date
    public void getSubmissionDate(LocalDate endDate) {
        mEndDate = endDate;
    }

    //method that returns total days spent on task
    public long totalDays() {
        //end date is assigned current date if null, otherwise passed value is entered
        LocalDate submission = mEndDate == null ? LocalDate.now() : mEndDate;
        //delta calculation between start and end dates
        long daysBetween = Period.between(mStartDate, submission).getDays() + 1;
        return daysBetween;
    }

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
