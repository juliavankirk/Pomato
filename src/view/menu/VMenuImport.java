package view.menu;

import controllers.Controller;
import utilities.JsonHandler;
import view.VMenu;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class VMenuImport extends VMenu {

    public VMenuImport(VMenu parent) {
        super(parent);
        mMenuHeader = "Imported data";
        mMenuLabel = "Imported data";
        mMenuQuestion = "Enter choice";
        mSubMenus = new ArrayList<>();

    }
    
    @Override
    public void menuContent(Controller controller) {
//        System.out.println("The following information has been imported:\n" +
//                "[User,FirstName,LastName,UserName,Password,CompanyName,Salary,JobTitle,Project1,Role1,Project2,Role2,...]\n");
//        controller.loadDatabaseTwo();

        System.out.println("The following information has been imported:\n");
        JsonHandler jsonHandler = new JsonHandler();
        try {
            System.out.println(jsonHandler.printDatabase());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        controller.loadJSON();
    }
}
