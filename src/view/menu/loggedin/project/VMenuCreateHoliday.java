package view.menu.loggedin.project;

import controllers.Controller;
import model.project.Holiday;
import utilities.InputOutput;
import view.VMenu;

import java.time.LocalDate;
import java.util.ArrayList;

public class VMenuCreateHoliday extends VMenu {

    public VMenuCreateHoliday(VMenu parent) {
        super(parent);
        mMenuHeader = "Add Employee's Holidays";
        mMenuLabel = "Add Employee's Holidays";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;
    }
    @Override
    public void menuContent(Controller controller) {



        System.out.println("Please enter the following information\n ");

        String hName = InputOutput.inputString("Enter developers Username");
        String hDescription = InputOutput.inputString("Enter type of Holiday (e.g. parental leave)");
        LocalDate hStartDate = LocalDate.parse(InputOutput.inputString("Enter start date of the Holiday (yyyy-mm-dd)"));
        LocalDate hEndDate = LocalDate.parse(InputOutput.inputString("Enter end date of the Holiday (yyyy-mm-dd)"));
        controller.addHoliday(hName, hDescription, hStartDate, hEndDate);

        addMoreHolidays(controller);

    }

    private void addMoreHolidays (Controller controller) {
        String answer;

        answer = InputOutput.inputString("Would you like to add more Holidays?(yes/no)");
        while (answer.equals("yes")) {
            answer = "";
            menuContent(controller);
        }
/*
        public void viewUserList(Controller controller) {
            String


        }*/
    }
}

