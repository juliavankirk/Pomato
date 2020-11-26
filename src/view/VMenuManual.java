package view;

import utilities.InputOutput;

public class VMenuManual extends VMenu {


    /**
     * Contructors
     */

    public VMenuManual(VMenu parent) {
        super(parent);
        menuHeader = "Manual";
        menuLabel = "View manual";
        menuQuestion = "";
        menuChoice = "X";
        children = null;
    }


    /**
     * Methods
     */

    @Override
    public void renderMenu(boolean line) {

        System.out.println(InputOutput.line() + menuHeader + "\n");

        System.out.println("Lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, \n" +
                "lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, \n" +
                "lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, \n" +
                "lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, \n" +
                "lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, \n" +
                "lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, \n" +
                "lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, \n" +
                "lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, \n"
        );
    }

    @Override
    public int readInput() {
        InputOutput.inputString("Press any key to continue");

        return 0;
    }
}
