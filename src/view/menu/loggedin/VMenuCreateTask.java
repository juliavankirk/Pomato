package view.menu.loggedin;

import controllers.Controller;
import utilities.InputOutput;
import view.VMenu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class VMenuCreateTask extends VMenu {
    public VMenuCreateTask(VMenu parent) {
        super(parent);
        mMenuHeader = "Manage Project";
        mMenuLabel = "Assign Tasks";
        mMenuQuestion = "Enter choice";
    }

    @Override
    public void menuContent(Controller controller) {



    }
}
