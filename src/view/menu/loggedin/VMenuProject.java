package view.menu.loggedin;

import controllers.Controller;
import model.users.User;
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
        mSubMenus.add(new VMenuViewTaskBoard(this));
        mSubMenus.add(new VMenuCommentBoard(this));
        mSubMenus.add(new VMenuAddMember(this));
        mSubMenus.add(new VMenuChangeRoles(this));
        mSubMenus.add(new VMenuPersonalWage(this));
//        subMenu = true;
    }

    @Override
    public void menuContent(Controller controller) {
        printProjectMembers(controller);
    }

    // Prints project members and their Role
    private void printProjectMembers(Controller controller) {
        ArrayList<User> projectMembers = controller.getCurrentProject().getProjectMembers();

        System.out.println("\nMembers:");
        for (int i = 0; i < projectMembers.size(); i++) {
            User currentUser = projectMembers.get(i);

            System.out.println(
                "Username: " + currentUser.getUserName() +
                " | Name: " + currentUser.getFirstName() + " " + currentUser.getLastName() +
                " | Role: " + currentUser.getRole(controller.getCurrentProject().getId().toString())
            );
        }
    }
}
