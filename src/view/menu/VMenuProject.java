package view.menu;

import controllers.Controller;
import view.VMenu;

import java.util.ArrayList;

public class VMenuProject extends VMenu {

    /**
     * Contructors
     */
    public VMenuProject(VMenu parent) {
        super(parent);
        menuHeader = "Project Page";
        menuLabel = "View Project";
        menuQuestion = "Enter choice";
        subMenus = new ArrayList<VMenu>();
        subMenus.add(new VMenuCommentBoard(this));
        subMenus.add(new VMenuTaskBoard(this));

        subMenu = true;
    }

    @Override
    public void menuContent(Controller controller) {

    }
}
