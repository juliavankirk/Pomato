package view.menu.loggedin.project;

import controllers.Controller;
import model.project.SubTask;
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
        double updatedEstimation;
        LocalDate updatedDueDate;
        int property, updatedPriority;

        taskId = InputOutput.inputString("Which task do you want to edit? (ID)");
        SubTask subTask = controller.getTaskById(taskId);

        /*When the user have made a change to a property, they will be given the option
        to make another change to the chosen task, until they enter the number 7.
         */
        if (subTask != null) {
            do {
                propertyChoices();
                property = InputOutput.inputInt("Enter your option");


                switch (property) {
                    case 1 -> {
                        updatedTitle = InputOutput.inputString("Enter new title");
                        controller.updateTaskTitle(updatedTitle, taskId);
                    }
                    case 2 -> {
                        updatedDescription = InputOutput.inputString("Enter new description");
                        controller.updateTaskDescription(updatedDescription, taskId);
                    }
                    case 3 -> {
                        updatedStatus = InputOutput.inputString("Enter new Status(TODO, IN PROGRESS or COMPLETED)");
                        controller.updateTaskStatus(updatedStatus, taskId);
                    }
                    case 4 -> {
                        updatedEstimation = InputOutput.inputDouble("Enter new Estimated Time(hours)");
                        controller.updateTaskEstimatedTime(updatedEstimation, taskId);
                    }
                    case 5 -> {
                        updatedPriority = InputOutput.inputInt("Enter new Priority(1-5)");
                        controller.updateTaskPriority(updatedPriority, taskId);
                    }
                    case 6 -> {
                        updatedDueDate = LocalDate.parse(InputOutput.inputString("Enter new Due Date (yyyy-mm-dd)"));
                        controller.updateTaskDueDate(updatedDueDate, taskId);
                    }

                    case 7 -> {
                        //Case for the user to leave and go back to the taskboard.
                    }
                    default -> {
                        System.out.println("Invalid option");
                    }
                    //TODO Edit task
                }
            } while (property != 7);

        } else {
            System.out.println("invalid id, please enter another id");
        }
    }
        public void propertyChoices() {

        String propertyC = "Which property would you like to change? Type one of the options below:\n" +
                "1. Title\n" +
                "2. Description\n" +
                "3. Status\n" +
                "4. Estimated time\n" +
                "5. Priority\n" +
                "6. Due Date\n"+
                "7. Return\n"; /*Not sure about naming it "return", since they get an option
            afterwards which is go back, maybe Done?*/

        System.out.println(propertyC);
    }
}