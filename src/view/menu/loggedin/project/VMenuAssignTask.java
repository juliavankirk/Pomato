package view.menu.loggedin.project;

import controllers.Controller;
import utilities.InputOutput;
import view.VMenu;

import java.time.LocalDate;

public class VMenuAssignTask extends VMenu {

    /**
     * Constructors
     */
    public VMenuAssignTask(VMenu parent) {
        super(parent);
        mMenuHeader = "Assign Tasks";
        mMenuLabel = "Assign Tasks to Developers";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;
//        subMenu = false;
    }

    @Override
    public void menuContent(Controller controller) {
        String title, description;
        double estimatedTime;
        LocalDate dueDate, startDate, endDate = null;
        int priority;

        System.out.println("Please enter the following information\n ");
        title = InputOutput.inputString("Task:");
        description = InputOutput.inputString("Description:");
        priority = InputOutput.inputIntMinMax("Priority (1-5)",1,5);
        dueDate = LocalDate.parse(InputOutput.inputString("Due Date (yyyy-mm-dd)"));
        startDate = LocalDate.now();
        //Do we have to initialize startDate? Its already set?
        //problems with endDate
        //controller.addTask(title, description, dueDate, startDate, endDate, priority);

        //addMoreTasks(controller);
        // TODO personal comment board?
    }
}
