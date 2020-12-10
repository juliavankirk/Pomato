package view.menu.loggedin.project;

import controllers.Controller;
import view.VMenu;

public class VMenuCommentBoard extends VMenu {


    /**
     * Constructors
     */
    public VMenuCommentBoard(VMenu parent) {
        super(parent);
        mMenuHeader = "Comment Board";
        mMenuLabel = "View Comments Board";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;
//        subMenu = false;
    }

    @Override
    public void menuContent(Controller controller) {
        // TODO personal comment board?
    }
}