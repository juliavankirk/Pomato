package view;


import controllers.Controller;
import utilities.InputOutput;
import view.old.Action;

import java.util.ArrayList;

public abstract class VMenu {


    /**
     * Attribute
     */

    protected VMenu mParent;

    protected String menuHeader;
    protected String menuLabel;
    protected String menuQuestion;
    protected String menuChoice;

    protected ArrayList<VMenu> subMenus;
    protected boolean subMenu;

    protected ArrayList<Action> actions;


    /**
     * Contructors
     */

    public VMenu(VMenu parent) {
        mParent = parent;
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

    public VMenu chooseMenu(VMenu mParent) {
        VMenu chosenVMenu;

        int inputResult = InputOutput.inputInt(menuQuestion);
        if (inputResult > 0 && inputResult < subMenus.size() + 1){
            chosenVMenu = subMenus.get(inputResult - 1);
        } else {
            chosenVMenu = mParent;
        }

        return chosenVMenu;
    }

    public VMenu executeMenu(Controller controller) {

        System.out.println(InputOutput.line() + menuHeader + "\n");

        if (subMenu == true) {
            for (int i = 0; i < subMenus.size(); i++) {
                System.out.println((i + 1) + ". " + subMenus.get(i).menuLabel);
            }
        }

        if (mParent != null) {
            if (subMenu == true) {
                System.out.println((subMenus.size() + 1) + ". Go back");
            } else {
                System.out.println("1. Go back");
            }
        }
        System.out.println("");

        return chooseMenu(mParent);
    }

    //    public Action chooseAction(Action action) {
//        VAction chosenVAction;
//
//        int inputResult = InputOutput.inputInt(menuQuestion);
//        if (inputResult > 0 && inputResult < children.size() + 1){
//            chosenVMenu = children.get(inputResult - 1);
//        } else {
//            chosenVMenu = mParent;
//        }
//
//        return chosenVAction;
//    }
}