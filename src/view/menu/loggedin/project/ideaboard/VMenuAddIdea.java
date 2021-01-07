package view.menu.loggedin.project.ideaboard;

import controllers.Controller;
import utilities.InputErrors;
import utilities.InputOutput;
import view.VMenu;

import java.util.ArrayList;

public class VMenuAddIdea extends VMenu {

    /**
     * Constructor
     */

    public VMenuAddIdea(VMenu parent) {
        super(parent);
        mMenuHeader = "Ideas";
        mMenuLabel = "Add Idea";
        mMenuQuestion = "Enter choice";
        mSubMenus = new ArrayList<>();
    }


    /**
     * Methods
     */

    public void menuContent(Controller controller) {

        String newIdea = InputErrors.emptyFieldString(InputOutput.inputString("Please type " +
                "your brilliant idea for this project"));
        controller.addIdeaToProject(newIdea);
        System.out.println("Your idea is added to the idea board.");
        System.out.println("");

    }
}
