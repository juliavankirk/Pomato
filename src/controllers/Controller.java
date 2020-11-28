package controllers;

import model.project.Database;
import model.users.User;
import view.*;
import view.menu.VMenuMain;

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
        while (mCurrentMenu != null) {
            mCurrentMenu = mCurrentMenu.executeMenu(controller);
        }
    }


    public void addUser(
            String firstName,
            String lastName,
            String password,
            String companyName,
            double jobTitle,
            String hourlyWage ) {
        User user = new User(firstName, lastName, password, companyName, jobTitle, hourlyWage);
        mDatabase.addUser( user );
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
