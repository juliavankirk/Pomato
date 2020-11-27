//package view;
//
//import controllers.Controller;
//import model.users.User;
//import utilities.InputOutput;
//
//public class MenuRegister extends Action {
//
//    public MenuRegister(VMenu parent) {
//        super(parent);
//        actionHeader = "Register Form";
//        actionLabel = "Register";
//        actionQuestion = "Press any key to go back";
//        actionChoice = "R";
////        children = null;
//    }
//
//    @Override
//    public VMenu excecuteMenu(boolean line, Controller controller) {
//
//        // 1. Print the menu and handle input
//        System.out.println(InputOutput.line() + actionHeader + "\n");
//        System.out.println("Creating an account. Please enter the following information:\n ");
//        User user = getUserData();
//
//        // 2. Send the gathered data to be handled by the controller.
//        controller.addUser(user);
//
//        // 3. Choose next menu?
//        chooseMenu(mParent);
//
//        return mParent;
//    }
//
//    public User getUserData() {
//        String firstName, lastName, password, companyName, jobTitle;
//        Double hourlyWage;
//
//        //Randomize ID?
//        firstName = InputOutput.inputString("First Name: ");
//        lastName = InputOutput.inputString("\nLast Name: ");
//        companyName = InputOutput.inputString("\nCompany Name: ");
//        jobTitle = InputOutput.inputString("\nPosition: ");
//        hourlyWage = InputOutput.inputDouble("\nHourly wage: ");
//        password = InputOutput.inputString("\nPassword: ");
//
//        User user = new User( firstName, lastName, password, companyName, jobTitle, hourlyWage );
//
//        return user;
//    }
//
//    public void registerSuccess() {
//        System.out.println("Register success!");
//    }
//}
//
//
