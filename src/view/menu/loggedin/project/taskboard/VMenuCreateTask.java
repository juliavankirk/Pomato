package view.menu.loggedin.project.taskboard;

import utilities.InputOutput;
import view.VMenu;
import controllers.Controller;

import java.time.LocalDate;
import java.util.ArrayList;

public class VMenuCreateTask extends VMenu {

    public VMenuCreateTask(VMenu parent) {
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
        LocalDate dueDate, startDate;
        int priority;
        String username;

        //stores usernames into an arraylist instead of hashmap, in order to assign more than one task to each id
        ArrayList<String> assignees = new ArrayList<String>();

        System.out.println("Please enter the following information\n ");
        title = InputOutput.inputString("Title");
        description = InputOutput.inputString("Description");
        estimatedTime = InputOutput.inputDouble("Estimated Time (hours)");
        priority = InputOutput.inputIntMinMax("Priority (1-5)",1,5);
        dueDate = LocalDate.parse(InputOutput.inputString("Due Date (yyyy-mm-dd)"));
        startDate = LocalDate.now();
        username = InputOutput.inputString("Enter username of employee you would like to assign this to");
        assignees.add(username);

        String input = InputOutput.inputString("Would you like to assign more members to this task? (yes/no)");
        //possibility to assign other employees to same task
        while(input.equals("yes")) {
            String otherMembers = InputOutput.inputString("Enter the username of the employee you would like"
                    + "to assign this task to");
            assignees.add(otherMembers);
            input = InputOutput.inputString("Would you like to assign more members to this task? (yes/no)");
            menuContent(controller);
        }

        controller.addTask(title, description, dueDate, startDate, estimatedTime, priority, assignees);

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
