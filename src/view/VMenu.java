package view;


import controllers.Controller;
import utilities.InputErrors;
import utilities.InputOutput;

import java.util.ArrayList;

public abstract class VMenu {


    /**
     * Attribute
     */

    protected VMenu mParentMenu;

    protected String mMenuHeader;
    protected String mMenuLabel;
    protected String mMenuQuestion;
    protected String mMenuChoice;

    protected ArrayList<VMenu> mSubMenus;
//    protected boolean subMenu;


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
     *  Then, in all menu's, we are asked a question. Example "Enter "menu" choice:"...
     *
     *  1. Execute menu (Print, Input, Send data to be handled by controller)
     *  2. Choose sub-menu or "Go back".
     *
     */

    // 1. This handles executing a menu
    public VMenu executeMenu(Controller controller) {

        // 2. Every Menu has a header.
        System.out.print(InputOutput.line() + mMenuHeader + "\n");
        // System.out.print(InputOutput.superSuperShortLine());
        // Custom length on LINE instead of above code
//        for (int i = 0; i < mMenuHeader.length(); i++) {
//            System.out.print("--");
//        }
//        System.out.println( "\n" + mMenuHeader);

        // 3. This handles any extra choices in the menu.
        menuContent(controller);

        // 4. This prints Sub Menu choices. But only if the menu has Sub Menu's
        if (mSubMenus != null) {
            // System.out.print(InputOutput.superSuperShortLine());
            // Custom length on LINE instead of above code
            for (int i = 0; i < mMenuHeader.length(); i++) {
                System.out.print("-");
            }
            System.out.print("\n");

            for (int i = 0; i < mSubMenus.size(); i++) {
                System.out.println((i + 1) + ". " + mSubMenus.get(i).mMenuLabel);
            }
        }

        // 5. This method only runs if we are in a Sub Menu. Main Menu can't have "Go back".
        if (mParentMenu != null) {

            if (mSubMenus != null) {
                System.out.println((mSubMenus.size() + 1) + ". Go back");
            } else {
                System.out.print(InputOutput.superSuperShortLine());
                System.out.println("1. Go back");
            }
        }
        System.out.println(" ");

        // 6. We go to the last method that handles asking a question to the user.
        return chooseMenu(mParentMenu, controller);
    }

    // 3. A Menu can choose it's own content.
    public abstract void menuContent(Controller controller);

    // 6. A menu at last contains a question. Where do you want to go?
    public VMenu chooseMenu(VMenu mParent, Controller controller) {
        VMenu chosenVMenu;
        int inputResult;

        if(mSubMenus != null) {
            inputResult = InputErrors.checkMenuChoice(InputOutput.inputString(mMenuQuestion), mSubMenus.size() + 2, 0);
        } else {
            inputResult = InputErrors.checkMenuChoice(InputOutput.inputString(mMenuQuestion), 2, 0);
        }

        if (mSubMenus != null && inputResult > 0 && inputResult < mSubMenus.size() + 1) {

            chosenVMenu = mSubMenus.get(inputResult - 1);
        } else {
            chosenVMenu = mParent;
        }

        return chosenVMenu;
    }

    public VMenu getParentMenu() {
        return mParentMenu;
    }

    public String getmMenuHeader() {
        return mMenuHeader;
    }

    public void setmMenuHeader(String menuHeader) {
        mMenuHeader = menuHeader;
    }

    public String getmMenuLabel() {
        return mMenuLabel;
    }

    public void setmMenuLabel(String menuLabel) {
        mMenuLabel = menuLabel;
    }
}