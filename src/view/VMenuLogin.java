package view;

import utilities.InputOutput;

public class VMenuLogin extends VMenu {


    /**
     * Contructor
     */

    public VMenuLogin(VMenu parent) {
        super(parent);
        menuHeader = "Log-in";
        menuLabel = "Log-In";
        menuQuestion = "";
        menuChoice = "L";
        children = null;
    }


    /**
     * Methods
     */

    @Override
    public void renderMenu(boolean line) {
        System.out.println(InputOutput.line() + menuHeader + "\n");
    }

    @Override
    public int readInput() {
        InputOutput.inputString("Enter Username");

        InputOutput.inputString("Enter Password");

        return 0;
    }
}
