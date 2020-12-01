package view.menu;

import controllers.Controller;
import utilities.InputOutput;
import view.VMenu;

public class VMenuCreateProject extends VMenu {

    /**
     *  Constructor
     */
    public VMenuCreateProject(VMenu parent) {
        super(parent);
        mMenuHeader = "New project";
        mMenuLabel = "Create new project";
        mMenuQuestion = "Enter choice";

    }

    @Override
    public void menuContent(Controller controller) {

        String pTitle = InputOutput.inputString("Project title");
        String pDescription = InputOutput.inputString(("Project description"));
        String pOwner = InputOutput.inputString(("Insert your ID: "));

        String message = controller.createProject(pTitle, pDescription, pOwner);
        System.out.println(message);



    }
}
