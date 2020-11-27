package view;


import controllers.Controller;
import utilities.InputOutput;

import java.util.ArrayList;

public abstract class VMenu {


    /**
     * Attribute
     */

    protected VMenu parent;

    protected boolean line = false;
    protected String menuHeader;
    protected String menuLabel;
    protected String menuQuestion;
    protected String menuChoice;

    protected ArrayList<VMenu> children;


    /**
     * Contructors
     */

    public VMenu(VMenu parent) {
        this.parent = parent;
    }


    /**
     *  Methods
     */

    public abstract VMenu renderMenu(boolean line);

    public VMenu chooseMenu() {
        VMenu chosenVMenu;

        int inputResult = InputOutput.inputInt(menuQuestion);
        if (inputResult > 0 && inputResult < children.size() + 1){
            chosenVMenu = children.get(inputResult - 1);
        } else {
            chosenVMenu = parent;
        }

        return chosenVMenu;
    }

    public void renderExit() {
        System.out.println("Exiting the system. Goodbye!");
    }

    public void renderBack() {
        InputOutput.inputString("Press any key to go back");
    }

    public void renderError() {
        System.out.println("Invalid selection, restarting...");
    }
}