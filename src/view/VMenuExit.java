package view;

import utilities.InputOutput;

public class VMenuExit extends VMenu {



    /**
     * Contructors
     */

    public VMenuExit(VMenu parent) {
        super(parent);
        menuHeader = "Exit";
        menuLabel = "Exit Pomato";
        menuQuestion = "";
        menuChoice = "E";
        children = null;
    }


    /**
     * Methods
     */

    @Override
    public void renderMenu(boolean line) {
        if (line = true) {
            System.out.println("--------------------------------------------");
        }
        System.out.println(menuHeader + "\n");
    }

    @Override
    public int readInput() {
        String yesNo = InputOutput.inputString("Are you sure you want to exit?(Yes/No)");

        if (yesNo.equalsIgnoreCase("YES")) {
            System.exit(0);
        }

        return 0;
    }
}
