package view;

import model.users.User;
import utilities.InputOutput;

public class VMenuRegister extends VMenu {

    public VMenuRegister(VMenu parent) {
        super(parent);
        menuHeader = "Register Form";
        menuLabel = "Register";
        menuQuestion = "";
        menuChoice = "R";
        children = null;
    }

    @Override
    public void renderMenu(boolean line) {
        System.out.println(InputOutput.line() + menuHeader + "\n");
        System.out.println("Creating an account. Please enter the following information:\n ");
    }

    @Override
    public int readInput() {
        return 0;
    }

    public User getUserData() {
        String firstName, lastName, password, companyName, jobTitle;
        Double hourlyWage;

        //Randomize ID?
        firstName = InputOutput.inputString("First Name: ");
        lastName = InputOutput.inputString("\nLast Name: ");
        companyName = InputOutput.inputString("\nCompany Name: ");
        jobTitle = InputOutput.inputString("\nPosition: ");
        hourlyWage = InputOutput.inputDouble("\nHourly wage: ");
        password = InputOutput.inputString("\nPassword: ");

        User user = new User( firstName, lastName, password, companyName, jobTitle, hourlyWage );

        return user;
    }

    public void registerSuccess() {
        System.out.println("Register success!");
    }
}


