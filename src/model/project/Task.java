package model.project;

import view.VMenu;

import java.time.LocalDate;
import java.util.UUID;

public class Task {
    private UUID   mId;
    private String mTaskTitle;
    private String mTaskDescription;
    private double mTaskEstimatedTime;
    private String mTaskPriority;
    private LocalDate mDateCreated;
    private LocalDate mTaskDueDate;
    private String mTaskStatus;

    public Task(String taskTitle, String taskDescription, LocalDate taskDueDate, LocalDate taskStartDate, double taskEstimatedTime, String taskPriority) {
        mId = UUID.randomUUID();
        mTaskTitle = taskTitle;
        mTaskDescription = taskDescription;
        mTaskEstimatedTime = taskEstimatedTime;
        mTaskPriority = taskPriority;
        mDateCreated = LocalDate.now();
        mTaskDueDate = taskDueDate;
        mTaskStatus = "TODO";
    }
    public UUID getId() { return mId; }
    public String getTaskTitle(){ return mTaskTitle; }
    public String getTaskDescription(){ return mTaskDescription; }

    public LocalDate getTaskDueDate(){ return mTaskDueDate; }

    public double getTaskEstimatedTime(){ return mTaskEstimatedTime; }

    public String getTaskPriority(){ return mTaskPriority; }

    public LocalDate getDateCreated(){ return mDateCreated; }

    public String getTaskStatus(){ return mTaskStatus; }

    public void setTaskTitle(String taskTitle) { mTaskTitle = taskTitle; }

    public void setTaskDescription(String taskDescription) { mTaskDescription = taskDescription;}

    public void setTaskDueDate(LocalDate taskDueDate){ mTaskDueDate = taskDueDate;}

    public void setTaskEstimatedTime(double taskEstimatedTime){ mTaskEstimatedTime = taskEstimatedTime;}

    public void setTaskPriority (String taskPriority) { mTaskPriority = taskPriority;}

    public void setDateCreated (LocalDate dateCreated) { mDateCreated = dateCreated; }

    public void setTaskStatus (String taskStatus){ mTaskStatus = taskStatus;}




    public String toString() {
        String retVal = "";
        retVal += ("Title: " +getTaskTitle());
        retVal += ("\nDescription: " +getTaskDescription());
        retVal += ("\nDate Created: " + getDateCreated());
        retVal += ("\nDue Date: " + getTaskDueDate());
//        retVal += ("\nStatus: " + getTaskStatus());
        retVal += ("\nEstimated Time: " + getTaskEstimatedTime() + " hours");
        retVal += ("\nPriority: " + getTaskPriority() + "/5");
        retVal += ("\nID: " + getId() + "\n");
        return retVal;
    }

}
