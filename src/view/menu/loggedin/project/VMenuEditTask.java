package view.menu.loggedin.project;

import controllers.Controller;
import model.project.Task;
import utilities.InputOutput;
import view.VMenu;

import java.time.LocalDate;

public class VMenuEditTask extends VMenu {


    /**
     * Contructors
     */
    public VMenuEditTask(VMenu parent) {
        super(parent);
        mMenuHeader = "Edit Task";
        mMenuLabel = "Edit Task";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;
    }

    @Override
    public void menuContent(Controller controller) {
        //TODO

        String taskId, updatedTitle, updatedDescription, updatedStatus;
        double updatedEstimation, updatedPriority;
        LocalDate updatedDueDate;
        int property;

        taskId = InputOutput.inputString("Which task do you want to edit? (ID)");
        Task foundId = controller.getTaskById(taskId);

        if (foundId != null) {
            property = InputOutput.inputInt("Which property would you like to change?" +
                    "\n(1)Title" +
                    "\n(2)Description" +
                    "\n(3)Estimated Time" +
                    "\n(4)Priority" +
                    "\n(5)Due Date" +
                    "\n(6)Status");

                switch (property) {
                    case 1 -> {
                        updatedTitle = InputOutput.inputString("Enter new title");
                        controller.updateTaskTitle(updatedTitle, taskId);
                    }
                    case 2 -> {
                        updatedDescription = InputOutput.inputString("Enter new title");
                        controller.updateTaskDescription(updatedDescription, taskId);
                    }
                    case 3 -> {
                        updatedStatus = InputOutput.inputString("Enter new title");
                        controller.updateTaskStatus(updatedStatus, taskId);
                    }
                    case 4 -> {
                        updatedEstimation = InputOutput.inputDouble("Enter new Estimated Time(hours)");
                        controller.updateTaskEstimatedTime(updatedEstimation,taskId);
                    }
                    case 5 -> {
                        updatedPriority = InputOutput.inputDouble("Enter new Priority(1-5)");
                        controller.updateTaskPriority(updatedPriority,taskId);
                    }
                    case 6 -> {
                        updatedDueDate = LocalDate.parse(InputOutput.inputString("Enter new Due Date (yyyy-mm-dd)"));
                        controller.updateTaskDueDate(updatedDueDate,taskId);
                    }

                    case 7 ->{

                    }
                    default -> {
                        System.out.println("Invalid option");
                    }
                    //TODO Edit task
                }
        } else {
            System.out.println("invalid");
        }
    }
}