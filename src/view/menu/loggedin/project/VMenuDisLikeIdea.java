package view.menu.loggedin.project;

import controllers.Controller;
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
        int ideaNum = InputOutput.inputInt("Please insert the number of the idea you wish to dislike");
        controller.addDisLike(ideaNum);
        System.out.println("You disliked the Idea successfully!");


    }
}
