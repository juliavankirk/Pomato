package view.menu;

import controllers.Controller;
import utilities.InputOutput;
import view.VMenu;

import java.util.ArrayList;

public class VMenuLogin extends VMenu {


    /**
     * Constructors
     */
    public VMenuLogin(VMenu parent) {
        super(parent);
        menuHeader = "Log-in";
        menuLabel = "Log-In";
        menuQuestion = "Enter choice";
        menuChoice = "L";
        subMenus = new ArrayList<>();
        subMenus.add(new VMenuLoggedIn(this));
//        subMenus.add(new VMenuCommentBoard(this));
//        subMenu = true;
    }


    /**
     * Methods
     */
    @Override
    public void menuContent(Controller controller) {

        String userName = InputOutput.inputString("Enter Username");
        String password = InputOutput.inputString("Enter Password");

        // TODO Check if user exists
        System.out.println(userName + " " + password);

        System.out.println(" ");
    }
}
