package view.menu;


import controllers.Controller;
import utilities.JsonHandler;
import view.VMenu;

import java.util.ArrayList;

public class VMenuMain extends VMenu {


    /**
     * Constructors
     */
    public VMenuMain(VMenu parent) {
        super(null);
        mMenuHeader = "Main Menu";
        mMenuLabel = "Go back to Main Menu";
        mMenuQuestion = "Enter choice";
        mMenuChoice = "M";
        mSubMenus = new ArrayList<>();
        mSubMenus.add(new VMenuRegister(this));
        mSubMenus.add(new VMenuLogin(this));
        mSubMenus.add(new VMenuImport(this));
        mSubMenus.add(new VMenuManual(this));
        mSubMenus.add(new VMenuExit(this));
//        mSubMenus.add(new VMenuLoggedIn(this));
//        mSubMenu = true;
    }

    /**
     * Methods
     */
    @Override
    public void menuContent(Controller controller) {
        // Empty since we only want to display the menu options(the SubMenus)
    }
}

