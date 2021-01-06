package view.menu.loggedin;

import controllers.Controller;
import model.users.User;
import utilities.JsonHandler;
import view.VMenu;
import view.menu.loggedin.project.*;

import java.util.ArrayList;

public class VMenuProject extends VMenu {


    /**
     * Constructors
     */
    public VMenuProject(VMenu parent) {
        super(parent);
        mMenuHeader = "Project Page";
        mMenuLabel = "View Project";
        mMenuQuestion = "Enter choice";
        mSubMenus = new ArrayList<>();
//        subMenu = true;
    }

    @Override
    public void menuContent(Controller controller) {
        printProjectMembers(controller);
        addMenuOptions(controller);
    }

    // I made this since we need to add menu options depending on if the user is a manager or not.
    private void addMenuOptions(Controller controller) {
        mSubMenus.clear(); // Clears the subMenu's

        mSubMenus.add(new VMenuViewTaskBoard(this));
        mSubMenus.add(new VMenuCommentBoard(this));
        mSubMenus.add(new VMenuIdeaBoard(this));
        mSubMenus.add(new VMenuPersonalWage(this));
        mSubMenus.add(new VMenuActivityLog(this));
        mSubMenus.add(new VMenuHolidays(this));
        mSubMenus.add(new VMenuAddMember(this));

//        mSubMenus.add(new VMenuAddMember(this));
//        mSubMenus.add(new VMenuChangeRoles(this));
//        subMenu = true;

        String projectId = controller.getCurrentProject().getId().toString();

        // Only a project manager can access these subMenus
        if (controller.getCurrentUser().getRole(projectId).equals("Manager")){
            mSubMenus.add(new VMenuEconomicOverview(this));
            mSubMenus.add(new VMenuChangeRoles(this));
        }
    }

    // Prints project members and their Role
    private void printProjectMembers(Controller controller) {
        ArrayList<User> projectMembers = controller.getCurrentProject().getProjectMembers();

        // Todo - Format this instead
        System.out.println("\nMembers:");
        for (User currentUser : projectMembers) {
            System.out.println(
                    "Username: " + currentUser.getUserName() +
                            " | Name: " + currentUser.getFirstName() + " " + currentUser.getLastName() +
                            " | Role: " + currentUser.getRole(controller.getCurrentProject().getId().toString())
            );
        }
    }
}
