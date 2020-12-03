package model.project;

import model.users.User;
import utilities.InvalidDataInput;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.UUID;

public class Project {

    //Attributes
    private String mId;
    private String mProjectTitle;
    private String mProjectDescription;
    private ArrayList<User> mProjectMembers;
    private LocalDate mStartDate;
    private LocalDate mDueDate;
    private ArrayList<Task> mTaskList;
//    private ArrayList<Board> mBoards;


    //Constructor
    public Project(String projectTitle, String projectDescription/*, ArrayList<User> projectMembers*/, LocalDate startDate, LocalDate dueDate/*, String password*/) {
        mId = UUID.randomUUID().toString();
        mProjectTitle = projectTitle;
        mProjectDescription = projectDescription;
        mProjectMembers = new ArrayList<User>();
        mStartDate = startDate;
        mDueDate = dueDate;
        mTaskList = new ArrayList<>();
//        mProjectMembers = projectMembers;
//        mBoards = new ArrayList<Board>();
//        mPassword = password;

        if (mDueDate.isEqual(mStartDate) || mDueDate.isBefore(mStartDate)){
            throw new InvalidDataInput("Invalid input. Duration of the project must be positive");
        }
    }

    //Getters and Setters
    public String getId() { return mId; }

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

    public ArrayList<Task> getTaskList(){ return mTaskList;}
    public void addTask(Task task){ mTaskList.add(task);}
    public void removeTask(int index){ mTaskList.remove(index);}
//    public Task getTaskById (UUID id) { return mTaskList.get(id);}

    /*
    public ArrayList<Board> getBoards() {
        return mBoards;
    }
    public void setBoards(ArrayList<Board> boards) {
        mBoards = boards;
    }
     */

    //Methods
    public long projectDuration () {
        return ChronoUnit.DAYS.between(mStartDate, mDueDate);
    }

    public String toString() {
        String retVal = (getProjectTitle() + " : ");
        retVal += (getProjectDescription() + " ");
        retVal += ("\nProjectMembers" + getProjectMembers());

        return retVal;
    }
}
