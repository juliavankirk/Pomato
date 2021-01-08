//package view.menu.loggedin.project;
//import utilities.InputErrors;
//import utilities.InputOutput;
//import view.VMenu;
//import controllers.Controller;
//import java.time.LocalDate;
//
//public class VMenuCreateSubtask extends VMenu {
//
//    VMenuCreateSubtask(VMenu parent) {
//        super(parent);
//        mMenuHeader = "Create Subtask";
//        mMenuLabel = "Create Subtask";
//        mMenuQuestion = "Enter choice";
//        mSubMenus = null;
//    }
//
//    @Override
//    public void menuContent(Controller controller) {
//        String title, description;
//        double estimatedTime;
//        LocalDate dueDate, startDate;
//        int priority;
//
//            System.out.println("Please enter the following information\n ");
//            title = InputErrors.emptyFieldString(InputOutput.inputString("Title"));
//            description = InputErrors.emptyFieldString(InputOutput.inputString("Description"));
//            estimatedTime = InputErrors.irrelevantDouble(InputOutput.inputString("Estimated Time (hours)"));
//            priority = InputOutput.inputIntMinMax("Priority (1-5)", 1, 5);
//
//          dueDate = InputErrors.checkDateFormat(InputOutput.inputString("Due Date (yyyy-mm-dd)"));
//          startDate = LocalDate.now();
//            while (dueDate.isBefore(LocalDate.now())){
//                dueDate = LocalDate.parse(InputOutput.inputString("Due Date must be later than start date. Please insert date one more time (yyyy-mm-dd)"));
//            }
//
//            //Do we have to initialize startDate? Its already set?
//
//            controller.addSubTask(title, description, dueDate, startDate, estimatedTime, priority);
//
//
//        addMoreTasks(controller);
//
//    }
//
//    private void addMoreTasks (Controller controller) {
//        String answer;
//
//        answer = InputErrors.incorrectYesOrNo(InputOutput.inputString("Would you like to add more subtasks?(yes/no)"));
//        while (answer.equals("yes")) {
//            answer = "";
//            menuContent(controller);
//        }
//    }
//}
