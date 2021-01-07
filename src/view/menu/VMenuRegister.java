package view.menu;

import controllers.Controller;
import utilities.InputErrors;
import utilities.InputOutput;
import view.VMenu;

import java.util.ArrayList;

public class VMenuRegister extends VMenu {


    /**
     * Controllers
     */

    public VMenuRegister(VMenu parent) {
        super(parent);
        mMenuHeader = "Register Form";
        mMenuLabel = "Register";
        mMenuQuestion = "Enter Choice";
        mSubMenus = new ArrayList<>();
//        children = null;
    }


    /**
     * Methods
     */

    @Override
    public void menuContent(Controller controller) {
        String userName, firstName, lastName, password, companyName, jobTitle;
        double hourlyWage;

        // 1. Print the Menu Content and handle input
        System.out.println("Creating an account. Please enter the following information:\n ");


        firstName = InputErrors.emptyFieldString(InputOutput.inputString("First Name"));
        lastName = InputErrors.emptyFieldString(InputOutput.inputString("Last Name"));
        companyName = InputErrors.emptyFieldString(InputOutput.inputString("Company Name"));
        jobTitle = InputErrors.emptyFieldString(InputOutput.inputString("Position"));
        hourlyWage = InputErrors.irrelevantDouble(InputOutput.inputString("Hourly wage"));
        userName = InputErrors.emptyFieldString(InputOutput.inputString("Username"));
        String message = controller.checkUsername(userName);
        while (!message.equals(userName)) {
            System.out.println(message);
            userName = InputErrors.emptyFieldString(InputOutput.inputString("Username"));
            message = controller.checkUsername(userName);
        }
        password = InputErrors.emptyFieldString(InputOutput.inputString("Password"));

        // 2. Send the gathered data to be handled by the controller.
        controller.addUser(userName, firstName, lastName, password, companyName, hourlyWage, jobTitle );

        System.out.println("");
    }


//    public void registerSuccess() {
//        System.out.println("Register success!");
//    }
}


