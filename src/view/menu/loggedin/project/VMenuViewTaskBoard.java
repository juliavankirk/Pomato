package view.menu.loggedin.project;

import controllers.Controller;
import model.project.Task;
import utilities.InputOutput;
import view.VMenu;

import java.util.ArrayList;

public class VMenuViewTaskBoard extends VMenu {


    /**
     * Constructors
     */
    public VMenuViewTaskBoard(VMenu parent) {
        super(parent);
        mMenuHeader = "Your Task Board";
        mMenuLabel = "View Task Board";
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

        System.out.print(InputOutput.shortLine());
        printTodo(taskList);
        System.out.print(InputOutput.shortLine());
        printInProgress(taskList);
        System.out.print(InputOutput.shortLine());
        printCompleted(taskList);
    }

    private void printTodo(ArrayList<Task> taskList) {
        System.out.println("TODO");

        for (Task currentTask : taskList) {

            if (currentTask.getTaskStatus().equals("TODO")) {
                System.out.print(InputOutput.superShortLine());
                System.out.println(currentTask);
            }
        }
        System.out.println(" ");
    }

    private void printInProgress(ArrayList<Task> taskList) {
        System.out.println("IN PROGRESS");

        for (Task currentTask : taskList) {

            if (currentTask.getTaskStatus().equals("IN PROGRESS")) {
                System.out.print(InputOutput.superShortLine());
                System.out.println(currentTask);
            }
        }
        System.out.println(" ");
    }

    private void printCompleted(ArrayList<Task> taskList) {
        System.out.println("COMPLETED");

        for (Task currentTask : taskList) {

            if (currentTask.getTaskStatus().equals("COMPLETED")) {
                System.out.print(InputOutput.superShortLine());
                System.out.println(currentTask);
            }
        }
        System.out.println(" ");
    }
}
