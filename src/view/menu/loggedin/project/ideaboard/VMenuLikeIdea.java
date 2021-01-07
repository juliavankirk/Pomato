package view.menu.loggedin.project.ideaboard;

import controllers.Controller;
import utilities.InputErrors;
import utilities.InputOutput;
import view.VMenu;

import java.util.ArrayList;

public class VMenuLikeIdea extends VMenu {

    /**
     * Constructor
     */

    public VMenuLikeIdea(VMenu parent) {
        super(parent);
        mMenuHeader = "Like";
        mMenuLabel = "Like";
        mMenuQuestion = "Enter choice";
        mSubMenus = new ArrayList<>();
    }


    /**
     * Methods
     */

    public void menuContent(Controller controller) {

        if (controller.getCurrentProject().getIdeas().size() == 0) {
            System.out.println("There is no idea to like for now.");
        } else {
            int ideaNum = InputErrors.checkMenuChoice(InputOutput.inputString("Please" +
                            " insert the number of the idea you wish to like"),
                    controller.getCurrentProject().getIdeas().size() + 1, 0);
            controller.addLike(ideaNum);
            System.out.println("You Liked the Idea successfully!");
        }
    }
}
