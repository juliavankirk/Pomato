import controllers.Controller;
import view.MenuController;

/**
 * My reason for this class is that I couldn't
 */

public class PomatoApp {

    Controller controller;
    MenuController menuController;

    public void runProgram() {
        controller = new Controller();
        menuController = new MenuController();
        menuController.excecute(controller);
    }
}
