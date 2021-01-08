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
        mSubMenus.add(new VMenuCreateTask(this));
        mSubMenus.add(new VMenuRemoveTask(this));
        mSubMenus.add(new VMenuEditTask(this));
        mSubMenus.add(new VMenuAddChecklist(this));
        mSubMenus.add(new VMenuEditTaskboard(this));
    }


    /**
     *  Methods:
     */
    @Override
    public void menuContent(Controller controller) {
        ArrayList<Task> taskList = controller.getTaskListFromCurrentProject();

        TaskTable table = new TaskTable(taskList);
        table.print();
    }
}
