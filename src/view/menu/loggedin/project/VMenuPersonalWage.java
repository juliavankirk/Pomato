package view.menu.loggedin.project;

import controllers.Controller;
import utilities.InputErrors;
import utilities.InputOutput;
import view.VMenu;

public class VMenuPersonalWage extends VMenu {


    public VMenuPersonalWage(VMenu parent) {
        super(parent);
        mMenuHeader = "Your Total Wage";
        mMenuLabel = "View Total Wage";
        mMenuQuestion = "Enter choice";
    }

    @Override
    public void menuContent(Controller controller) {
        double hours;
        System.out.println("Please enter the following information\n ");

        hours = InputErrors.irrelevantDouble(InputOutput.inputString("Hours"));

        String messageToUser = controller.calculateHours(hours);
        System.out.println(messageToUser);

//        userId = User.getId();
//        controller.addHours(hours);

        // Input hours they have worked
        // Save it in an attribute on the user
        //


        //addMoreTasks(controller);
    }
}
