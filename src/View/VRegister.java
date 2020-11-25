package View;

import Model.Users.User;
import Utilities.Utilities;
import jdk.jshell.execution.Util;

public class VRegister {
    public User getUserData() {
        String firstName, lastName, password, companyName, jobTitle;
        Double hourlyWage;

        System.out.println(Utilities.line() + "Creating an account. Please enter the following information:\n ");
        //Randomize ID?
        System.out.println(Utilities.line() + "First Name: ");
        firstName = Utilities.stringInput();
        System.out.println(Utilities.line() + "\nLast Name: ");
        lastName = Utilities.stringInput();
        System.out.println(Utilities.line() + "\nCompany Name: ");
        companyName = Utilities.stringInput();
        System.out.println(Utilities.line() + "\nPosition: ");
        jobTitle = Utilities.stringInput();
        System.out.println(Utilities.line() + "\nHourly wage: ");
        hourlyWage = Utilities.doubleInput();
        System.out.println(Utilities.line() + "\nPassword: ");
        password = Utilities.stringInput();

        User user = new User( firstName, lastName, password, companyName, jobTitle, hourlyWage );

        return user;
    }

    public void registerSuccess() {
        System.out.println("Register success!");
    }
}


