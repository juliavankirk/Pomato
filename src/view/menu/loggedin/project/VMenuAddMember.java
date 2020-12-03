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
        ArrayList<String> pMembersIds = new ArrayList<String>();
        String answer = "yes";
        while(answer.equals("yes")) {
            String memberId = InputOutput.inputString("Insert member's Id");
            pMembersIds.add(memberId);
            answer = InputOutput.inputString("Do you want to continue adding members?(yes/no)");
        }
        controller.addMembers(pMembersIds);
        System.out.println("New members are successfully added");
        System.out.println(" ");
    }

}
