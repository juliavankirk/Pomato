package view.menu.loggedin.project;

import controllers.Controller;
import model.project.Task;
import model.users.User;
import view.VMenu;

import java.util.ArrayList;

public class VMenuEconomicOverview extends VMenu {

    public VMenuEconomicOverview(VMenu parent) {
        super(parent);
        mMenuHeader = "Economic Overview of your Project";
        mMenuLabel = "Manager: Economic Overview";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;
    }

    @Override
    public void menuContent(Controller controller) {

        printTableMembers(controller);
        printTableTaskOverview(controller);
    }

    // Prints information about Members
    private void printTableMembers(Controller controller) {
        String leftAlignFormat = "| %-25s | %-12s | %-12s | %-16s |%-19s |%n"; // OLD: %-13s |
        String line =     "+---------------------------+--------------+--------------+------------------+--------------------+%n";

        System.out.println(" ");
        System.out.println("Overview of members in your Project");
        System.out.format(line);
        System.out.format("| Member Name,              | Username,    | Hourly Wage, | Monthly Wage,    | Yearly Wage,       |%n"); // OLD:  Hours worked |
        System.out.format(line);
        // TODO add Hours Worked
        //  Username, ++?

        ArrayList<User> projectMembers = controller.getCurrentProject().getProjectMembers();
        for (User currentMember : projectMembers) {
            System.out.format(
                    leftAlignFormat,
                    currentMember.getFirstName() + " " + currentMember.getLastName(),
                    currentMember.getUserName(),
                    String.valueOf(currentMember.getHourlyWage()) + " SEK",
                    String.valueOf(currentMember.getHourlyWage() * 8 * 5 * 4.5) + " SEK",
                    String.valueOf((currentMember.getHourlyWage() * 8 * 5 * 4.5) * 12) + " SEK",
                    String.valueOf(2) // TODO Get total worked hours?
            );
        }

        leftAlignFormat = "| %-40s | %-12s | %-16s |%-19s |%n"; // OLD: %-13s |
        line =            "+------------------------------------------+--------------+------------------+--------------------+%n";
        double totalHourlyWage = calculateTotalHourlyWage(projectMembers);
        System.out.format(line);
        System.out.format("| Total Members,                           | Hourly Wage, | Monthly Wage,    | Yearly Wage,       |%n"); // OLD:  Hours worked |
        System.out.format(line);
        System.out.format(
                leftAlignFormat,
                String.valueOf(projectMembers.size()),
                String.valueOf(totalHourlyWage) + " SEK",
                String.valueOf(totalHourlyWage * 8 * 5 * 4.5) + " SEK",
                String.valueOf((totalHourlyWage * 8 * 5 * 4.5) * 12) + " SEK"
//                String.valueOf(2) // TODO Get total worked hours?
        );
        System.out.format(line);
    }

    // Calculate total hourly wage. Should do this elsewhere.
    private double calculateTotalHourlyWage(ArrayList<User> projectMembers) {
        double totalHourlyWage = 0.0;
        for (User currentMember : projectMembers) {
            totalHourlyWage += currentMember.getHourlyWage();
        }

        return totalHourlyWage;
    }

    // Prints information about Tasks
    private void printTableTaskOverview(Controller controller) {
        String leftAlignFormat = "| %-15s | %-4d | %-11d | %-9d |%n"; // OLD:  %-13d |
        String line =     "+-----------------+------+-------------+-----------+%n";

        System.out.println(" ");
        System.out.println("Overview of tasks in your project");
        System.out.format(line);
        System.out.format("| Amount of tasks | TODO | IN PROGRESS | COMPLETED |%n"); // OLD:  Tasks overdue |
        System.out.format(line);

        ArrayList<Task> projectTasks = controller.getCurrentProject().getTaskList();
        System.out.format(
                leftAlignFormat, projectTasks.size(),
                taskStatus(projectTasks, "TODO"),
                taskStatus(projectTasks, "IN PROGRESS"),
                taskStatus(projectTasks, "COMPLETED")
//                0 // TODO Check overdue tasks
        );
        System.out.format(line);
    }

    // Checks taskStatus
    private int taskStatus(ArrayList<Task> projectTasks, String status){
        int totalTasks = 0;

        for (Task projectTask : projectTasks) {
            if (projectTask.getStatus().equals(status)) {
                totalTasks += 1;
            }
        }
        return totalTasks;
    }

//    private void printTableProject(Controller controller) {
//        // TODO Print project economic overview
//    }
}
