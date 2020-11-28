import controllers.Controller;
//import view.MenuController;

/**
 * My reason for this class is that I couldn't
 */

public class PomatoApp {

    Controller controller;
//    MenuController menuController;

    public void runProgram() {
        controller = new Controller();
        controller.executeViews(controller);
//        menuController = new MenuController();
//        menuController.excecuteMenu(controller);
    }
}
