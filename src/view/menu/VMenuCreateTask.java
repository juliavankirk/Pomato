package view.menu;

import model.project.Task;
import utilities.InputOutput;
import view.VMenu;
import controllers.Controller;

import java.awt.im.InputContext;
import java.time.LocalDate;

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
        String title, description, priority;
        double estimatedTime;
        LocalDate dueDate;

        System.out.println("Please enter the following information\n ");
        title = InputOutput.inputString("Title");
        description = InputOutput.inputString("Description");
        priority = InputOutput.inputString("Priority (1-5)");
        dueDate = LocalDate.parse(InputOutput.inputString("Due Date (yyyy-mm-dd)"));
        estimatedTime = InputOutput.inputDouble("Estimated Time (hours)");

        controller.addTask(title, description, dueDate, estimatedTime, priority);


        System.out.println("");

    }
}
