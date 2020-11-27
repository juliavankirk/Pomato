package view.submenu;

import view.*;

import java.util.ArrayList;

// When the user is logged in
public class VMenuLoggedIn extends VMenu {

// Leads to:
// 1. Create Project.           -> SubMenuLoggedIn.java
// 2. Fire co-workers.
// 3. Set the world on fire.
// 4. Cry


/**
 * Contructors
 */

    public VMenuLoggedIn(VMenu parent) {
        super(parent);
        menuHeader = "Main Menu";
        menuLabel = "";
        menuQuestion = "Enter choice";
        menuChoice = "M";
        children = new ArrayList<VMenu>();
        children.add(new VMenuProject(this));
    }

    @Override
    public VMenu renderMenu(boolean line) {

        chooseMenu();

        return parent;
    }
}
