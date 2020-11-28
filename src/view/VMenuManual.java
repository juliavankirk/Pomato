package view;

import controllers.Controller;
import utilities.InputOutput;

public class VMenuManual extends VMenu {


    /**
     * Contructors
     */

    public VMenuManual(VMenu parent) {
        super(parent);
        menuHeader = "Manual";
        menuLabel = "View manual";
        menuQuestion = "Enter choice";
        menuChoice = "X";
        subMenus = null;
        subMenu = false;
    }


    /**
     * Methods
     */

    @Override
    public void menuContent(Controller controller) {

        System.out.println("Lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, \n" +
                "lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, \n" +
                "lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, \n" +
                "lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, \n" +
                "lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, \n" +
                "lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, \n" +
                "lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, \n" +
                "lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, lorem ipsum, \n"
        );

        System.out.println("");
    }
}
