package view.menu.loggedin.project;

import controllers.Controller;
import view.VMenu;

public class VMenuEditTask extends VMenu {


    /**
     * Contructors
     */
    public VMenuEditTask(VMenu parent) {
        super(parent);
        mMenuHeader = "Edit Task";
        mMenuLabel = "Edit Task";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;
    }

    @Override
    public void menuContent(Controller controller) {
        //TODO
        System.out.println("Which task do you want to edit? (ID)");

        System.out.println("Which property would you like to change?(T)Title");

        //TODO Edit task
    }
}