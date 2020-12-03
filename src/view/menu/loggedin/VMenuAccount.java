package view.menu.loggedin;
import controllers.Controller;
import view.VMenu;
import view.menu.loggedin.account.VMenuRemoveUser;

import java.util.ArrayList;

public class VMenuAccount extends VMenu {

    public VMenuAccount(VMenu parent) {
        super(parent);
        mMenuHeader = "User Account";
        mMenuLabel = "Handle User account";
        mMenuQuestion = "Enter choice";
        mSubMenus = new ArrayList<>();
        mSubMenus.add(new VMenuRemoveUser(this));



    }

    @Override
    public void menuContent(Controller controller) {

    }
}

