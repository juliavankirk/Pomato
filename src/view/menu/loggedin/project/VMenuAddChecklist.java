package view.menu.loggedin.project;

import controllers.Controller;
import utilities.InputOutput;
import view.VMenu;

public class VMenuAddChecklist extends VMenu {

    public VMenuAddChecklist(VMenu parent) {
        super(parent);
        mMenuHeader = "Add Checklist";
        mMenuLabel = "Add Checklist";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;
    }

    @Override
    public void menuContent(Controller controller) {

        String name, id, response;
        id = InputOutput.inputString("Which task would you like to add a checklist to? id");
        name = InputOutput.inputString("Enter the name of the checklist");
        response = controller.addChecklist(name, id);
        System.out.println(response);

    }
}
