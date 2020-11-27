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
    public VMenu renderMenu(boolean line) {

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

        chooseMenu();

        return parent;
    }
}
