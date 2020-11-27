package view.submenu;

import view.VMenu;

public class VMenuProject extends VMenu {

    /**
     * Contructors
     */
    public VMenuProject(VMenu parent) {
        super(parent);
    }

    @Override
    public VMenu renderMenu(boolean line) {


        chooseMenu();

        return parent;
    }

}
