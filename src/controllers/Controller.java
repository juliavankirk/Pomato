package controllers;

import model.project.Database;
import model.users.User;
import view.VMenu;
import view.menu.VMenuMain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;
import model.project.Task;

public class Controller {

    //Attributes
    Database mDatabase;
    VMenu mCurrentMenu;

    //Constructor
    public Controller() {
        mDatabase = new Database();
        mCurrentMenu = new VMenuMain(null);
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
            double dueDate,
            double estimatedTime,
            String priority
    ) {
        Task task = new Task(title, description,dueDate,estimatedTime,priority);
        mDatabase.addTask(task);
        System.out.println(task.toString());
    }

        public String removeTask(String taskId)  {
            int idToRemove = -1;
            for (int i = 0; i < getTaskList().size(); i++) {
                if (getTaskList().get(i).getId().equals(taskId)) {
                    idToRemove = i;
                }
                    }
            if (idToRemove != -1) {
                mDatabase.removeTask(UUID.fromString(taskId));
                return "Task with ID: " + taskId + " has been removed";
            } else {
                return "Task with ID: " + taskId + " was not found";
            }
        }



    public ArrayList<Task> getTaskList() {
        return mDatabase.getTaskList();
    }


    /**
     *  Handling user
     */
    public void addUser(
            String firstName,
            String lastName,
            String password,
            String companyName,
            double jobTitle,
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
                    return "Bravo! You logged in.";
                } else {
                    return "Password is incorrect";
                }
            }
        }
        return "Username is incorrect";
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
