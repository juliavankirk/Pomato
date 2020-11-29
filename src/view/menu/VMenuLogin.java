package view.menu;

import controllers.Controller;
import view.VMenu;

import java.util.ArrayList;

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
        mSubMenus.add(new VMenuLoggedIn(this));
//        subMenus.add(new VMenuCommentBoard(this));
//        subMenu = true;
    }


    /**
     * Methods
     */
    @Override
    public void menuContent(Controller controller) {

//        String StringUserName = InputOutput.inputString("Enter Username");
//        UUID UUIDUserName = UUID.fromString(StringUserName);
//        String password = InputOutput.inputString("Enter Password");
//
//        String response = controller.logInUser(UUIDUserName, password);
//        System.out.println(response);
//
//        if (!(response.equals("Bravo! You logged in."))) {
//
//        }

    }
}
