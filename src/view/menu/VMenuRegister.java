package view.menu;

import controllers.Controller;
import utilities.InputOutput;
import view.VMenu;

public class VMenuRegister extends VMenu {


    /**
     * Controllers
     */

    public VMenuRegister(VMenu parent) {
        super(parent);
        mMenuHeader = "Register Form";
        mMenuLabel = "Register";
        mMenuQuestion = "Enter Choice";
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


        firstName = InputOutput.inputString("First Name");
        lastName = InputOutput.inputString("Last Name");
        companyName = InputOutput.inputString("Company Name");
        jobTitle = InputOutput.inputString("Position");
        hourlyWage = InputOutput.inputDouble("Hourly wage");
        userName = InputOutput.inputString("Username");
        while (controller.checkUsername(userName).equals("This username is taken before. Please select another username.")) {
            userName = InputOutput.inputString("Username");
        }
        password = InputOutput.inputString("Password");

        // 2. Send the gathered data to be handled by the controller.
        controller.addUser(userName, firstName, lastName, password, companyName, hourlyWage, jobTitle );

        System.out.println("");
    }


//    public void registerSuccess() {
//        System.out.println("Register success!");
//    }
}


