package view.menu.loggedin.project;

import controllers.Controller;
import utilities.InputOutput;
import view.VMenu;

import java.util.ArrayList;

public class VMenuActivityLog extends VMenu {
    public VMenuActivityLog(VMenu parent) {
        super(parent);
        mMenuHeader = "Activity log";
        mMenuLabel = "View activity log";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;
    }

//
    @Override
    public void menuContent(Controller controller) {

        ArrayList<String> activityList = controller.getActivityListFromProject();

            for (String activity : activityList) {
                    System.out.print(InputOutput.superShortLine());
                    System.out.println(activity);
                }
            }
        }

