package view.menu.loggedin.project.holidays;

import controllers.Controller;
import utilities.InputErrors;
import utilities.InputOutput;
import view.VMenu;

import java.time.LocalDate;

public class VMenuCreateHoliday extends VMenu {

    public VMenuCreateHoliday(VMenu parent) {
        super(parent);
        mMenuHeader = "Add Employee's Holidays";
        mMenuLabel = "Manager: Add Employee's Holidays";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;
    }
    @Override
    public void menuContent(Controller controller) {

        if(controller.getCurrentUser().getRole(controller.getCurrentProject().getId().toString()).equals("Manager")) {
            String answer = "yes";
            if (answer.equals("yes")) {

                System.out.println("Please enter the following information\n ");

                String hName = InputErrors.emptyFieldString(InputOutput.inputString("Enter developers Username"));
                String hDescription = InputErrors.emptyFieldString(InputOutput.inputString("Enter type of Holiday (e.g. parental leave)"));
                LocalDate hStartDate = InputErrors.checkDateFormat(InputOutput.inputString("Enter start date of the Holiday (yyyy-mm-dd)"));
                LocalDate hEndDate = InputErrors.checkDateFormat(InputOutput.inputString("Enter end date of the Holiday (yyyy-mm-dd)"));
                while (hEndDate.isEqual(hStartDate) || hEndDate.isBefore(hStartDate)){
                    hStartDate = InputErrors.checkDateFormat(InputOutput.inputString("End date must be later than start" +
                            " date. Please insert dates one more time.\n Start date"));
                    hEndDate = InputErrors.checkDateFormat(InputOutput.inputString("End date"));
                }
                controller.addHoliday(hName, hDescription, hStartDate, hEndDate);

                addMoreHolidays(controller);
                }


        } else {
            System.out.println("You do not have the authority to make changes in this section. Because you are nothing more " +
                    "than a poor developer.");
        }
        System.out.println(" ");

    }

    private void addMoreHolidays (Controller controller) {
        String answer;

        answer = InputErrors.incorrectYesOrNo(InputOutput.inputString("Would you like to add more Holidays?(yes/no)"));
        while (answer.equals("yes")) {
            answer = " ";
            menuContent(controller);
        }

        }

        }



