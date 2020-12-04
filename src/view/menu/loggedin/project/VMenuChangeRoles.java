package view.menu.loggedin.project;

import controllers.Controller;
import utilities.InputOutput;
import view.VMenu;

import java.util.ArrayList;

public class VMenuChangeRoles extends VMenu {

    /**
     * Constructor
     */

    public VMenuChangeRoles (VMenu parent) {
        super(parent);
        mMenuHeader = "Change members roles";
        mMenuLabel = "Change members roles";
        mMenuQuestion = "Enter choice";
    }

    @Override
    public void menuContent(Controller controller) {
        if(controller.getCurrentUser().getRole(controller.getCurrentProject().getId()).equals("Manager")) {
        ArrayList<String> newRolesIds = new ArrayList<>();
        String answer = "yes";
        while(answer.equals("yes")) {
            String newRoleId = InputOutput.inputString("Insert the IDs of members you wish to change their " +
                    "roles");
            newRolesIds.add(newRoleId);
            answer = InputOutput.inputString("Would you like to add more IDs?(yes/No)");
        }
        controller.changeRoles(newRolesIds);
        } else {
            System.out.println("You do not have the authority to make changes in this section. Because you are nothing more " +
                    "than a poor developer.");
        }
        System.out.println(" ");
//2nd
    }
}
