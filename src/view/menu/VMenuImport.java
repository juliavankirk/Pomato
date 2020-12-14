package view.menu;

import controllers.Controller;
import view.VMenu;

public class VMenuImport extends VMenu {

    public VMenuImport(VMenu parent) {
        super(parent);
        mMenuHeader = "Import data";
        mMenuLabel = "Import data";
        mMenuQuestion = "Enter choice";

    }
    
    @Override
    public void menuContent(Controller controller) {
        System.out.println("The following information has been imported:\n");
        controller.loadDatabaseTwo();
    }
}
