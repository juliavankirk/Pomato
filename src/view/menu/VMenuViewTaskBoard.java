package view.menu;

import controllers.Controller;
import model.project.Task;
import view.VMenu;

import java.util.ArrayList;

public class VMenuViewTaskBoard extends VMenu {

    VMenuViewTaskBoard(VMenu parent) {
        super(parent);
        mMenuHeader = "Your Task Board";
        mMenuLabel = "View Project Board";
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

        ArrayList<Task> taskList = controller.getTaskList();
        for (int i = 0; i < taskList.size(); i++) {
            Task currentTask = taskList.get(i);

            if (currentTask.equals("TO-DO")) {
                System.out.println("TO-DO");
                System.out.println(currentTask);

            } else if (currentTask.equals("IN PROGRESS")) {
                System.out.println("IN PROGRESS");
                System.out.println(currentTask);

            } else {
                System.out.println("COMPLETED");
                System.out.println(currentTask);
            }
        }


    }
}
