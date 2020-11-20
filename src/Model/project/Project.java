package Model.project;

import Model.users.User;
import tool.InvalidDataInput;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Project {

    /**
     * Attributes
     */

    private String projectTitle;
    private String projectDescription;
    private ArrayList<User> projectMembers;
    private LocalDate startDate;
    private LocalDate dueDate;
    private ArrayList<String> tasks;

    /**
     * Constructor
     */
    public Project(String projectTitle, String projectDescription, ArrayList<User> projectMembers, LocalDate startDate, LocalDate dueDate) {
        this.projectTitle = projectTitle;
        this.projectDescription = projectDescription;
        this.projectMembers = projectMembers;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.tasks = new ArrayList<String>();

        if (this.dueDate.isEqual(this.startDate) || this.dueDate.isBefore(this.startDate)){
            throw new InvalidDataInput("Invalid input. Duration of the project must be positive");
        }
    }

     /**
     * Getters and Setters
     */

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public ArrayList<User> getProjectMembers() {
        return projectMembers;
    }

    public void setProjectMembers(ArrayList<User> projectMembers) {
        this.projectMembers = projectMembers;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public ArrayList<String> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<String> tasks) {
        this.tasks = tasks;
    }

    /**
     * Methods
     */

    public long projectDuration () {
        return ChronoUnit.DAYS.between(this.startDate, this.dueDate);
    }

    public String toString() {
        return "Project title: " + this.projectTitle + "\nproject description: " + this.projectDescription
                + "\nProject members: " + this.projectMembers;
    }
}
