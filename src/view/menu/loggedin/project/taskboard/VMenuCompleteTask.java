package view.menu.loggedin.project;

import controllers.Controller;
import utilities.InputErrors;
import utilities.InputOutput;
import view.VMenu;

public class VMenuCompleteTask extends VMenu {

    VMenuCompleteTask(VMenu parent) {
        super(parent);
        mMenuHeader = "Complete Task";
        mMenuLabel = "Mark Task for Completion";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;
    }

    @Override
    public void menuContent(Controller controller) {

        String submit = InputErrors.emptyFieldString(InputOutput.inputString("Enter task to mark for completion"));
        controller.submitTask(submit);


    }
}
