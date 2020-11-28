package view.menu;

import controllers.Controller;
import view.VMenu;

public class VMenuTaskBoard extends VMenu {

    /**
     * Contructors
     */
    public VMenuTaskBoard(VMenu parent) {
        super(parent);
        menuHeader = "Task Board";
        menuLabel = "View Task Board";
        menuQuestion = "Enter choice";
        subMenus = null;
        subMenu = false;
    }

    @Override
    public void menuContent(Controller controller) {

    }
}
