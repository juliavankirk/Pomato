package view.menu.loggedin.project;

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
        String title, description;
        double priority, estimatedTime;
        LocalDate dueDate, startDate;

        System.out.println("Please enter the following information\n ");
        title = InputOutput.inputString("Title");
        description = InputOutput.inputString("Description");
        estimatedTime = InputOutput.inputDouble("Estimated Time (hours)");
        priority = InputOutput.inputIntMinMax("Priority (1-5)",1,5);
        dueDate = LocalDate.parse(InputOutput.inputString("Due Date (yyyy-mm-dd)"));
        startDate = LocalDate.now();
        controller.addTask(title, description, dueDate, startDate, estimatedTime, priority);

        addMoreTasks(controller);
//        System.out.println("");

    }

    private void addMoreTasks (Controller controller) {
        String answer;

        answer = InputOutput.inputString("Would you like to add more tasks?(yes/no)");
        while (answer.equals("yes")) {
            answer = "";
            menuContent(controller);
        }
//        System.out.println("");
    }
}
