package view.menu.loggedin.project;

import controllers.Controller;
import model.users.User;
import utilities.InputOutput;
import view.VMenu;

import java.time.LocalDate;

public class VMenuPersonalWage extends VMenu {


    public VMenuPersonalWage(VMenu parent) {
        super(parent);
        mMenuHeader = "Your Total Wage";
        mMenuLabel = "View Total Wage";
        mMenuQuestion = "Enter choice";


    }
    @Override
    public void menuContent(Controller controller) {
        double hours; String userId;

        System.out.println("Please enter the following information\n ");
        userId = InputOutput.inputString("Enter your User ID");
        hours = InputOutput.inputDouble("Hours");

        String messageToUser = controller.calculateHours(userId, hours);
        System.out.println(messageToUser);

//        userId = User.getId();
//        controller.addHours(hours);

        // Input hours they have worked
        // Save it in an attribute on the user
        //


        //addMoreTasks(controller);
    }
}
