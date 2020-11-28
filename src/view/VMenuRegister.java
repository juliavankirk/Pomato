package view;

import controllers.Controller;
import model.users.User;
import utilities.InputOutput;

public class VMenuRegister extends VMenu {


    /**
     * Controllers
     */

    public VMenuRegister(VMenu parent) {
        super(parent);
        menuHeader = "Register Form";
        menuLabel = "Register";
        menuQuestion = "Press any key to go back";
//        children = null;
    }


    /**
     * Methods
     */

    @Override
    public void menuContent(Controller controller) {
        String firstName, lastName, password, companyName, jobTitle;
        Double hourlyWage;

        // 1. Print the Menu Content and handle input
        System.out.println("Creating an account. Please enter the following information:\n ");

        firstName = InputOutput.inputString("First Name: ");
        lastName = InputOutput.inputString("\nLast Name: ");
        companyName = InputOutput.inputString("\nCompany Name: ");
        jobTitle = InputOutput.inputString("\nPosition: ");
        hourlyWage = InputOutput.inputDouble("\nHourly wage: ");
        password = InputOutput.inputString("\nPassword: ");
        User user = new User( firstName, lastName, password, companyName, jobTitle, hourlyWage );

        // 2. Send the gathered data to be handled by the controller.
        controller.addUser(user);

        System.out.println("");
    }

    public void registerSuccess() {
        System.out.println("Register success!");
    }
}


