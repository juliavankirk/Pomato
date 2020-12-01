package model.project;

import view.VMenu;

import java.time.LocalDate;
import java.util.UUID;

public class Task {
    private UUID   mId;
    private String mTaskTitle;
    private String mTaskDescription;
    private double mTaskDueDate;
    private double mTaskEstimatedTime;
    private String mTaskPriority;
    LocalDate mDateCreated;
    private String mTaskStatus;

    public Task(String taskTitle, String taskDescription, double taskDueDate, double taskEstimatedTime, String taskPriority) {
        mId = UUID.randomUUID();
        mTaskTitle = taskTitle;
        mTaskDescription = taskDescription;
        mTaskDueDate = taskDueDate;
        mTaskEstimatedTime = taskEstimatedTime;
        mTaskPriority = taskPriority;
        mDateCreated = LocalDate.now();
        mTaskStatus = "TO-DO";
    }
    public UUID getId() { return mId; }
    public String getTaskTitle(){ return mTaskTitle; }
    public String getTaskDescription(){ return mTaskDescription; }

    public double getTaskDueDate(){ return mTaskDueDate; }

    public double getTaskEstimatedTime(){ return mTaskEstimatedTime; }

    public String getTaskPriority(){ return mTaskPriority; }

    public LocalDate getDateCreated(){ return mDateCreated; }

    public String getTaskStatus(){ return mTaskStatus; }

    public void setTaskTitle(String taskTitle) { mTaskTitle = taskTitle; }

    public void setTaskDescription(String taskDescription) { mTaskDescription = taskDescription;}

    public void setTaskDueDate(double taskDueDate){ mTaskDueDate = taskDueDate;}

    public void setTaskEstimatedTime(double taskEstimatedTime){ mTaskEstimatedTime = taskEstimatedTime;}

    public void setTaskPriority (String taskPriority) { mTaskPriority = taskPriority;}

    public void setDateCreated (LocalDate dateCreated) { mDateCreated = dateCreated; }

    public void setTaskStatus (String taskStatus){ mTaskStatus = taskStatus;}




//    protected ArrayList<Task> mSubTask;




}
