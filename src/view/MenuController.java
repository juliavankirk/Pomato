//package view;
//
//import controllers.Controller;
//import view.menu.VMenuMain;
//
//public class MenuController {
//
//
//    /**
//     * Attributes
//     */
//    VMenu mCurrentMenu;
//
//
//    /**
//     * Constructors:
//     */
//    public MenuController() {
//        mCurrentMenu = new VMenuMain(null);
//    }
//
//
//    /**
//     * Methods
//     * I don't know if I like to have the loop like this here but it keeps everything very simple.
//     */
//    public void excecuteMenu(Controller controller) {
//
//        // This is the loop that keeps us within the different menu's
//        while (mCurrentMenu != null) {
//            mCurrentMenu = mCurrentMenu.executeMenu(controller);
//        }
//    }
//}