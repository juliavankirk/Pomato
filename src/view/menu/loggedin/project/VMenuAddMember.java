package view.menu.loggedin.project;

import controllers.Controller;
import utilities.InputErrors;
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
        mSubMenus = null;
    }

    public void menuContent(Controller controller) {

        if(controller.getCurrentUser().getRole(controller.getCurrentProject().getId().toString()).equals("Manager")) {

            ArrayList<String> pMembersUsernames = new ArrayList<String>();
            String answer = "yes";
            while (answer.equals("yes")) {
                String memberUsername = InputOutput.inputString("Insert member's username");
                pMembersUsernames.add(memberUsername);
                answer = InputErrors.incorrectYesOrNo(InputOutput.inputString("Do you want to continue adding members?(yes/no)"));
            }
            controller.addMembers(pMembersUsernames);
            System.out.println("if you cannot find a username you have entered before in here, you probably " +
                    "entered it incorrectly or that user is already a member of this project.");
        } else {
            System.out.println("You do not have the authority to make changes in this section, because you are" +
                                "not a manager.");
        }
        System.out.println(" ");
    }

}
