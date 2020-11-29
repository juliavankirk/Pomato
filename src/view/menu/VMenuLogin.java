package view.menu;

import controllers.Controller;
import utilities.InputOutput;
import view.VMenu;

import java.util.ArrayList;
import java.util.UUID;

public class VMenuLogin extends VMenu {


    /**
     * Constructors
     */
    public VMenuLogin(VMenu parent) {
        super(parent);
        mMenuHeader = "Log-in";
        mMenuLabel = "Log-In";
        mMenuQuestion = "Enter choice";
        mMenuChoice = "L";
        mSubMenus = new ArrayList<>();
//        subMenus.add(new VMenuCommentBoard(this));
//        subMenu = true;
    }


    /**
     * Methods
     */
    @Override
    public void menuContent(Controller controller) {

        String StringUserName = InputOutput.inputString("Enter Username");
//        UUID UUIDUserName = UUID.fromString(StringUserName);
        String password = InputOutput.inputString("Enter Password");

        String response = controller.logInUser(StringUserName, password);
        System.out.println(response);

        if (!(response.equals("Bravo! You logged in."))) {

        }

        // if username exists then
//        if () {
//            mSubMenus.add(new VMenuLoggedIn(this));
//        }
    }
}
