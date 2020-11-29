package view.menu;
import controllers.Controller;
import view.VMenu;

import java.util.ArrayList;

public class VMenuAccount extends VMenu {

    public VMenuAccount(VMenu parent) {
        super(parent);
        mMenuHeader = "User Account";
        mMenuLabel = "Handle user account";
        mMenuQuestion = "Enter choice";
        mSubMenus = new ArrayList<>();
        mSubMenus.add(new VMenuRemove(this));



    }

    @Override
    public void menuContent(Controller controller) {

    }
}

