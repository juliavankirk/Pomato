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
        menuHeader = "Main Menu";
        menuLabel = "Go back to Main Menu";
        menuQuestion = "Enter choice";
        menuChoice = "M";
        subMenus = new ArrayList<>();
        subMenus.add(new VMenuRegister(this));
        subMenus.add(new VMenuLogin(this));
        subMenus.add(new VMenuManual(this));
        subMenus.add(new VMenuExit(this));
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
