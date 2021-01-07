package view.menu.loggedin;

import controllers.Controller;
import utilities.InputErrors;
import utilities.InputOutput;
import view.VMenu;

public class VMenuMessage extends VMenu {


    /**
     * Constructors
     */
    public VMenuMessage(VMenu parent) {
        super(parent);
        mMenuHeader = "Messages";
        mMenuLabel = "Messages";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;
//        subMenu = false;
    }

    @Override
    public void menuContent(Controller controller) {
        int optionSelect = InputErrors.irrelevantInt(InputOutput.inputString("Select one of the following options:\n" +
                "1. Send a message\n" +
                "2. View inbox\n" +
                "3. Delete a message\n" +
                "4. Return to previous menu\n"));

        switch (optionSelect) {
            case 1 -> {
                String recipient = InputErrors.emptyFieldString(InputOutput.inputString(
                        "Enter recipient username for this message"));

                String subject = InputErrors.emptyFieldString(InputOutput.inputString("Enter message subject"));
                String content = InputErrors.emptyFieldString(InputOutput.inputString("Enter message body"));
                controller.sendMessage(recipient, subject, content);
            }

            case 2 -> {
                System.out.println("Inbox");
                controller.showMessages();
                String input = InputErrors.emptyFieldString(InputOutput.inputString("Enter message you would like to view"));
                controller.viewMessage(input);
            }

            case 3 -> {
                System.out.println("Delete a message");
                controller.showMessages();
                String delete = InputErrors.emptyFieldString(InputOutput.inputString("Select the message you would like to remove"));
                controller.deleteMessage(delete);

            }

            case 4 -> {

            }
        }


        // TODO personal message center?

    }
}
