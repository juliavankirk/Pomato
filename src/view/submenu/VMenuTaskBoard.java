package view.submenu;

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
}
