package view.menu.loggedin.project.holidays;

import controllers.Controller;
import utilities.InputErrors;
import utilities.InputOutput;
import view.VMenu;


public class VMenuRemoveHoliday extends VMenu {

    public VMenuRemoveHoliday(VMenu parent) {
        super(parent);
        mMenuHeader = "Remove Employee's Holiday";
        mMenuLabel = "Manager: Remove Employee's Holiday";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;
    }

    @Override
    public void menuContent(Controller controller) {
        if (controller.getCurrentUser().getRole(controller.getCurrentProject().getId().toString()).equals("Manager")) {
            String answer = "yes";
            if (answer.equals("yes")) {
                String developerName = InputErrors.emptyFieldString(InputOutput.inputString("Please enter developers name to remove Holiday"));
                String remove = controller.removeHolidayFromList(developerName);
                System.out.println(remove);
            }
            }else{

        }
    }
}