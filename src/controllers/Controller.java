package controllers;

import model.project.Database;
import model.users.User;
import view.VMenu;
import view.menu.VMenuMain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

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


    public void addUser(
//
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

    public String createProject(String title, String description, String ownerId) {
        User pOwner = null;
        Collection<User> userList = mDatabase.getUserList();
        for (Iterator<User> iterator = userList.iterator(); iterator.hasNext();) {
            User somOne = iterator.next();
            if(somOne.getId().equals(ownerId)) {
                pOwner = somOne;
            }
        }
        ArrayList<User> projectMembers = new ArrayList<>();
        projectMembers.add(pOwner);

//        Project project = new Project(title, description, projectMembers);

        return "The project is created successfully!";
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
