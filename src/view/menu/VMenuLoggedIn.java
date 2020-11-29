package view.menu;

import controllers.Controller;
import view.*;

import java.util.ArrayList;

// When the user is logged in
public class VMenuLoggedIn extends VMenu {


    /**
     * Constructors
     */
    public VMenuLoggedIn(VMenu parent) {
        super(parent.getParentMenu());
        mMenuHeader = "Your Personal Menu";
        mMenuLabel = "Continue";
        mMenuQuestion = "Enter choice";
        mSubMenus = new ArrayList<>();
        mSubMenus.add(new VMenuProject(this));
        mSubMenus.add(new VMenuMessage(this));
        mSubMenus.add(new VMenuAccount(this));
//        subMenus.add(new VMenuManual(this));
//        subMenu = true;
    }


    /**
     * Methods
     */
    @Override
    public void menuContent(Controller controller) {

    }
}
