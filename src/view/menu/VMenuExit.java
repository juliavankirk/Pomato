package view.menu;

import controllers.Controller;
import utilities.InputOutput;
import view.VMenu;

public class VMenuExit extends VMenu {


    /**
     * Constructors
     */
    public VMenuExit(VMenu parent) {
        super(parent);
        menuHeader = "Exit";
        menuLabel = "Exit Pomato";
        menuQuestion = "Enter choice";
        menuChoice = "E";
        subMenus = null;
//        subMenu = false;
    }


    /**
     * Methods
     */
    @Override
    public void menuContent(Controller controller) {
//        System.out.println(InputOutput.line() + menuHeader + "\n");
        String yesNo = InputOutput.inputString("Are you sure you want to exit?(Yes/No)");

        if (yesNo.equalsIgnoreCase("YES")) {
            System.out.println("Exiting the system. Goodbye!");
            System.exit(0);
        }

        System.out.println(" ");
    }
}
