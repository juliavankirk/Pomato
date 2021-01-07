package view.menu.loggedin.project.taskboard;

import controllers.Controller;
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

        id = InputOutput.inputString("Which task would you like to add a checklist to? id");
        name = InputOutput.inputString("Enter the name of the checklist");
        //ArrayList<String> itemListTwo = addCheckListItems(itemList, counter);

        response = controller.addChecklist(name, id /*itemListTwo*/);
        System.out.println(response);

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