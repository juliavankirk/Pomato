package view.menu.loggedin.project;

import controllers.Controller;
import utilities.InputErrors;
import utilities.InputOutput;
import view.VMenu;

public class VMenuRemoveTask extends VMenu {

    VMenuRemoveTask(VMenu parent) {
        super(parent);
        mMenuHeader = "Remove Task";
        mMenuLabel = "Remove Task";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;
    }

    @Override
    public void menuContent(Controller controller) {
        String id = InputErrors.emptyFieldString(InputOutput.inputString("Please enter task ID"));
        String remove = controller.removeSubTask(id);
        System.out.println(remove);
    }
}