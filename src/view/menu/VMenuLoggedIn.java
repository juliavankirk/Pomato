package view.menu;

import controllers.Controller;
import view.*;

import java.util.ArrayList;

// When the user is logged in
public class VMenuLoggedIn extends VMenu {


    /**
     * Contructors
     */
    public VMenuLoggedIn(VMenu parent) {
        super(parent.getParentMenu());
        menuHeader = "Your Personal Menu";
        menuLabel = "Continue";
        menuQuestion = "Enter choice";
        subMenus = new ArrayList<VMenu>();
        subMenus.add(new VMenuProject(this));
        subMenus.add(new VMenuMessage(this));
//        subMenus.add(new VMenuManual(this));

        subMenu = true;
    }

    @Override
    public void menuContent(Controller controller) {

    }
}
