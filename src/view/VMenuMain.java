package view;


import view.submenu.VMenuLoggedIn;

import java.util.ArrayList;

public class VMenuMain extends VMenu{

//    ArrayList<VMenu> mChildren;

    /**
     * Contructors
     */
    public VMenuMain(VMenu parent) {
        super(null);
        menuHeader = "Main Menu";
        menuLabel = "Go back to Main Menu";
        menuQuestion = "Enter choice";
        menuChoice = "M";
        actions = new ArrayList<>();
//        actions.add()
        subMenus = new ArrayList<VMenu>();
        subMenus.add(new VMenuLoggedIn(this));
//        children.add(new MenuRegister(this));
//        children.add(new VMenuLogin(this));
//        children.add(new VMenuManual(this));
//        children.add(new VMenuExit(this));
        subMenu = true;
    }

    public void renderExit() {
        System.out.println("Exiting the system. Goodbye!");
    }

    public void renderError() {
        System.out.println("Invalid selection, restarting...");
    }

}
