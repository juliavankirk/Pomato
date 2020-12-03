package view.menu.loggedin;

import controllers.Controller;
import utilities.InputOutput;
import view.VMenu;

import java.time.LocalDate;
import java.util.ArrayList;

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

        ArrayList<String> pMembersIds = new ArrayList<String>();

        String pTitle = InputOutput.inputString("Project title");

        String pDescription = InputOutput.inputString(("Project description"));

        pMembersIds.add(controller.getCurrentUser().getId());
        String answer = InputOutput.inputString("Would you like to add more members?(yes/no)");
        while(answer.equals("yes")) {
            String memberId = InputOutput.inputString("Insert member's Id");
            pMembersIds.add(memberId);
            answer = InputOutput.inputString("Do you want to continue adding members?(yes/no)");
        }

        LocalDate startDate = LocalDate.parse(InputOutput.inputString("Please enter the start date of project (yyyy-mm-dd)"));
        LocalDate dueDate = LocalDate.parse(InputOutput.inputString("Please enter due date of project (yyyy-mm-dd)"));


        String message = controller.createProject(pTitle, pDescription, pMembersIds, startDate, dueDate);
        System.out.println(message);

        System.out.println(" ");
    }
}
