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
        double estimatedTime;
        LocalDate dueDate, startDate, endDate;
        int priority;

        System.out.println("Please enter the following information\n ");
        title = InputOutput.inputString("Title");
        description = InputOutput.inputString("Description");
        estimatedTime = InputOutput.inputDouble("Estimated Time (hours)");
        priority = InputOutput.inputIntMinMax("Priority (1-5)",1,5);
        dueDate = LocalDate.parse(InputOutput.inputString("Due Date (yyyy-mm-dd)"));
        startDate = LocalDate.now();
        //Do we have to initialize startDate? Its already set?
        //problems with endDate
        controller.addTask(title, description, dueDate, startDate, endDate, estimatedTime, priority);

        addMoreTasks(controller);

    }

    private void addMoreTasks (Controller controller) {
        String answer;

        answer = InputOutput.inputString("Would you like to add more tasks?(yes/no)");
        while (answer.equals("yes")) {
            answer = "";
            menuContent(controller);
        }
    }
}
