import Model.Project.Database;
import Model.Project.Project;
import Model.Users.Employee;
import Model.Users.User;
import View.VMainMenu;

import javax.xml.crypto.Data;

public class Controller {
    //Attributes
    Database mDatabase;
    VMainMenu mVMainMenu;


    //Constructor
    public Controller() {
        mDatabase = new Database();
        mVMainMenu = new VMainMenu();
    }

    public void main() {
        System.out.println("Welcome to Pomato!\n");

        doMainMenu();
    }

    void doMainMenu() {

        String password;
        mVMainMenu.render();
        String mainMenuSelect = mVMainMenu.read();

        switch (mainMenuSelect) {
            case "1" -> {

            }
            case "2" -> {

            }
            case "3" -> {

            }
            case "X" -> {

            }
        }
    }

}
