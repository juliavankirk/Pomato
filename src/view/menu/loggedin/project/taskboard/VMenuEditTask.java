package view.menu.loggedin.project.taskboard;

import controllers.Controller;
import model.project.Task;
import utilities.InputErrors;
import utilities.InputOutput;
import view.VMenu;

import java.time.LocalDate;

public class VMenuEditTask extends VMenu {


    /**
     * Contructors
     */
    public VMenuEditTask(VMenu parent) {
        super(parent);
        mMenuHeader = "Edit Task";
        mMenuLabel = "Edit Task";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;
    }

    @Override
    public void menuContent(Controller controller) {
        //TODO


        String taskId, checklistId, itemId, message,id, response, topic, updatedTitle, updatedDescription, updatedStatus, updatedName, updatedTopic;
        double updatedEstimation;
        LocalDate updatedDueDate;
        int property, updatedPriority;

        taskId = InputErrors.emptyFieldString(InputOutput.inputString("Which task do you want to edit? (ID)"));
        Task task = controller.getTaskById(taskId);

        /*When the user have made a change to a property, they will be given the option
        to make another change to the chosen task, until they enter the number 7.
         */
        if (task != null) {
            do {
                propertyChoices();
                property = InputErrors.irrelevantInt(InputOutput.inputString("Enter your option"));


                    switch (property) {
                        case 1 -> {
                            updatedTitle = InputErrors.emptyFieldString(InputOutput.inputString("Enter new title"));
                            controller.updateTaskTitle(updatedTitle, taskId);
                        }
                        case 2 -> {
                            updatedDescription = InputErrors.emptyFieldString(InputOutput.inputString("Enter " +
                                    "new description"));
                            controller.updateTaskDescription(updatedDescription, taskId);
                        }
                        case 3 -> {
                            updatedStatus = InputErrors.incorrectStatus(InputOutput.inputString("Enter " +
                                    "new Status(TODO, IN PROGRESS or COMPLETED)"));
                            controller.updateTaskStatus(updatedStatus, taskId);
                        }
                        case 4 -> {
                            updatedEstimation = InputErrors.irrelevantDouble(InputOutput.inputString("Enter new " +
                                    "Estimated Time(hours)"));
                            controller.updateTaskEstimatedTime(updatedEstimation, taskId);
                        }
                        case 5 -> {
                            updatedPriority = InputErrors.inRangeIntInput(InputErrors.irrelevantInt(InputOutput.inputString("Enter new Priority(1-5)")),
                                    6, 0);
                            controller.updateTaskPriority(updatedPriority, taskId);
                        }
                        case 6 -> {
                            updatedDueDate = InputErrors.checkDateFormat(InputOutput.inputString("Enter new Due Date (yyyy-mm-dd)"));
//                            while (updatedDueDate.isBefore(task.getStartDate())) {
//                                updatedDueDate = LocalDate.parse(InputOutput.inputString("Due date must be later than start date. Please enter new Due Date one more time (yyyy-mm-dd)\n"));
//                            }

                            controller.updateTaskDueDate(updatedDueDate, taskId);
                        }

                        case 7 -> {
                            checklistId = InputErrors.emptyFieldString(InputOutput.inputString("Please enter checklist ID"));
                            message = controller.removeChecklist(checklistId, taskId);
                            System.out.println(message);

                        }

                        case 8 -> {
                            checklistId = InputErrors.emptyFieldString(InputOutput.inputString("Please enter checklist ID"));
                            updatedName = InputErrors.emptyFieldString(InputOutput.inputString("Please enter new checklist name"));
                            controller.updateChecklistName(updatedName,checklistId, taskId);
                        }

                        case 9 -> {
                            checklistId = InputErrors.emptyFieldString(InputOutput.inputString("Please enter checklist ID"));
                            itemId = InputErrors.emptyFieldString(InputOutput.inputString("Please enter checklist item number"));
                            message = controller.removeChecklistItem(checklistId, itemId, taskId);
                            System.out.println(message);
                            //Remove checklist items
                        }

                        case 10 -> {
                            checklistId = InputErrors.emptyFieldString(InputOutput.inputString("Please ente" +
                                    "r checklist ID you would like to add items to"));
                            System.out.println("Please enter the following information\n ");
                            id = InputErrors.emptyFieldString(InputOutput.inputString("Id"));
                            message = controller.checkItemId(id, checklistId, taskId);
                            System.out.println(message);
                            if (!message.equals("The checklist Id is invalid.")) {
                                topic = InputErrors.emptyFieldString(InputOutput.inputString("Topic"));
                                controller.addChecklistItems(checklistId, taskId, topic, id);
                            }
                        }

                        case 11 ->{
                            checklistId = InputErrors.emptyFieldString(InputOutput.inputString("Please enter checklist ID"));
                            itemId = InputErrors.emptyFieldString(InputOutput.inputString("Please enter checklist item number"));
                            response = InputErrors.incorrectYesOrNo(InputOutput.inputString("Would you like to change" +
                                    " item status to Done? Enter yes"));
                            if ( response.equalsIgnoreCase("yes"));
                            controller.updateItemStatus(checklistId,taskId,itemId);

                            //Change item status
                        }

                        case 12 -> {
                            checklistId = InputErrors.emptyFieldString(InputOutput.inputString("Please enter checklist ID"));
                            itemId = InputErrors.emptyFieldString(InputOutput.inputString("please enter checklist item ID"));
                            updatedTopic = InputErrors.emptyFieldString(InputOutput.inputString("Please enter new item topic"));
                            controller.updateItemTopic(updatedTopic,checklistId,taskId,itemId);
                            // Change item topic
                        }

                        case 13 -> {
                            // A case so that the user can leave this section.
                        }
                        default -> {
                            System.out.println("Invalid option");
                        }
                        //TODO Edit task
                    }
                } while (property != 13);

            } else {
                System.out.println("invalid id, please enter another id");
            }
        }


    public void propertyChoices() {

        String propertyC = "Which property would you like to change? Type one of the options below:\n" +
                "1. Change Task Title\n" +
                "2. Change Task Description\n" +
                "3. Change Task Status\n" +
                "4. Change Task Estimated time\n" +
                "5. Change Task Priority\n" +
                "6. Change Task Due Date\n"+
                "--------------------\n" +
                "7. Remove checklist\n"+
                "8. Change checklist name\n" +
                "9. Remove checklist items\n" +
                "10.Add checklist items\n" +
                "11.Change item status\n" +
                "12.Change item topic\n" +
                "--------------------\n" +
                "13. Done\n"; /*Not sure about naming it "return", since they get an option
            afterwards which is go back, maybe Done?*/

        System.out.println(propertyC);
    }
}