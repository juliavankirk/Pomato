package view.menu.loggedin.project;

import controllers.Controller;
import utilities.InputOutput;
import view.VMenu;

import java.time.LocalDate;
import java.util.ArrayList;

public class VMenuAssignTask extends VMenu {

    /**
     * Constructors
     */
    public VMenuAssignTask(VMenu parent) {
        super(parent);
        mMenuHeader = "Assign Tasks";
        mMenuLabel = "Assign Tasks to Developers";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;
//        subMenu = false;
    }

    @Override
    public void menuContent(Controller controller) {

        if(controller.getCurrentUser().getRole(controller.getCurrentProject().getId().toString()).equals("Manager")) {
            ArrayList<String> assignees = new ArrayList<String>();

            assignees.add(controller.getCurrentUser().getUserName());
            String answer = InputOutput.inputString("Would you like to add more members?(yes/no)");
            while (answer.equals("yes")) {
                String memberUsername = InputOutput.inputString("Insert member's username");
                assignees.add(memberUsername);
                answer = InputOutput.inputString("Do you want to continue adding members?(yes/no)");
            }

            controller.assignMembers(assignees);
            System.out.println("New members are successfully added");
        } else {
            System.out.println("You do not have the authority to modify in this section.");
        }
        System.out.println(" ");
    }
}
