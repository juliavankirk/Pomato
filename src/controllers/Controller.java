package controllers;

import model.Database;
import model.users.User;
import view.*;

import java.util.UUID;

//

public class Controller {
    //Attributes
    Database mDatabase;
    Menu menu;

//    VMenuMain mVMenuMain;
//    VMenuRegister mVMenuRegister;
//    VMenuLogin mVMenuLogin;
//    VMenuManual mVMenuManual;
//    VMenuExit mVMenuExit;


    //Constructor
    public Controller() {
        mDatabase = new Database();
        menu = new Menu();
    }

    public void main() {
//        System.out.println("Welcome to Pomato!\n");
        menu.excecute();
//        doMainMenu();
    }
    
    void addUser(User user) {
        mDatabase.addUser( user );
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
