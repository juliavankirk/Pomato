package view.menu.loggedin.project.ideaboard;

import controllers.Controller;
import utilities.InputErrors;
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
        if (controller.getCurrentProject().getIdeas().size() == 0) {
            System.out.println("There is no idea to remove for now.");
        } else {
            int ideaNum = InputErrors.checkMenuChoice(InputOutput.inputString("Which idea would " +
                    "you like to remove"),controller.getCurrentProject().getIdeas().size()+1,0);
            controller.removeIdea(ideaNum);
            System.out.println("You successfully removed idea number " + ideaNum);
    }

    }
}
