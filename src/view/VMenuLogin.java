package view;

import controllers.Controller;
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
        menuQuestion = "Enter choice";
        menuChoice = "L";
        children = new ArrayList<VMenu>();
        children.add(new VMenuLoggedIn(this));
    }


    /**
     * Methods
     */

    @Override
    public void menuContent(Controller controller) {

        String userName = InputOutput.inputString("Enter Username");
        String password = InputOutput.inputString("Enter Password");

        // TODO Check if user exists

        System.out.println("");
    }
}
