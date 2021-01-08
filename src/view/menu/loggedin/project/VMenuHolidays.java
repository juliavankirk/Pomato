package view.menu.loggedin.project;

import controllers.Controller;
import view.VMenu;
import view.menu.loggedin.project.holidays.VMenuCreateHoliday;
import view.menu.loggedin.project.holidays.VMenuRemoveHoliday;
import view.menu.loggedin.project.holidays.VMenuViewHolidays;

import java.util.ArrayList;

public class VMenuHolidays extends VMenu {


    public VMenuHolidays(VMenu parent) {
        super(parent);
        mMenuHeader = "Employee's Holidays";
        mMenuLabel = "Employee's Holidays";
        mMenuQuestion = "Enter choice";
        mSubMenus = new ArrayList<>();
        mSubMenus.add(new VMenuViewHolidays(this));
        mSubMenus.add(new VMenuCreateHoliday(this));
        mSubMenus.add(new VMenuRemoveHoliday(this));

    }

    @Override
    public void menuContent(Controller controller) {


    }
}