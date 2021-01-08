package view.menu.loggedin.project;

import controllers.Controller;
import model.project.Task;
import utilities.TaskTable;
import view.VMenu;
import view.menu.loggedin.project.taskboard.*;

import java.util.ArrayList;

public class VMenuViewTaskBoard extends VMenu {


    /**
     * Constructors
     */
    public VMenuViewTaskBoard(VMenu parent) {
        super(parent);
        mMenuHeader = "Your Task Board";
        mMenuLabel = "View Task Board";
        mMenuQuestion = "Enter choice";
        mSubMenus = new ArrayList<>();
    }


    /**
     *  Methods:
     */
    @Override
    public void menuContent(Controller controller) {
        addMenuOptions(controller);

        ArrayList<Task> taskList = controller.getTaskListFromCurrentProject();
        TaskTable table = new TaskTable(taskList);
        table.print();
    }

    // I made this since we need to add menu options depending on if the user is a manager or not.
    private void addMenuOptions(Controller controller) {
        mSubMenus.clear(); // Clears the subMenu's

        mSubMenus.add(new VMenuCreateTask(this));
        mSubMenus.add(new VMenuEditTask(this));
        mSubMenus.add(new VMenuAddChecklist(this));
        mSubMenus.add(new VMenuRemoveTask(this));
        mSubMenus.add(new VMenuEditTaskboard(this));

        String projectId = controller.getCurrentProject().getId().toString();
        // Only a project manager can access these subMenus
        if (controller.getCurrentUser().getRole(projectId).equals("Manager")){
            // TODO Fix this:
            //            mSubMenus.add(new VMenuAssignTask(this));
        }
    }
}
