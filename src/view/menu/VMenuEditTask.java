package view.menu;
import utilities.InputOutput;
import view.VMenu;
import controllers.Controller;

public class VMenuEditTask extends VMenu {

    VMenuEditTask(VMenu parent){
        super(parent);
        mMenuHeader = "Edit Task";
        mMenuLabel = "Edit Task";
        mMenuQuestion = "Enter choice";
        mSubMenus = null;
    }
    @Override
    public void menuContent(Controller controller) {

    }

}
