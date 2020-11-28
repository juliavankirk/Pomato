package view.submenu;

import controllers.Controller;
import utilities.InputOutput;
import view.VMenu;

import java.util.UUID;

public class VMenuRemove extends VMenu {
    public VMenuRemove(VMenu parent) {
        super(parent);
        menuHeader = "Remove Account";
        menuLabel = "Remove";
        menuQuestion = "Enter choice";
        subMenus = null;
        subMenu = false;
    }

    @Override
    public void menuContent(Controller controller) {
        System.out.println("Remove your account:\n ");

       String Id = InputOutput.inputString("Please enter your ID: ");
       controller.removeUser(Id);
    }
}
