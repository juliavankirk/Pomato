package view.menu.loggedin.project;

import controllers.Controller;
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

        int ideaNum = InputOutput.inputInt("Please insert the number of idea you wish to add comment to"); //I don't know if this sentence is grammatically correct. Fix it if it's not.
        String comment = InputOutput.inputString("Please write your comment");
        controller.addComment(ideaNum, comment);
        System.out.println("You successfully made a comment about this idea!");
    }
}
