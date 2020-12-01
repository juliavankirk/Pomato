package view.menu;

import controllers.Controller;
import utilities.InputOutput;
import view.VMenu;

public class VMenuRemoveUser extends VMenu {
    public VMenuRemoveUser(VMenu parent) {
        super(parent);
        mMenuHeader = "Remove Account";
        mMenuLabel = "Remove";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;

    }

    @Override
    public void menuContent(Controller controller) {


        System.out.println("Remove account:\n ");

        String Id = InputOutput.inputString("Please enter your ID: ");
        controller.removeUser(Id);
    }
}
