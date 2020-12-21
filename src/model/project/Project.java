package model.project;

import model.users.User;
import utilities.InvalidDataInput;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.UUID;

public class Project implements Serializable {

    //Attributes
    private UUID mId;
    private String mProjectTitle;
    private String mProjectDescription;
    private ArrayList<User> mProjectMembers;
    private LocalDate mStartDate;
    private LocalDate mDueDate;
    private ArrayList<SubTask> mSubTaskList;
    private ArrayList<String> mActivityList;




    //Constructors
    public Project(String projectTitle, String projectDescription/*, ArrayList<User> projectMembers*/,
                   LocalDate startDate, LocalDate dueDate) {
        mId = UUID.randomUUID();
        mProjectTitle = projectTitle;
        mProjectDescription = projectDescription;
        mProjectMembers = new ArrayList<>();
        mStartDate = startDate;
        mDueDate = dueDate;
        mSubTaskList = new ArrayList<>();
        mActivityList = new ArrayList();


//        mProjectMembers = projectMembers;


        if (mDueDate.isEqual(mStartDate) || mDueDate.isBefore(mStartDate)){
            throw new InvalidDataInput("Invalid input. Due date must come after date of creation.");
        }
    }

    public Project(String title) {
        mId = UUID.randomUUID();
        mProjectTitle = title;
        mProjectMembers = new ArrayList<User>();
        mSubTaskList = new ArrayList<>();
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


    /**
     * Methods
     */

    public long projectDuration () {
        return ChronoUnit.DAYS.between(mStartDate, mDueDate);
    }

    public ArrayList<SubTask> getTaskList(){ return mSubTaskList; }
    public void addTaskToList(SubTask subTask){ mSubTaskList.add(subTask); }
    public void removeTask(int index){ mSubTaskList.remove(index); }
    // public Task getTaskById (UUID id) { return mTaskList.get(id);}
    public SubTask getTaskById (int index) { return mSubTaskList.get(index);}

    public ArrayList<String> getActivityList(){return mActivityList;}
    public void addActivity(String activity){mActivityList.add(activity);}

    /*
    public ArrayList<Board> getBoards() {
        return mBoards;
    }
    public void setBoards(ArrayList<Board> boards) {
        mBoards = boards;
    }
     */

    public String getInfo(){
        String projectInfo =
                getId() + ";" +
                getProjectTitle() + ";" +
                getProjectDescription() + ";" +
                getProjectMembers().get(0) + ";" +
                getStartDate() + ";" +
                getDueDate() + ";" +
                getTaskList() + ";"
                ;

        return projectInfo;
    }

    public String toString() {
        String retVal = (getProjectTitle() + " : ");
        retVal += (getProjectDescription() + " ");
        retVal += ("\nProjectMembers" + getProjectMembers());

        return retVal;
    }
}
