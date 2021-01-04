package view.menu.loggedin.project;

import controllers.Controller;
import view.VMenu;

public class VMenuViewHolidays extends VMenu {

    public VMenuViewHolidays(VMenu parent) {
        super(parent);
        mMenuHeader = "View Employee's Holidays";
        mMenuLabel = "View Employee's Holidays";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;
    }

    @Override
    public void menuContent(Controller controller) {

        System.out.println(controller.getHolidayListFromCurrentProject());

    }


}
