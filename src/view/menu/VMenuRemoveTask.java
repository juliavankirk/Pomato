package view.menu;

import controllers.Controller;
import utilities.InputOutput;
import view.VMenu;

public class VMenuRemoveTask extends VMenu {

    VMenuRemoveTask(VMenu parent) {
        super(parent);
        mMenuHeader = "Remove Task";
        mMenuLabel = "Remove";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;
    }

    @Override
    public void menuContent(Controller controller) {

        System.out.println("Remove Tasks:\n ");

        String id = InputOutput.inputString("Please enter task ID: ");
        controller.removeTask(id);

    }
}


