package controllers;

import model.Database;
import model.users.User;
import view.*;

import java.util.UUID;

public class Controller {
    //Attributes
    Database mDatabase;
    VMenuMain mVMenuMain;
    VMenuRegister mVMenuRegister;
    VMenuLogin mVMenuLogin;
    VMenuManual mVMenuManual;
    VMenuExit mVMenuExit;


    //Constructor
    public Controller() {
        mDatabase = new Database();
        mVMenuMain = new VMenuMain(null,mVMenuRegister,mVMenuLogin,mVMenuManual,mVMenuExit);
        mVMenuRegister = new VMenuRegister(null);
    }

    public void main() {
        System.out.println("Welcome to Pomato!\n");

        doMainMenu();
    }

    void doMainMenu() {
        mVMenuMain.renderMenu(true);

        UUID id = null;
        String password;

        int mainMenuSelect = mVMenuMain.readInput();

        switch (mainMenuSelect) {
            case 1 -> {
                //Register menu
                User user = mVMenuRegister.getUserData();

                mDatabase.addUser( user );
                mVMenuRegister.registerSuccess();
                doMainMenu();
            }
            case 2 -> {
                mVMenuLogin.renderMenu(true);

            }
            case 3 -> {

            }
            case 4 -> {

            }
            default -> {
                mVMenuMain.renderError();
                doMainMenu();
            }
        }
    }

}
