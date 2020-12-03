package controllers;

import model.project.Database;
import model.project.Project;
import model.users.User;
import view.VMenu;
import view.menu.VMenuMain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;
import model.project.Task;

public class Controller {


    //Attributes
    Database mDatabase;
    VMenu mCurrentMenu;
    private User mCurrentUser;
    private Project mCurrentProject;


    //Constructor
    public Controller() {
        mDatabase = new Database();
        mCurrentMenu = new VMenuMain(null);
        mCurrentUser = null;
        mCurrentProject = null;
    }


    /**
     * Methods
     * I don't know if I like to have the loop like this here but it keeps everything very simple.
     * This loop is what makes moving through the menu's possible.
     */
    public void executeViews(Controller controller) {

        // This is the loop that keeps us within the different menu's
        // Since we are always in a menu this will always run.
        while (mCurrentMenu != null) {

            // The method ".executeMenu" in the class "VMenu" returns the "chosenMenu",
            // which means that "mCurrentMenu" becomes the "chosenMenu".
            // So if we choose the "VMenuLogin" then we execute that menu.
            mCurrentMenu = mCurrentMenu.executeMenu(controller);
        }
    }


    /**
     * Handling Task/Tasks
     */
    public void addTask(String title, String description, LocalDate dueDate, LocalDate startDate, double estimatedTime, double priority) {
        Task task = new Task(title, description, dueDate, startDate, estimatedTime, priority);
        getCurrentProject().addTask(task);
    }

    public String removeTask(String taskId) {
        int taskListSize = getTaskListFromCurrentProject().size();

        for (int i = 0; i < taskListSize; i++) {
            UUID stringUuid = getTaskListFromCurrentProject().get(i).getId();

            if ( stringUuid.toString().equals(taskId)) {
                getCurrentProject().removeTask(i);
                return "Task with ID: " + taskId + " has been removed";
            }
        }
//        if (idToRemove != -1) {
//            mDatabase.removeTask(UUID.fromString(taskId));
//            return "Task with ID: " + taskId + " has been removed";
//        } else {
//            return "Task with ID: " + taskId + " was not found";
//        }
        return "Task with ID: " + taskId + " was not found";
    }

    public Task getTaskById(String taskId) {
        int taskListSize = getTaskListFromCurrentProject().size();
        for (int i = 0; i < taskListSize; i++) {
            UUID stringUuid = getTaskListFromCurrentProject().get(i).getId();
            if (stringUuid.toString().equals(taskId)) {
                return getTaskListFromCurrentProject().get(i);
            }
        }
        return null;
    }

    public ArrayList<Task> getTaskListFromCurrentProject() {

        return getCurrentProject().getTaskList();
    }

    /**
     * Updating Task
     */
    public void updateTaskStatus(String updatedStatus, String taskId){
    Task task = getTaskById(taskId);
    task.setTaskStatus(updatedStatus);
    }
    public void updateTaskTitle(String updatedTitle, String taskId){
        Task task = getTaskById(taskId);
        task.setTaskTitle(updatedTitle);
    }
    public void updateTaskDescription(String updatedDescription, String taskId){
        Task task = getTaskById(taskId);
        task.setTaskDescription(updatedDescription);
    }
    public void updateTaskPriority(Double updatedPriority, String taskId){
        Task task = getTaskById(taskId);
        task.setTaskPriority(updatedPriority);
    }
    public void updateTaskDueDate(LocalDate dueDate, String taskId){
        Task task = getTaskById(taskId);
        task.setTaskDueDate(dueDate);
    }
    public void updateTaskEstimatedTime(Double estimatedTime, String taskId){
        Task task = getTaskById(taskId);
        task.setTaskEstimatedTime(estimatedTime);
    }


    /**
     *  Handling user
     */
    public void addUser(String firstName, String lastName, String password, String companyName, double jobTitle,
            String hourlyWage ) {
        User user = new User( firstName, lastName, password, companyName, jobTitle, hourlyWage);
        mDatabase.addUser( user );
        System.out.println("Your username is: " + user.getId() + "\nYour password is: " + user.getPassword());
    }

    public void removeUser(String id) {
        mDatabase.removeUser(UUID.fromString(id));
    }

    public String logInUser(String enteredUserName, String enteredPassword) {
        Collection<User> userList = mDatabase.getUserList();

        for (Iterator<User> iterator = userList.iterator(); iterator.hasNext();) {
            User someOne  = iterator.next();
            if (someOne.getId().equals(enteredUserName)) {
                if (someOne.getPassword().equals(enteredPassword)) {
                    setCurrentUser(someOne);

                    return "Bravo! You logged in.";
                } else {

                    return "Password is incorrect";
                }
            }
        }
        return "Username is incorrect";
    }

    /**
     * Methods for Current Logged-In User
     */
    public void setCurrentUser(User currentUser) {
        mCurrentUser = currentUser;
    }

    public User getCurrentUser() {
        return mCurrentUser;
    }


    /**
     * Handling Project
     */
    public String createProject(String title, String description, ArrayList<String> enteredIds,
                                LocalDate startDate, LocalDate dueDate/*, String password*/) {

        Project project = new Project(title, description, startDate, dueDate/*, password*/);

        Collection<User> userList = mDatabase.getUserList();

        for (int i = 0; i < enteredIds.size(); i++) {
            for (Iterator<User> iterator = userList.iterator(); iterator.hasNext(); ) {
                User someOne = iterator.next();

                if (someOne.getId().equals(enteredIds.get(i))) {
                   project.getProjectMembers().add(someOne);
                   someOne.getProjects().add(project);
                }
            }
        }

        return "\nProject " + project.getProjectTitle() + " is created successfully!";/*\nThe Id of this project is: " +
                project.getId() + "\nThe password of this project is: " + project.getPassword();
                */
    }

    public ArrayList<Project> getProjects() {
        return getCurrentUser().getProjects();
    }

    /**
     * Methods for Current Project
     */
    public void setCurrentProject(int chosenProject) {
        mCurrentProject = getCurrentUser().getProjects().get(chosenProject);
    }

    public Project getCurrentProject() {
        return mCurrentProject;
    }


//    void doMainMenu() {
//        mVMenuMain.renderMenu(true);
//
//        UUID id = null;
//        String password;
//
//        int mainMenuSelect = mVMenuMain.readInput();
//
//        switch (mainMenuSelect) {
//            case 1 -> {
//                //Register menu
//                mVMenuRegister.renderMenu(true);
//                User user = mVMenuRegister.getUserData();
//
//                mDatabase.addUser( user );
//                mVMenuRegister.registerSuccess();
//                doMainMenu();
//            }
//            case 2 -> {
//                mVMenuLogin.renderMenu(true);
//                mVMenuLogin.readInput();
//            }
//            case 3 -> {
//                mVMenuManual.renderMenu(true);
//                mVMenuManual.readInput();
//            }
//            case 4 -> {
//                mVMenuExit.renderMenu(true);
//                mVMenuExit.readInput();
//            }
//            default -> {
//                mVMenuMain.renderError();
//                doMainMenu();
//            }
//        }
//        doMainMenu();
//    }
}
