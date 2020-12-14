package view.menu;

import controllers.Controller;
import view.VMenu;

public class VMenuManual extends VMenu {


    /**
     * Constructors
     */
    public VMenuManual(VMenu parent) {
        super(parent);
        mMenuHeader = "Manual";
        mMenuLabel = "View manual";
        mMenuQuestion = "Enter choice";
        mMenuChoice = "X";
        mSubMenus = null;
//        mSubMenu = false;
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

        System.out.println(" ");
    }
}
