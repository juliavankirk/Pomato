package view.menu.loggedin.project;

import controllers.Controller;
import utilities.InputOutput;
import view.VMenu;

import java.util.ArrayList;

public class VMenuAddMember extends VMenu {

    /**
     * Constructor
     */
    public VMenuAddMember(VMenu parent) {
        super(parent);
        mMenuHeader = "Add new members";
        mMenuLabel = "Add members";
        mMenuQuestion = "Enter choice";
    }

    public void menuContent(Controller controller) {

        if(controller.getCurrentUser().getRole(controller.getCurrentProject().getId()).equals("Manager")) {

            ArrayList<String> pMembersIds = new ArrayList<String>();
            String answer = "yes";
            while (answer.equals("yes")) {
                String memberId = InputOutput.inputString("Insert member's Id");
                //TODO check if member IDs exist
                pMembersIds.add(memberId);
                answer = InputOutput.inputString("Do you want to continue adding members?(yes/no)");
            }
            controller.addMembers(pMembersIds);
            System.out.println("New members are successfully added");
        } else {
            System.out.println("You do not have the authority to make changes in this section. Because you are nothing" +
                    " more than a poor developer.");
        }
        System.out.println(" ");
    }

}
