package view.menu.loggedin.project;

import controllers.Controller;
import model.project.SubTask;
import model.project.Task;
import utilities.InputOutput;
import utilities.TaskTable;
import view.VMenu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        mSubMenus.add(new VMenuCreateSubtask(this));
        mSubMenus.add(new VMenuRemoveTask(this));
        mSubMenus.add(new VMenuEditTask(this));
        mSubMenus.add(new VMenuAddChecklist(this));
    }


    /**
     *  Methods:
     */
    @Override
    public void menuContent(Controller controller) {
        ArrayList<SubTask> subTaskList = controller.getTaskListFromCurrentProject();

        TaskTable table = new TaskTable(subTaskList);
        table.print();
    }
}
