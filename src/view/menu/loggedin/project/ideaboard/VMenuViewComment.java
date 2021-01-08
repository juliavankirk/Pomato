package view.menu.loggedin.project.ideaboard;

import controllers.Controller;
import utilities.InputErrors;
import utilities.InputOutput;
import view.VMenu;

import java.util.ArrayList;

public class VMenuViewComment extends VMenu{

    /**
     * Constructor
     */

    public VMenuViewComment(VMenu parent) {
        super(parent);
        mMenuHeader = "Comments";
        mMenuLabel = "View Comments";
        mMenuQuestion = "Enter choice";
        mSubMenus = new ArrayList<>();
    }


    /**
     * Methods
     */

    public void menuContent(Controller controller) {

        if (controller.getCurrentProject().getIdeas().size() == 0) {
            System.out.println("There is no idea to dislike for now.");
        } else {
            int ideaNum = InputErrors.checkMenuChoice(InputOutput.inputString("Which idea's" +
                            " comments do want to see (insert the number of the idea)"),
                    controller.getCurrentProject().getIdeas().size() + 1, 0);
            System.out.println("Here are the comments: \n");
            controller.viewComments(ideaNum);
        }
    }
}
