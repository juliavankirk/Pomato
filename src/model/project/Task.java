package model.project;

import view.VMenu;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.Period;
import java.util.UUID;

public class Task implements Serializable {
    private UUID mId;
    private String mTitle;
    private String mDescription;
    private int mPriority;
    private LocalDate mDateCreated;
    private LocalDate mDueDate;
    private String mStatus;
    private ArrayList<Checklist> mChecklists;
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
        mChecklists = new ArrayList<>();
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

    public void setTitle(String title) { mTitle = title; }

    public void setDescription(String description) { mDescription = description;}

    public void setDueDate(LocalDate DueDate){ mDueDate = DueDate; }

    public void setPriority (int taskPriority) { mPriority = taskPriority; }
    public void setEstimatedTime(double estimatedTime){ mEstimatedTime = estimatedTime;}

    public void setPriority (int priority) { mPriority = priority;}

    public void setStatus (String taskStatus){ mStatus = taskStatus; }
    public void setStatus (String status){ mStatus = status;}

    public ArrayList<Checklist> getChecklists(){ return mChecklists;}
    public Checklist getChecklistById (int id) { return mChecklists.get(id);}
    public void addChecklist(Checklist checklist){ mChecklists.add(checklist);}
    public void removeChecklist(int id){ mChecklists.remove(id);}


    public String toString() {
        String retVal = "";
        retVal += ("Title: " +getTitle());
        retVal += ("\nDescription: " +getDescription());
        retVal += ("\nDate Created: " + getDateCreated());
        retVal += ("\nDue Date: " + getDueDate());
        retVal += ("\nPriority: " + getPriority() + "/5");
        retVal += ("\nID: " + getId() + "\n");

        if (!(getChecklists().isEmpty())){
            retVal += ("\nChecklists: ");

            for (int i = 0; i < mChecklists.size(); i++) {
                Checklist currentChecklist = mChecklists.get(i);
                String currentIndex = mChecklists.get(i).toString();
                retVal += (currentChecklist);
            }
        }
        return retVal;
    }
}
