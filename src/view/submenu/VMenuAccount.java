package view.submenu;

import controllers.Controller;
import view.VMenu;

import java.util.ArrayList;

public class VMenuAccount extends VMenu {

    public VMenuAccount(VMenu parent) {
        super(parent);
        menuHeader = "User Account";
        menuLabel = "Handle user account";
        menuQuestion = "Enter choice";
        subMenus = new ArrayList<VMenu>();
        subMenus.add(new VMenuRemove(this));

        subMenu = true;

    }
    @Override
    public void menuContent(Controller controller) {

    }
}