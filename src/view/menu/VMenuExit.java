package view.menu;

import controllers.Controller;
import utilities.InputErrors;
import utilities.InputOutput;
import view.VMenu;

public class VMenuExit extends VMenu {


    /**
     * Constructors
     */
    public VMenuExit(VMenu parent) {
        super(parent);
        mMenuHeader = "Exit";
        mMenuLabel = "Exit Pomato";
        mMenuQuestion = "Enter choice";
        mMenuChoice = "E";
        mSubMenus = null;
//        mSubMenu = false;
    }


    /**
     * Methods
     */
    @Override
    public void menuContent(Controller controller) {


//        System.out.println(InputOutput.line() + menuHeader + "\n");
        String yesNo = InputErrors.incorrectYesOrNo(InputOutput.inputString("Are you sure you want to exit?(Yes/No)"));

        if (yesNo.equalsIgnoreCase("YES")) {
            System.out.println("Exiting the system. Goodbye!");
            System.exit(0);
        }

//        mSubMenus = new ArrayList<>();
//        mSubMenus.add(new VMenuMain(null));

        System.out.println(" ");
    }
}
