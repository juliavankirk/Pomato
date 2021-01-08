package view.menu.loggedin.project.taskboard;

import controllers.Controller;
import utilities.InputErrors;
import utilities.InputOutput;
import view.VMenu;

import java.util.ArrayList;

public class VMenuAddChecklist extends VMenu {

    public VMenuAddChecklist(VMenu parent) {
        super(parent);
        mMenuHeader = "Add Checklist";
        mMenuLabel = "Add Checklist";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;
    }

    @Override
    public void menuContent(Controller controller) {
        String name, id, response;
        ArrayList<String> itemList = new ArrayList<>();
        int counter = 0;

        id = InputErrors.emptyFieldString(InputOutput.inputString("Which task would you like to add a checklist to? id"));
        for (int i = 0; i < controller.getCurrentProject().getTaskList().size(); i++) {

            // if the task exists in the current project then we continue adding a checklist.
            if (controller.getCurrentProject().getTaskList().get(i).getId().equals(id)) {
                name = InputErrors.emptyFieldString(InputOutput.inputString("Enter the name of the checklist"));
                //ArrayList<String> itemListTwo = addCheckListItems(itemList, counter);

                response = controller.addChecklist(name, id /*itemListTwo*/);
                System.out.println(response);
            }
        }

        // else we say that the task was not found
        System.out.println("The task was not found. Please try again.");

    }

    private ArrayList<String> addCheckListItems(ArrayList<String> itemList, int counter) {
        String checkListItem = InputOutput.inputString("Enter a text you want to add to the Checklist");
        itemList.add(counter, checkListItem);
        counter += 1;

        String answer = InputOutput.inputString("Would you like to add more things to the checklist?(yes/no)");
        while (answer.equalsIgnoreCase("yes")) {
            answer = "";
            addCheckListItems(itemList, counter);
        }

        return itemList;
    }
}