package view;


import controllers.Controller;
import utilities.InputOutput;

import java.util.ArrayList;

public abstract class VMenu {


    /**
     * Attribute
     */

    protected VMenu mParentMenu;

    protected String menuHeader;
    protected String menuLabel;
    protected String menuQuestion;
    protected String menuChoice;

    protected ArrayList<VMenu> subMenus;
    protected boolean subMenu;


    /**
     * Contructors
     */

    public VMenu(VMenu parent) {
        mParentMenu = parent;
    }


    /**
     *  Methods
     *  executeMenu handles everything that happens when we want to launch a menu
     *  It prints and handles Input.
     *  It then is supposed to send relevant data into the controller to be handled.
     *  Then, in all menu's, we are asked a question.
     *
     *  1. Execute menu (Print, Input, Send data to be handled by controller)
     *  2. Choose sub-menu
     *
     */

    // 1. This handles executing a menu
    public VMenu executeMenu(Controller controller) {

        // 2. Every Menu has a header.
        System.out.println(InputOutput.line() + menuHeader + "\n");

        // 3. This prints Sub Menu choices. But only if the menu has Sub Menu's
        if (subMenu == true) {
            for (int i = 0; i < subMenus.size(); i++) {
                System.out.println((i + 1) + ". " + subMenus.get(i).menuLabel);
            }
        }

        // 4. This handles any extra choices in the menu. Until we want to go back.
        menuContent(controller);

        // 5. This method only runs if we are in a Sub Menu. Main Menu can't have "Go back".
        if (mParentMenu != null) {

            if (subMenu == true) {
                System.out.println((subMenus.size() + 1) + ". Go back");
            } else {
                System.out.println("1. Go back");
            }
        }
        System.out.println("");

        // 6. We go to the last method that handles asking a question to the user.
        return chooseMenu(mParentMenu);
    }

    // 4. A Menu can choose it's own content.
    public abstract void menuContent(Controller controller);

    // 6. A menu at last contains a question. Where do you want to go?
    public VMenu chooseMenu(VMenu mParent) {
        VMenu chosenVMenu;


        int inputResult = InputOutput.inputInt(menuQuestion);
        if (subMenu == true && inputResult > 0 && inputResult < subMenus.size() + 1) {
            chosenVMenu = subMenus.get(inputResult - 1);
        } else {
            chosenVMenu = mParent;
        }

        return chosenVMenu;
    }
}