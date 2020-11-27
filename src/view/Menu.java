package view;

import controllers.Controller;

public class Menu {

    VMenu mCurrentMenu;

    public Menu() {
        mCurrentMenu = new VMenuMain(null);
    }

    public void excecute(Controller controller) {

        while (mCurrentMenu != null) {
            mCurrentMenu = mCurrentMenu.executeMenu(controller);
        }
    }
}