package view.menu.loggedin.project;

import controllers.Controller;
import model.project.Task;
import utilities.InputOutput;
import view.VMenu;

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
    }


    /**
     *  Methods:
     */
    @Override
    public void menuContent(Controller controller) {
        ArrayList<Task> taskList = controller.getTaskListFromCurrentProject();
        String status;

        System.out.print(InputOutput.shortLine());
        printLists(taskList, status = "TODO");
        System.out.print(InputOutput.shortLine());
        printLists(taskList, status = "IN PROGRESS");
        System.out.print(InputOutput.shortLine());
        printLists(taskList, status = "COMPLETED");
    }

    private void printLists(ArrayList<Task> taskList, String status) {
        System.out.println(status);

        for (Task currentTask : taskList) {

            if (currentTask.getTaskStatus().equals(status)) {
                System.out.print(InputOutput.superShortLine());
                System.out.println(currentTask);
            }
        }
        System.out.println(" ");
    }
}
