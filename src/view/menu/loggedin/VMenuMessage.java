package view.menu.loggedin;

import controllers.Controller;
import model.project.Messages;
import model.users.User;
import utilities.InputOutput;
import view.VMenu;

import java.util.ArrayList;
import java.util.UUID;

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
        int optionSelect = InputOutput.inputInt("Select one of the following options:\n" +
                "1. Send a message\n" +
                "2. View inbox\n" +
                "3. Delete a message\n" +
                "4. Return to previous menu\n");

        switch (optionSelect) {
            case 1 -> {
                String recipient = InputOutput.inputString(
                        "Enter recipient username for this message");

                String subject = InputOutput.inputString("Enter message subject");
                String content = InputOutput.inputString("Enter message body");
                controller.sendMessage(recipient, subject, content);
            }

            case 2 -> {
                System.out.println("Inbox");
                controller.showMessages();
                String input = InputOutput.inputString("Enter message you would like to view");
                controller.viewMessage(input);
            }

            case 3 -> {
                System.out.println("Delete a message");
                controller.showMessages();
                String delete = InputOutput.inputString("Select the message you would like to remove");
                controller.deleteMessage(delete);

            }

            case 4 -> {

            }
        }


        // TODO personal message center?
    }
}
