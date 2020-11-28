package view.menu;

import controllers.Controller;
import view.VMenu;

import java.util.ArrayList;

public class VMenuMessage extends VMenu {


    /**
     * Contructors
     */
    public VMenuMessage(VMenu parent) {
        super(parent);
        menuHeader = "Message Page";
        menuLabel = "View/Send Messages";
        menuQuestion = "Enter choice";
        subMenus = null;

        subMenu = false;
    }

    @Override
    public void menuContent(Controller controller) {
        // TODO personal message center?
    }
}
