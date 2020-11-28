package view.menu;


import controllers.Controller;
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
        mSubMenus.add(new VMenuManual(this));
        mSubMenus.add(new VMenuExit(this));
//        subMenu = true;
    }


    /**
     * Methods
     */
    @Override
    public void menuContent(Controller controller) {

    }


//    public void renderExit() {
//        System.out.println("Exiting the system. Goodbye!");
//    }
//
//    public void renderError() {
//        System.out.println("Invalid selection, restarting...");
//    }

}
