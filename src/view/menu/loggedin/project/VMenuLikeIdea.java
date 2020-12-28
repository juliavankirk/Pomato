package view.menu.loggedin.project;

import controllers.Controller;
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

        int ideaNum = InputOutput.inputInt("Please insert the number of the idea you wish to like");
        controller.addLike(ideaNum);
        System.out.println("You Liked the Idea successfully!");
    }
}
