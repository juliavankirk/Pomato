package view;

import controllers.Controller;

/**
 * Menu Controller? I don't know if I like to have the loop like this here but it keeps everything very simple.
 */

public class MenuController {

    VMenu mCurrentMenu;

    public MenuController() {
        mCurrentMenu = new VMenuMain(null);
    }

    public void excecute(Controller controller) {

        while (mCurrentMenu != null) {
            mCurrentMenu = mCurrentMenu.executeMenu(controller);
        }
    }
}