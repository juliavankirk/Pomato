package view.menu;

import controllers.Controller;
import view.VMenu;

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
        mSubMenus.add(new VMenuCommentBoard(this));
        mSubMenus.add(new VMenuTaskBoard(this));
//        subMenu = true;
    }

    @Override
    public void menuContent(Controller controller) {

    }
}
