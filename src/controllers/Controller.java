package controllers;

import model.project.Database;
import model.project.Project;
import model.project.Task;
import model.users.User;
import view.VMenu;
import view.menu.VMenuMain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

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

    public void addTask(
            String title,
            String description,
            LocalDate dueDate,
            LocalDate startDate,
            double estimatedTime,
            double priority
    ) {
        Task task = new Task(title, description, dueDate, startDate, estimatedTime, priority);
//        mDatabase.addTask(task);
        getCurrentProject().addTask(task);
    }

    public String removeTask(String taskId)  {
        int taskListSize = getTaskListFromCurrentProject().size();

        for (int i = 0; i < taskListSize; i++) {
            UUID stringUuid = getTaskListFromCurrentProject().get(i).getId();

            if ( stringUuid.toString().equals(taskId)) {
                mDatabase.removeTask(i);
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


    public ArrayList<Task> getTaskListFromCurrentProject() {

        return getCurrentProject().getTaskList();
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


    //User can create project and add members
    public String createProject(String title, String description, ArrayList<String> enteredIds,
                                LocalDate startDate, LocalDate dueDate) {

        Project project = new Project(title, description, startDate, dueDate);
        String projectId = project.getId();

        Collection<User> userList = mDatabase.getUserList();

        for (int i = 0; i < enteredIds.size(); i++) {
            for (Iterator<User> iterator = userList.iterator(); iterator.hasNext(); ) {
                User someOne = iterator.next();

                if (someOne.getId().equals(enteredIds.get(i))) {
                   project.getProjectMembers().add(someOne);
                   someOne.getProjects().add(project);
                   someOne.addRole(projectId);
                }
            }
        }
        mCurrentUser.changeRole(projectId);

        return "\nProject " + project.getProjectTitle() + " is created successfully!";/*\nThe Id of this project is: " +
                project.getId() + "\nThe password of this project is: " + project.getPassword();
                */
    }

    public ArrayList<Project> getProjects() {
        return getCurrentUser().getProjects();
    }

    public void addMembers(ArrayList<String> newMembersIds) {

        Collection<User> userList = mDatabase.getUserList();

        for (int i = 0; i < newMembersIds.size(); i++) {
            for (Iterator<User> iterator = userList.iterator(); iterator.hasNext(); ) {
                User someOne = iterator.next();

                if (someOne.getId().equals(newMembersIds.get(i))) {
                    mCurrentProject.getProjectMembers().add(someOne);
                    someOne.getProjects().add(mCurrentProject);
                    someOne.addRole(mCurrentProject.getId());
                }
            }
        }


    }

    public void changeRoles(ArrayList<String> memberIds) {

        for(int i = 0; i < memberIds.size(); i++) {
            for(int j = 0; j < getCurrentProject().getProjectMembers().size(); j++) {
                if(memberIds.get(i).equals(getCurrentProject().getProjectMembers().get(j).getId())) {
                    getCurrentProject().getProjectMembers().get(j).changeRole(getCurrentProject().getId());
                }
            }

        }
        System.out.println("Roles are successfully changed");
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
     * Methods for Current Project
     */
    public void setCurrentProject(int chosenProject) {
        mCurrentProject = getCurrentUser().getProjects().get(chosenProject);
    }

    public Project getCurrentProject() {
        return mCurrentProject;
    }

    //    public void removeUser(UUID id) {
//        mDatabase.removerUser(UUID id);
//    }

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
