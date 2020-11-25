package View;


import Utilities.Utilities;

public class VMainMenu {
    public void render() {
        System.out.println(Utilities.line() + "Main Menu:\n" +
                "Welcome to Pomato, your good old game rental system. The competition has no steam to keep up!\n" +
                "\n" +
                "Please choose from one of the options given below:\n" +
                "1. Register\n" + //Password = "admin1234"
                "2. Log-in\n" + //Password = "password123"
                "3. User Manual\n" +
                "X. Exit system \n");
    }

    public void renderExit() {
        System.out.println("Exiting the system. Goodbye!");
    }


    public void renderError() {
        System.out.println("Invalid selection, restarting...");
    }

    public String read() {
       String mainMenuSelect = Utilities.stringInput();

        return mainMenuSelect;
    }
}
