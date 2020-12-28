package view.menu.loggedin.project;

import controllers.Controller;
import utilities.InputOutput;
import view.VMenu;

import java.util.ArrayList;

public class VMenuRemoveIdea extends VMenu {

    /**
     * Constructor
     */

    public VMenuRemoveIdea(VMenu parent) {
        super(parent);
        mMenuHeader = "Remove Ideas";
        mMenuLabel = "Remove Idea";
        mMenuQuestion = "Enter choice";
        mSubMenus = new ArrayList<>();
    }


    /**
     * Methods
     */

    public void menuContent(Controller controller) {

        int ideaNum = InputOutput.inputInt("Which idea would you like to remove");
        controller.removeIdea(ideaNum);
        System.out.println("You successfully removed idea number " + ideaNum);
    }
}
