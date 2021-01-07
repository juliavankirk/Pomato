package view.menu.loggedin.project.taskboard;

import controllers.Controller;
import utilities.InputOutput;
import utilities.TaskTable;
import view.VMenu;

public class VMenuEditTaskboard extends VMenu{

    public VMenuEditTaskboard(VMenu parent) {
        super(parent);
        mMenuHeader = "Edit the Task Board";
        mMenuLabel = "Edit the Task Board";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;
    }

    @Override
    public void menuContent(Controller controller) {
        menuChoices();
        int menuChoice = InputOutput.inputInt("Enter your option");


        switch (menuChoice) {
            case 1 -> {
                TaskTable.cardWidth = InputOutput.inputInt("Enter a value between 10-100: ");
            }
            case 2 -> {
                TaskTable.cardBorderVerticalChar = InputOutput.inputString("Enter a character or two( Standard: || ): ");
            }
            case 3 -> {
                TaskTable.dividerHorizontalChar = InputOutput.inputString("Enter a single character( Standard: - ): ");
            }
            case 4 -> {
                TaskTable.dividerCornerChar = InputOutput.inputString("Enter a character or two( Standard: ++ ): ");
            }
            case 5 -> {
                // go back
            }
            default -> {
                System.out.println("Invalid option");
            }
        }
    }

    public void menuChoices() {

        String menuItems = "Which property would you like to change? Type one of the options below:\n" +
                "1. Change card width           ( Standard: 42 )\n" +
                "2. Change Vertical Character   ( Standard: || )\n" +
                "3. Change Horizontal Character ( Standard: -  )\n" +
                "4. Change Corner Character     ( Standard: ++ )\n" +
                "--------------------\n" +
                "5. Done\n";

        System.out.println(menuItems);
    }
}