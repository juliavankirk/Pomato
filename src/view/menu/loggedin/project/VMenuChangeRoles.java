package view.menu.loggedin.project;

import controllers.Controller;
import utilities.InputErrors;
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
        mMenuLabel = "Manager: Change members roles";
        mMenuQuestion = "Enter choice";
    }

    @Override
    public void menuContent(Controller controller) {
        if(controller.getCurrentUser().getRole(controller.getCurrentProject().getId().toString()).equals("Manager")) {
        ArrayList<String> newRolesUsernames = new ArrayList<>();
        String answer = "yes";
        while(answer.equals("yes")) {
            String newRoleUsername = InputErrors.emptyFieldString(InputOutput.inputString("Insert the usernames of the members you" +
                    " wish to change their role"));
            newRolesUsernames.add(newRoleUsername);
            answer = InputErrors.incorrectYesOrNo(InputOutput.inputString("Would you like to " +
                    "add more usernames?(yes/No)"));
        }
        controller.changeRoles(newRolesUsernames);
        } else {
            System.out.println("You do not have the authority to make changes in this section. Because " +
                    "you are not a manager in this project.");
        }
        System.out.println(" ");

    }
}
