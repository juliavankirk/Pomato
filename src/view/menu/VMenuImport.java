package view.menu;

import controllers.Controller;
import view.VMenu;

import java.util.ArrayList;

public class VMenuImport extends VMenu {

    public VMenuImport(VMenu parent) {
        super(parent);
        mMenuHeader = "Import data";
        mMenuLabel = "Import data";
        mMenuQuestion = "Enter choice";
        mSubMenus = new ArrayList<>();

    }
    
    @Override
    public void menuContent(Controller controller) {
        System.out.println("The following information has been imported:\n" +
                "[User,FirstName,LastName,UserName,Password,CompanyName,Salary,JobTitle,Project1,Role1,Project2,Role2,...]\n");
        controller.loadDatabaseTwo();
    }
}
