package view.menu;

import controllers.Controller;
import view.VMenu;

public class VMenuTaskBoard extends VMenu {

    /**
     * Constructors
     */
    public VMenuTaskBoard(VMenu parent) {
        super(parent);
        mMenuHeader = "Task Board";
        mMenuLabel = "View Task Board";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;
//        subMenu = false;
    }

    @Override
    public void menuContent(Controller controller) {

    }
}
