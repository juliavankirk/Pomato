package view.menu.loggedin.project;

import controllers.Controller;
import view.VMenu;

import java.util.ArrayList;

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

        ArrayList<Holiday> holidayList = controller.getHolidayListFromCurrentProject();

        for (Holiday holiday : holidayList) {
            System.out.print(InputOutput.superShortLine());
            System.out.println(holiday);


        }


    }
}
