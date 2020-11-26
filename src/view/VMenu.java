package view;


import controllers.Controller;
import utilities.InputOutput;

import java.util.ArrayList;

public abstract class VMenu {


    /**
     * Attribute
     */

    Controller viewController;
    VMenu parent;

    boolean line = false;
    String menuHeader;
    String menuLabel;
    String menuQuestion;
    String menuChoice;

    ArrayList<VMenu> children;


    /**
     * Contructors
     */

    public VMenu(VMenu parent) {
        this.parent = parent;
    }


    /**
     *  Methods
     */

    public abstract void renderMenu(boolean line);

    public abstract int readInput();

    public void renderExit() {
        System.out.println("Exiting the system. Goodbye!");
    }

    public void readBack() {
        InputOutput.inputString("Press any key to go back");
    }

    public void renderError() {
        System.out.println("Invalid selection, restarting...");
    }
}