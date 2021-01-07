package view.menu.loggedin.project;

import controllers.Controller;
import utilities.InputErrors;
import utilities.InputOutput;
import view.VMenu;

public class VMenuViewMyActivity extends VMenu {

    VMenuViewMyActivity(VMenu parent) {
        super(parent);
        mMenuHeader = "View my Activity";
        mMenuLabel = "View my Activity";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;
    }

    @Override
    public void menuContent(Controller controller) {
        int select = InputErrors.irrelevantInt(InputOutput.inputString("Select one of the following options" +
                "\n1. View all tasks" +
                "\n2. View total salary accrued"
        ));

        switch (select) {
            case 1 -> {
                controller.showAllTasks();
            }

            case 2 -> {
                controller.showTotalSalary();
            }
        }

    }

}