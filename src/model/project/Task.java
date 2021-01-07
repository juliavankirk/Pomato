package model.project;

import com.google.gson.annotations.Expose;
import model.users.User;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
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
    private LocalDate mStartDate;
    private LocalDate mEndDate;
    private String mStatus;
    private Boolean mCompletion;
    private ArrayList<Checklist> mChecklists;

    // I need to do this "transient" otherwise we get into a loop since we store User in Project and Project in User.
    // "transient" is the alternative to "@Expose", which can determine if an attribute can be serialized or deserialized.
    // This means that we do not store this information, for now.
    @Expose(serialize = false, deserialize = false)
    private transient ArrayList<User> mUserList;

    //Do we have to initialize startDate in constructor? Its already set?
    public Task(String title, String description, LocalDate dueDate, LocalDate startDate,
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
        mCompletion = false;
        mChecklists = new ArrayList<>();
        mUserList = new ArrayList<>();
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

    public LocalDate getStartDate() {
        return mStartDate;
    }

    public Boolean Completion() { return mCompletion; }

    public void beginTask() { mCompletion = false; }

    public void completeTask() { mCompletion = true; }

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

    public ArrayList<Checklist> getChecklists(){ return mChecklists;}
    public Checklist getChecklistById (int id) { return mChecklists.get(id);}
    public void addChecklist(Checklist checklist){ mChecklists.add(checklist);}
    public void removeChecklist(int id){ mChecklists.remove(id);}

    public ArrayList<User> getUserList() { return mUserList; }

    public void setUserList(ArrayList<User> userList) {
        this.mUserList = mUserList;
    }

    public User getUserById (int id ) { return mUserList.get(id);}

    public void addUser(User user) { mUserList.add(user); }

    public void removeUser(int id) { mUserList.remove(id); }

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
