package view;

import utilities.InputOutput;
import view.submenu.VMenuLoggedIn;

import java.util.ArrayList;

public class VMenuLogin extends VMenu {


    ArrayList<VMenu> children;

    /**
     * Contructor
     */

    public VMenuLogin(VMenu parent) {
        super(parent);
        menuHeader = "Log-in";
        menuLabel = "Log-In";
        menuQuestion = "Are you sure this is the account details you want to use?(Yes/No)";
        menuChoice = "L";
        children = new ArrayList<VMenu>();
        children.add(new VMenuLoggedIn(this));
    }


    /**
     * Methods
     */

    @Override
    public VMenu renderMenu(boolean line) {
        System.out.println(InputOutput.line() + menuHeader + "\n");

        chooseMenu();

        return parent;
    }

//    @Override
//    public int readInput() {
//        InputOutput.inputString("Enter Username");
//
//        InputOutput.inputString("Enter Password");
//
//        VMenu chosenVMenu = parent;
//        chosenVMenu.renderMenu(true);
//        chosenVMenu.readInput();
//        return 0;
//    }
}
