package view.menu.loggedin.account;

import controllers.Controller;
import utilities.InputOutput;
import view.VMenu;

public class VMenuRemoveUser extends VMenu {
    public VMenuRemoveUser(VMenu parent) {
        super(parent);
        mMenuHeader = "Remove Account";
        mMenuLabel = "Remove Account";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;

    }

    @Override
    public void menuContent(Controller controller) {

        String Id = InputOutput.inputString("Please enter your ID");
        controller.removeUser(Id);
    }
}
