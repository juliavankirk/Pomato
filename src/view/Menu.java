package view;

public class Menu {

    VMenu mCurrentMenu;

    public Menu() {
        mCurrentMenu = new VMenuMain(null);
    }

    public void excecute() {

        while (mCurrentMenu != null) {
            mCurrentMenu = mCurrentMenu.renderMenu(true);
        }
    }
}