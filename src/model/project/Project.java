package model.project;

import com.google.gson.annotations.Expose;
import model.users.User;
//import utilities.InvalidDataInput;

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
    private LocalDate mStartDate;
    private LocalDate mDueDate;

    // I need to do this "transient" otherwise we get into a loop since we store User in Project and Project in User.
    // "transient" is the alternative to "@Expose", which can determine if an attribute can be serialized or deserialized.
    // This means that we do not store this information, for now.
    @Expose(serialize = false, deserialize = false)
    private transient ArrayList<User> mProjectMembers;

    // This is temporary until we fix storing the Projects correctly:
    private ArrayList<UUID> mProjectMemberUUIDs;

//    private ArrayList<SubTask> mSubTaskList;
    private ArrayList<Task> mTaskList;
    private ArrayList <Holiday> mHolidayList;
    private ArrayList<Idea> mIdeas;
    private ArrayList<String> mActivityList;



    //Constructor
    public Project(String projectTitle, String projectDescription,
                   LocalDate startDate, LocalDate dueDate) {
        mId = UUID.randomUUID();
        mProjectTitle = projectTitle;
        mProjectDescription = projectDescription;
        mStartDate = startDate;
        mDueDate = dueDate;
        mProjectMembers = new ArrayList<>();
        mProjectMemberUUIDs = new ArrayList<>();
//        mSubTaskList = new ArrayList<>();
        mTaskList = new ArrayList<>();
        mHolidayList = new ArrayList<>();
        mIdeas = new ArrayList<>();
        mActivityList = new ArrayList();


//        mProjectMembers = projectMembers;
//        mBoards = new ArrayList<Board>();
//        mPassword = password;

//        if (mDueDate.isEqual(mStartDate) || mDueDate.isBefore(mStartDate)){
//            throw new InvalidDataInput("Invalid input. Due date must come after date of creation.");
//        }
    }

    public Project(String title) {
        mId = UUID.randomUUID();
        mProjectTitle = title;
        mProjectDescription = "";
        mProjectMembers = new ArrayList<User>();
        mProjectMemberUUIDs = new ArrayList<>();
//        mSubTaskList = new ArrayList<>();
        mTaskList = new ArrayList<>();
        mIdeas = new ArrayList<Idea>();
        mHolidayList = new ArrayList<>();
        mActivityList = new ArrayList();
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

    public ArrayList<Idea> getIdeas() {
        return mIdeas;
    }

    public void setIdeas(ArrayList<Idea> Ideas) {
        mIdeas = Ideas;
    }

    public ArrayList<UUID> getProjectMemberUUIDs() {
        return mProjectMemberUUIDs;
    }

    public void setProjectMemberUUIDs(ArrayList<UUID> mProjectMemberUUIDs) {
        this.mProjectMemberUUIDs = mProjectMemberUUIDs;
    }

    /**
     * Methods
     */

    public long projectDuration () {
        return ChronoUnit.DAYS.between(mStartDate, mDueDate);
    }

    public ArrayList<Task> getTaskList(){ return mTaskList; }
    public void addTaskToList(Task task){ mTaskList.add(task); }
    public void removeTask(int index){ mTaskList.remove(index); }
    // public Task getTaskById (UUID id) { return mTaskList.get(id);}
    public Task getTaskById (int index) { return mTaskList.get(index);}

    public ArrayList<Holiday> getHolidayList() { return mHolidayList; }
    public void addHolidayToList(Holiday holiday){ mHolidayList.add(holiday); }
    public void removeHoliday(int index){ mHolidayList.remove(index); }
    public Holiday getHolidayByName (int index) { return mHolidayList.get(index);}

    public void AddIdea(Idea idea) {
        mIdeas.add(idea);
    }

    public void removeIdea(Idea idea) {
        mIdeas.remove(idea);
    }

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
