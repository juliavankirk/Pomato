package model.project;

import view.VMenu;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
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
    private ArrayList<Checklist> mChecklists;


    //Do we have to initialize startDate in constructor? Its already set?
    public Task(String title, String description, LocalDate dueDate, LocalDate dateCreated, double estimatedTime, int priority) {
        mId = UUID.randomUUID();
        mTitle = title;
        mDescription = description;
        mEstimatedTime = estimatedTime;
        mPriority = priority;
        mDateCreated = LocalDate.now();
        mDueDate = dueDate;
        mStatus = "TODO";
        mChecklists = new ArrayList<>();
    }

    public UUID getId() { return mId; }
    public String getTitle(){ return mTitle; }
    public String getDescription(){ return mDescription; }

    public LocalDate getDueDate(){ return mDueDate; }

    public double getEstimatedTime(){ return mEstimatedTime; }

    public double getPriority(){ return mPriority; }

    public LocalDate getDateCreated(){ return mDateCreated; }

    public String getStatus(){ return mStatus; }

    public void setTitle(String title) { mTitle = title; }

    public void setDescription(String description) { mDescription = description;}

    public void setDueDate(LocalDate dueDate){ mDueDate = dueDate;}

    public void setEstimatedTime(double estimatedTime){ mEstimatedTime = estimatedTime;}

    public void setPriority (int priority) { mPriority = priority;}

    public void setStatus (String status){ mStatus = status;}

    public ArrayList<Checklist> getChecklists(){ return mChecklists;}
    public void addChecklist(Checklist checklist){ mChecklists.add(checklist);}
    public void removeChecklist(int index){ mChecklists.remove(index);}


    public String toString() {
        String retVal = "";
        retVal += ("Title: " +getTitle());
        retVal += ("\nDescription: " +getDescription());
        retVal += ("\nDate Created: " + getDateCreated());
        retVal += ("\nDue Date: " + getDueDate());
        retVal += ("\nEstimated Time: " + getEstimatedTime() + " hours");
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
