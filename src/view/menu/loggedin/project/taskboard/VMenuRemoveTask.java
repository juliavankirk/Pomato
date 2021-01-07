package view.menu.loggedin.project.taskboard;

import controllers.Controller;
import utilities.InputOutput;
import view.VMenu;

public class VMenuRemoveTask extends VMenu {

    public VMenuRemoveTask(VMenu parent) {
        super(parent);
        mMenuHeader = "Remove Task";
        mMenuLabel = "Remove Task";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;
    }

    @Override
    public void menuContent(Controller controller) {
        String id = InputOutput.inputString("Please enter task ID");
        String remove = controller.removeTask(id);
        System.out.println(remove);
    }
}