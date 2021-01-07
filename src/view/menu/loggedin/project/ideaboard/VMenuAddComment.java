package view.menu.loggedin.project.ideaboard;

import controllers.Controller;
import utilities.InputErrors;
import utilities.InputOutput;
import view.VMenu;

import java.util.ArrayList;

public class VMenuAddComment extends VMenu {

    /**
     * Constructor
     */

    public VMenuAddComment(VMenu parent) {
        super(parent);
        mMenuHeader = "Comments";
        mMenuLabel = "Add Comments";
        mMenuQuestion = "Enter choice";
        mSubMenus = new ArrayList<>();
    }


    /**
     * Methods
     */

    public void menuContent(Controller controller) {
        if (controller.getCurrentProject().getIdeas().size() == 0) {
            System.out.println("There is no idea to add comment for now.");
        } else {
            int ideaNum = InputErrors.checkMenuChoice(InputOutput.inputString("Please insert " +
                    "the number of the idea you wish to add comment to"),
                    controller.getCurrentProject().getIdeas().size()+1,0);
            String comment = InputErrors.emptyFieldString(InputOutput.inputString("Please write your comment"));
            controller.addComment(ideaNum, comment);
            System.out.println("You successfully made a comment about this idea!");
        }
    }
}
