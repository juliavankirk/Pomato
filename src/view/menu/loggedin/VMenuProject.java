package view.menu.loggedin;

import controllers.Controller;
import model.project.Project;
import utilities.InputOutput;
import view.VMenu;
import view.menu.loggedin.project.VMenuCommentBoard;
import view.menu.loggedin.project.VMenuViewTaskBoard;

import java.util.ArrayList;

public class VMenuProject extends VMenu {


    /**
     * Constructors
     */
    public VMenuProject(VMenu parent) {
        super(parent);
        mMenuHeader = "Project Page";
        mMenuLabel = "View Project";
        mMenuQuestion = "Enter choice";
        mSubMenus = new ArrayList<>();
        mSubMenus.add(new VMenuViewTaskBoard(this));
        mSubMenus.add(new VMenuCommentBoard(this));
//        subMenu = true;
    }

    @Override
    public void menuContent(Controller controller) {
        // 1. Create new Board
        // 2. View task board
    }
}
