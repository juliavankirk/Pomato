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
        mVMenuMain = new VMenuMain(null);
        mVMenuRegister = new VMenuRegister(null);
        mVMenuLogin = new VMenuLogin(null);
        mVMenuManual = new VMenuManual(null);
        mVMenuExit = new VMenuExit(null);
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
                mVMenuRegister.renderMenu(true);
                User user = mVMenuRegister.getUserData();

                mDatabase.addUser( user );
                mVMenuRegister.registerSuccess();
                doMainMenu();
            }
            case 2 -> {
                mVMenuLogin.renderMenu(true);
                mVMenuLogin.readInput();
            }
            case 3 -> {
                mVMenuManual.renderMenu(true);
                mVMenuManual.readInput();
            }
            case 4 -> {
                mVMenuExit.renderMenu(true);
                mVMenuExit.readInput();
            }
            default -> {
                mVMenuMain.renderError();
                doMainMenu();
            }
        }
    }

}
