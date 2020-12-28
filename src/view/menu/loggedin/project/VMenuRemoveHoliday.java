package view.menu.loggedin.project;

import controllers.Controller;
import utilities.InputOutput;
import view.VMenu;


public class VMenuRemoveHoliday extends VMenu {

    VMenuRemoveHoliday(VMenu parent) {
        super(parent);
        mMenuHeader = "Remove Employee's Holiday";
        mMenuLabel = "Remove Employee's Holiday";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;
    }

    @Override
    public void menuContent(Controller controller) {
        String developerName = InputOutput.inputString("Please enter developers name to remove Holiday");
        String remove = controller.removeHolidayFromList(developerName);
        System.out.println(remove);
    }
}