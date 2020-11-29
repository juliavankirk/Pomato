package view.menu;

import controllers.Controller;
import utilities.InputOutput;
import view.VMenu;

public class VMenuRemove extends VMenu {
    public VMenuRemove(VMenu parent) {
        super(parent);
        mMenuHeader = "Remove Account";
        mMenuLabel = "Remove";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;

    }

    @Override
    public void menuContent(Controller controller) {
        System.out.println("Remove your account:\n ");

        String Id = InputOutput.inputString("Please enter your ID: ");
        controller.removeUser(Id);
    }
}
