package view.menu;

import model.project.Task;
import utilities.InputOutput;
import view.VMenu;
import controllers.Controller;

import java.awt.im.InputContext;

public class VMenuCreateTask extends VMenu {

    VMenuCreateTask(VMenu parent) {
        super(parent);
        mMenuHeader = "Create Task";
        mMenuLabel = "Create Task";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;
    }

    @Override
    public void menuContent(Controller controller) {
        String taskTitle, taskDescription, taskPriority;
        double taskDueDate, taskEstimatedTime;

        taskTitle = InputOutput.inputString("Title");
        taskDescription = InputOutput.inputString("Description");
        taskPriority = InputOutput.inputString("Priority");

        taskDueDate = InputOutput.inputDouble("Due Date (yyyy-mm-dd): ");
        taskEstimatedTime = InputOutput.inputDouble("Estimated Time (yyyy-mm-dd): ");

        //controller.addTask(taskTitle,taskDescription,taskPriority,taskDueDate,taskEstimatedTime);


        System.out.println("");

    }
}
