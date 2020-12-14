package view.menu.loggedin.project;

import controllers.Controller;
import model.project.SubTask;
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
        String status;

        System.out.print(InputOutput.shortLine());
        printLists(subTaskList, status = "TODO");
        System.out.print(InputOutput.shortLine());
        printLists(subTaskList, status = "IN PROGRESS");
        System.out.print(InputOutput.shortLine());
        printLists(subTaskList, status = "COMPLETED");
    }

    private void printLists(ArrayList<SubTask> subTaskList, String status) {
        System.out.println(status);

        for (SubTask currentSubTask : subTaskList) {

            if (currentSubTask.getStatus().equals(status)) {
                System.out.print(InputOutput.superShortLine());
                System.out.println(currentSubTask);
            }
        }
        System.out.println(" ");
    }
}
