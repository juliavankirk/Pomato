package view.menu.loggedin.project;

import controllers.Controller;
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

        int ideaNum = InputOutput.inputInt("Which idea's comments do want to see (insert the number of the idea)"); //I don't know if this sentence is grammatically correct. Fix it if it's not.
        System.out.println("Here are the comments: \n");
        controller.viewComments(ideaNum);
    }
}
