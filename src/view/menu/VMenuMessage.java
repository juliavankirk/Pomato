package view.menu;

import controllers.Controller;
import view.VMenu;

public class VMenuMessage extends VMenu {


    /**
     * Constructors
     */
    public VMenuMessage(VMenu parent) {
        super(parent);
        mMenuHeader = "Message Page";
        mMenuLabel = "View/Send Messages";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;
//        subMenu = false;
    }

    @Override
    public void menuContent(Controller controller) {
        // TODO personal message center?
    }
}
