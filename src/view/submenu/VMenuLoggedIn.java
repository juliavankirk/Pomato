package view.submenu;

import view.*;

import java.util.ArrayList;

// When the user is logged in
public class VMenuLoggedIn extends VMenu {

/**
 * Contructors
 */

    public VMenuLoggedIn(VMenu parent) {
        super(parent);
        menuHeader = "Your Personal Menu";
        menuLabel = "Logged-In Menu";
        menuQuestion = "Enter choice";
        subMenus = new ArrayList<VMenu>();
        subMenus.add(new VMenuProject(this));

        subMenu = true;
    }
}
