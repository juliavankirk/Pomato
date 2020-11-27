import controllers.Controller;
import view.Menu;

public class PomatoApp {

    Controller controller;
    Menu menu;

    public void runProgram() {
        controller = new Controller();
        menu = new Menu();
        menu.excecute(controller);
    }
}
