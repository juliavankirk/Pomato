package view.menu;

import controllers.Controller;
import view.VMenu;

public class VMenuCommentBoard extends VMenu {


    /**
     * Constructors
     */
    public VMenuCommentBoard(VMenu parent) {
        super(parent);
        menuHeader = "Comment Board";
        menuLabel = "View Comments Board";
        menuQuestion = "Enter choice";
        subMenus = null;
//        subMenu = false;
    }

    @Override
    public void menuContent(Controller controller) {
        // TODO personal comment board?
    }
}
