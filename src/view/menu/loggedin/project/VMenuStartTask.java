package view.menu.loggedin.project;

import controllers.Controller;
import model.project.Task;
import utilities.InputErrors;
import utilities.InputOutput;
import view.VMenu;

import java.util.Collection;

public class VMenuStartTask extends VMenu {

    VMenuStartTask(VMenu parent) {
        super(parent);
        mMenuHeader = "Start Task";
        mMenuLabel = "Start a Task";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;
    }

    @Override
    public void menuContent(Controller controller) {
        Collection<Task> taskList = null;

        controller.getCurrentUser().getTask().toString();

        String task = InputErrors.emptyFieldString(InputOutput.inputString("Enter task you would like to start"));
        for ( Task tasks : taskList) {
            System.out.println(tasks.toString());
        }
        controller.startTask(task);
    }
}
