package view.menu.loggedin.project.ideaboard;

import controllers.Controller;
import utilities.InputErrors;
import utilities.InputOutput;
import view.VMenu;

import java.util.ArrayList;

public class VMenuDisLikeIdea extends VMenu {

    /**
     * Constructor
     */

    public VMenuDisLikeIdea(VMenu parent) {
        super(parent);
        mMenuHeader = "Dislike";
        mMenuLabel = "Dislike";
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
            int ideaNum = InputErrors.checkMenuChoice(InputOutput.inputString("Please insert the " +
                            "number of the idea you wish to dislike"),
                    controller.getCurrentProject().getIdeas().size()+1,0);
            controller.addDisLike(ideaNum);
            System.out.println("You disliked the Idea successfully!");
        }


    }
}
